package com.caue.kioski.services;
import com.caue.kioski.models.Cart;
import com.caue.kioski.interfaces.ReceiptRepository;

import java.nio.file.Path;

public class ReceiptSaver {
    private final ReceiptService service;
    private final ReceiptRepository repo;
    public ReceiptSaver(ReceiptService service, ReceiptRepository repo){
        this.service = service; this.repo = repo;
    }
    public Path renderAndSave(Cart cart) throws Exception {
        var lines = service.render(cart);
        return repo.save(lines);
    }
}

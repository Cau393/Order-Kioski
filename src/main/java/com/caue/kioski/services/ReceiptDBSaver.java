package com.caue.kioski.services;

import com.caue.kioski.interfaces.ReceiptDbRepository;
import com.caue.kioski.models.Cart;

import java.math.BigDecimal;

public class ReceiptDBSaver {
    private final ReceiptService service;
    private final ReceiptDbRepository db;
    public ReceiptDBSaver(ReceiptService service, ReceiptDbRepository db){ this.service = service; this.db = db; }

    public long renderAndSave(Cart cart, String customerName) throws Exception {
        var lines = service.render(cart);
        BigDecimal sub = cart.getSubtotal();
        // If your ReceiptService already computes tax and total for you, you can parse from the lines
        // Here we recompute using the same inputs to keep it simple
        // The service has a TaxCalculator inside, so tax is consistent
        var last4 = lines.subList(lines.size() - 3, lines.size());
        String subtotalText = last4.get(0).replaceAll("[^0-9.]+", "");
        String taxText = last4.get(1).replaceAll("[^0-9.]+", "");
        String totalText = last4.get(2).replaceAll("[^0-9.]+", "");
        return db.save(lines, customerName == null ? "Guest" : customerName, subtotalText, taxText, totalText);
    }
}
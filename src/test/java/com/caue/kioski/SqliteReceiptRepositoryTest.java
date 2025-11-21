package com.caue.kioski;

import com.caue.kioski.models.Cart;
import com.caue.kioski.models.Category;
import com.caue.kioski.models.FlatRateTaxCalculator;
import com.caue.kioski.models.MenuItem;
import com.caue.kioski.repo.SqliteReceiptRepository;
import com.caue.kioski.services.ReceiptDBSaver;
import com.caue.kioski.services.ReceiptService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class SqliteReceiptRepositoryTest {
    @TempDir
    Path temp;

    @Test
    void saves_receipt_and_returns_id() throws Exception {
        // Arrange
        Cart cart = new Cart();
        cart.add(new MenuItem("Americano", new BigDecimal("3.50"), Category.COFFEE), 2);
        ReceiptService svc = new ReceiptService(new FlatRateTaxCalculator(new BigDecimal("0.06")));
        Path dbPath = Paths.get("receipts.db");  // Creates in current working directory
        var repo = new SqliteReceiptRepository(dbPath);
        var saver = new ReceiptDBSaver(svc, repo);

        // Act
        long id = saver.renderAndSave(cart, "Alice");

        // Assert
        assertTrue(id > 0);
    }
}
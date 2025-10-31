package com.caue.kioski;
import com.caue.kioski.models.*;
import com.caue.kioski.repo.*;
import com.caue.kioski.services.ReceiptService;
import org.junit.jupiter.api.*;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class TaxAndReceiptTest
{
    @Test void totals_and_tax()
    {
        var repo = new InMemoryCatalogRepository();
        var cart = new Cart();
        var cartItem = repo.all().getFirst();
        var price = cartItem.getPrice();
        price = price.multiply(new BigDecimal(2.12));

        cart.add(repo.all().getFirst(), 2); // coffee

        var svc = new ReceiptService(new FlatRateTaxCalculator(new BigDecimal("0.06")));

        var lines = svc.render(cart);

        assertTrue(lines.getLast().contains("Total:"));
        assertTrue(lines.getLast().contains(price.toString()));
    }
}

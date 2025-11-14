package com.caue.kioski;

import com.caue.kioski.models.Cart;
import com.caue.kioski.models.Category;
import com.caue.kioski.models.MenuItem;
import org.junit.jupiter.api.*;

import java.awt.*;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

class CartTest
{
    @Test
    void adds_and_sums()
    {
        MenuItem coffee = new MenuItem("Coffee", new BigDecimal("3.00"), Category.COFFEE);
        Cart c = new Cart();
        c.add(coffee, 2);
        assertEquals(new BigDecimal("6.00"), c.getSubtotal());
    }

    @Test
    void merge_same_item()
    {
        com.caue.kioski.models.MenuItem tea = new MenuItem("Tea", new BigDecimal("2.50"), Category.COFFEE);
        Cart c = new Cart();
        c.add(tea, 1);
        c.add(tea, 2);
        assertEquals(1, c.items().size());
        assertEquals(3, c.items().get(0).getQuantity());
    }
}
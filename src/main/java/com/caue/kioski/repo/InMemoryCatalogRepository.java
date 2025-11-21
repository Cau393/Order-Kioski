package com.caue.kioski.repo;
import com.caue.kioski.interfaces.CatalogRepository;
import com.caue.kioski.models.Category;
import com.caue.kioski.models.MenuItem;

import java.math.BigDecimal;
import java.util.List;

public class InMemoryCatalogRepository implements CatalogRepository
{
    private final List<MenuItem> data = List.of(
            new MenuItem("Coffee", new BigDecimal("3.00"), Category.COFFEE),
            new MenuItem("Tea", new BigDecimal("2.50"), Category.COFFEE),
            new MenuItem("Croissant", new BigDecimal("4.25"), Category.BAKERY)
            );

    @Override
    public List<MenuItem> all()
    {
        return data;
    }

    @Override
    public List<MenuItem> byCategory(Category category)
    {
        return data.stream().filter(d -> d.getCategory() == category).toList();
    }
}

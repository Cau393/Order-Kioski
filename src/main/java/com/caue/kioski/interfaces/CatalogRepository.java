package com.caue.kioski.interfaces;
import com.caue.kioski.models.MenuItem;

import java.util.List;

public interface CatalogRepository
{
    List<MenuItem> all();
}

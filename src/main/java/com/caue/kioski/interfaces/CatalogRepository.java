package com.caue.kioski.interfaces;
import com.caue.kioski.models.*;

import java.util.List;

public interface CatalogRepository
{
    List<MenuItem> all();
    List<MenuItem> byCategory(Category category);
}

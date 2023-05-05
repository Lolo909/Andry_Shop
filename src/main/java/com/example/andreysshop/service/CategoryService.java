package com.example.andreysshop.service;

import com.example.andreysshop.model.entity.Category;
import com.example.andreysshop.model.entity.enums.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum category);
}

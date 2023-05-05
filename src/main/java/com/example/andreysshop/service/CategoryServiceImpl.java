package com.example.andreysshop.service;

import com.example.andreysshop.model.entity.Category;
import com.example.andreysshop.model.entity.enums.CategoryNameEnum;
import com.example.andreysshop.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if(categoryRepository.count()!=0){
            return;
        }
        Arrays.stream(CategoryNameEnum.values()).forEach(categoryNameEnum -> {
            Category category = new Category(categoryNameEnum, "DESCRIPTION: " + categoryNameEnum.name());

            categoryRepository.save(category);
        });
    }

    @Override
    public Category findByCategoryNameEnum(CategoryNameEnum category) {
        return categoryRepository.findByName(category)
                .orElse(null);
    }


}

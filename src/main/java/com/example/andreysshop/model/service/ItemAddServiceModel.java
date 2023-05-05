package com.example.andreysshop.model.service;

import com.example.andreysshop.model.entity.enums.CategoryNameEnum;
import com.example.andreysshop.model.entity.enums.GenderEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class ItemAddServiceModel {
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;

    private CategoryNameEnum category;

    private GenderEnum gender;

    public ItemAddServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ItemAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemAddServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemAddServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemAddServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ItemAddServiceModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public ItemAddServiceModel setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }
}

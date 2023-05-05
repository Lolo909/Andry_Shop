package com.example.andreysshop.model.binding;

import com.example.andreysshop.model.entity.enums.CategoryNameEnum;
import com.example.andreysshop.model.entity.enums.GenderEnum;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class ItemAddBindingModel {

    @Size(min = 2, message = "Name must be longer than two characters!")
    private String name;

    @Size(min = 3, message = "Description must be longer than three characters!")
    private String description;

    @Positive
    private BigDecimal price;

   @NotNull
    private CategoryNameEnum category;

@NotNull
    private GenderEnum gender;

    public ItemAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ItemAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ItemAddBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public ItemAddBindingModel setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }
}

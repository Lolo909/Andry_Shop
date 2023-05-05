package com.example.andreysshop.service;

import com.example.andreysshop.model.entity.Item;
import com.example.andreysshop.model.entity.enums.GenderEnum;
import com.example.andreysshop.model.service.ItemAddServiceModel;
import com.example.andreysshop.model.view.ItemViewModel;

import java.util.List;

public interface ItemService{

    void addItem(ItemAddServiceModel itemAddServiceModel);

    List<ItemViewModel> findAllItems();

    ItemViewModel findById(Long id);

    void delete(Long id);
}

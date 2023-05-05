package com.example.andreysshop.service;

import com.example.andreysshop.model.entity.Item;
import com.example.andreysshop.model.entity.enums.GenderEnum;
import com.example.andreysshop.model.service.ItemAddServiceModel;
import com.example.andreysshop.model.view.ItemViewModel;
import com.example.andreysshop.repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;

    }

    @Override
    public void addItem(ItemAddServiceModel itemAddServiceModel) {
        Item item = modelMapper.map(itemAddServiceModel, Item.class);
        //product.setClient(userService.findById(currentUser.getId()));
        item.setCategory(categoryService.findByCategoryNameEnum(itemAddServiceModel.getCategory()));
        item.setGender(itemAddServiceModel.getGender());

        itemRepository.save(item);
    }

    @Override
    public List<ItemViewModel> findAllItems() {
        return itemRepository.findAll()
                .stream()
                .map(item -> {
                    ItemViewModel itemViewModel = modelMapper.map(item, ItemViewModel.class);

                    itemViewModel.setImageUrl(String.format("/img/%s-%s.jpg", item.getGender().name(), item.getCategory().getName().name()));

                    return itemViewModel;
                }).collect(Collectors.toList());
    }

    @Override
    public ItemViewModel findById(Long id) {
        return itemRepository.findById(id)
                .map(item -> {
                    ItemViewModel itemViewModel = modelMapper.map(item, ItemViewModel.class);
                    itemViewModel.setImageUrl(String.format("/img/%s-%s.jpg", item.getGender().name(), item.getCategory().getName().name()));

                    return itemViewModel;
                }).orElse(null);
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }


}

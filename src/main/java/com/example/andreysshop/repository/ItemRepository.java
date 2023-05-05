package com.example.andreysshop.repository;

import com.example.andreysshop.model.entity.Category;
import com.example.andreysshop.model.entity.Item;
import com.example.andreysshop.model.entity.enums.CategoryNameEnum;
import com.example.andreysshop.model.entity.enums.GenderEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}

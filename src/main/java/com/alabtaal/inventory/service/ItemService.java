package com.alabtaal.inventory.service;

import com.alabtaal.inventory.entity.ItemEntity;

import java.util.List;
public interface ItemService {

//    List<ItemEntity> findByName(String name);

    ItemEntity getByName(String name);

    List<ItemEntity> findAll();

    Boolean existsByName(String name);
    ItemEntity save(ItemEntity entity);
    void delete(Long id);
    List<ItemEntity> findByBrand(String brand);
}

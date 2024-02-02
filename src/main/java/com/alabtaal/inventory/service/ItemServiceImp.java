package com.alabtaal.inventory.service;

import com.alabtaal.inventory.entity.ItemEntity;
import com.alabtaal.inventory.repository.ItemRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ItemServiceImp implements ItemService{
    private final ItemRepo itemRepo;

    @Override
    public List<ItemEntity> findByName(String name) {
        return itemRepo.getByyNameIgnoreCase();
    }

    @Override
    public ItemEntity getByName(String name) {
        return itemRepo.getByyNameIgnoreCase(name);
    }

    @Override
    public List<ItemEntity> findAll() {
        return itemRepo.findAll();
    }

    @Override
    public Boolean existsByName(String name) {
        return itemRepo.existsByNameIgnoreCase(name);
    }

    @Override
    public ItemEntity save(ItemEntity entity) {
        if (entity == null) {
            throw new RuntimeException("Entity is null");
        }
        if(entity.getPrice()==null ||entity.getPrice()<=0){
            throw new RuntimeException("Invalid Price");
        }
        return itemRepo.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
       itemRepo.deleteById(id);
    }

    @Override
    public List<ItemEntity> findByBrand(String brand) {
        return itemRepo.findByBrandIgnoreCase(brand);
    }
}

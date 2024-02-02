package com.alabtaal.inventory.repository;

import com.alabtaal.inventory.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo  extends JpaRepository<ItemEntity,Long> {


    List<ItemEntity> findByBrandIgnoreCase(String brand);
    Boolean existsByNameIgnoreCase(String name);
  ItemEntity getByyNameIgnoreCase(String name);
//    aik boolean wala btaya sir ne or aik get by wala btaya jis mai agr null hoga to error a jayee ga jb k find by mai error nai ata agr null ho.


    List<ItemEntity> findAllByBrandIgnoreCaseAndPriceLessThanEqual(String brand,Double price);
    List<ItemEntity> findAllByNameIgnoreCaseOrBrandIgnoreCase(String name,String brand);

    List<ItemEntity> getByyNameIgnoreCase();
}

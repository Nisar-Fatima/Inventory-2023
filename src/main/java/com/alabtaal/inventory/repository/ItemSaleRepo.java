package com.alabtaal.inventory.repository;

import com.alabtaal.inventory.entity.ItemEntity;
import com.alabtaal.inventory.entity.ItemSalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface ItemSaleRepo extends JpaRepository<ItemSalesEntity,Long> {


    }




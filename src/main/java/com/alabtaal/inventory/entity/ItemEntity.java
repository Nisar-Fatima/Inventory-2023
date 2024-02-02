package com.alabtaal.inventory.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(schema = "temp", name="items",uniqueConstraints = {@UniqueConstraint(name ="items_uk1",columnNames = "name")})
public class ItemEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private long itemId;

    @Column(name="name")
    @NotBlank(message="item name must be entered")
    private String name;

    @Column(name="brand")
    private String brand;

    @Column(name="item_type")
    private String itemType;


    @Column(name="price")
    @NotNull(message = "item name must be entered")
    private Double price;

    @Column(name="expiry")
    private Date itemExpiryDate;

    @OneToMany(mappedBy = "item")
    private List<ItemSalesEntity> itemSales;

    @OneToMany(mappedBy = "item")
    private List<ItemPurchaseEntity> itemPurchases;




}
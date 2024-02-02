package com.alabtaal.inventory.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
@Entity
@Table(schema = "temp", name="item_sale")
public class ItemSalesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name="id")
    private long itemId;

    @Column(name="quantity")
    @NotBlank(message="Quantity must be entered")
    private Long quantity;

    @Column(name="sale_date")
    private Date saleDate=new Date();

    @Column(name="price")
    @NotNull(message = "item name must be entered")
    private Double price;

    @Column(name="disount")
    private Long discount;

@ManyToOne
    private ItemEntity item;



}
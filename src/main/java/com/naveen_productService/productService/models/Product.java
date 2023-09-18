package com.naveen_productService.productService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
    private String name;
    private String description;
    private String image;
//         p   -----> c
//    LtoR 1   -----> 1
//    RtoL m   -----> 1
    @ManyToOne()
    private Category category;
    private double price;
}

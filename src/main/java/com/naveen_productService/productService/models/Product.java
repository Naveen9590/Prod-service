package com.naveen_productService.productService.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseModel {
    private String name;
    private String description;
    private String image;
//         p   -----> c
//    LtoR 1   -----> 1
//    RtoL m   -----> 1
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Category category;
    @OneToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE})
    private Price price;
}

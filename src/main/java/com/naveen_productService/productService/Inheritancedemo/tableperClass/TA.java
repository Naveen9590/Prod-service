package com.naveen_productService.productService.Inheritancedemo.tableperClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_TA")
public class TA extends User {
    private  double avgRating;
}

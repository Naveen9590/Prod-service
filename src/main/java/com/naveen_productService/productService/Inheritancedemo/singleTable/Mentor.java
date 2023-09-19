package com.naveen_productService.productService.Inheritancedemo.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="st_mentor")
@DiscriminatorValue(value = "3")
public class Mentor extends User {
    private double avgRating;
}

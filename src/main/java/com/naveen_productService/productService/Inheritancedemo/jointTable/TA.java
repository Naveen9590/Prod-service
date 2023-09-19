package com.naveen_productService.productService.Inheritancedemo.jointTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="joint_TA")
@PrimaryKeyJoinColumn(name = "TA_ID")
public class TA extends User {
    private  double avgRating;
}

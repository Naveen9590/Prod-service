package com.naveen_productService.productService.Inheritancedemo.jointTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="joint_mentor")
@PrimaryKeyJoinColumn(name = "mentor_ID")
public class Mentor extends User {
    private double avgRating;
}

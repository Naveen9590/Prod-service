package com.naveen_productService.productService.Inheritancedemo.jointTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="joint_student")
@PrimaryKeyJoinColumn(name = "student_ID")
public class Student extends User {
    private  double psp;
    private  double attendance;
}

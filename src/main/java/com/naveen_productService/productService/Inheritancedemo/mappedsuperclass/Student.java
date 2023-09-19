package com.naveen_productService.productService.Inheritancedemo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Student extends  User{
    private  double psp;
    private  double attendance;
}

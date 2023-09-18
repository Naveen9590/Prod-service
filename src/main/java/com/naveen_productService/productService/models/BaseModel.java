package com.naveen_productService.productService.models;

import jakarta.persistence.*;

import java.util.UUID;

@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
//    @Column(name = "id",columnDefinition = "binary(16)",nullable = false)
    private UUID id;
}

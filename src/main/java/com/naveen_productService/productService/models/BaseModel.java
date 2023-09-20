package com.naveen_productService.productService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
//    @Column(name = "id",columnDefinition = "binary(16)",nullable = false)
    private UUID id;
}

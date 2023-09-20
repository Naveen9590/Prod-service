package com.naveen_productService.productService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@Entity(name="orders_table")
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BaseModel{
    @ManyToMany
    private List<Product> products;
}

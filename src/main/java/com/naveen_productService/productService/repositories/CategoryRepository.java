package com.naveen_productService.productService.repositories;

import com.naveen_productService.productService.models.Category;
import com.naveen_productService.productService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Category findByName(String name);




}

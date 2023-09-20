package com.naveen_productService.productService.repositories;

import com.naveen_productService.productService.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PriceRepository extends JpaRepository<Price, UUID> {

}

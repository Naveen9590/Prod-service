package com.naveen_productService.productService.services;

import com.naveen_productService.productService.Exceptions.InvalidIDException;
import com.naveen_productService.productService.Exceptions.NotFoundException;
import com.naveen_productService.productService.dtos.GenericCategoryDto;
import com.naveen_productService.productService.dtos.GenericProductDto;
import com.naveen_productService.productService.models.Product;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    GenericProductDto getProductById(UUID id) throws NotFoundException;

    GenericProductDto createProduct(GenericProductDto product);

    GenericProductDto updateProduct(GenericProductDto product) throws NotFoundException;

    List<GenericProductDto> getAllProducts();

    void deleteProduct(UUID id) throws NotFoundException;

    List<GenericCategoryDto> getAllCategories();

    List<GenericProductDto> getAllProductsInCategory(String category) throws NotFoundException;
}

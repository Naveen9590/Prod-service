package com.naveen_productService.productService.services;

import com.naveen_productService.productService.dtos.GenericProductDto;
import com.naveen_productService.productService.models.Product;

public interface ProductService {
    GenericProductDto getProductById(Long id);

    GenericProductDto createProduct(GenericProductDto product);

}

package com.naveen_productService.productService.controllers;

import com.naveen_productService.productService.dtos.GenericProductDto;
import com.naveen_productService.productService.models.Product;
import com.naveen_productService.productService.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService=productService;
    }

    @PostMapping("/")
    public GenericProductDto getAllProducts(@RequestBody GenericProductDto product){
        return productService.createProduct(product);

    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id) {
        GenericProductDto product = this.productService.getProductById(id);
        return product;
    }
}

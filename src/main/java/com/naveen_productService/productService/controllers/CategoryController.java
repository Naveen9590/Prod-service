package com.naveen_productService.productService.controllers;

import com.naveen_productService.productService.Exceptions.NotFoundException;
import com.naveen_productService.productService.dtos.GenericCategoryDto;
import com.naveen_productService.productService.dtos.GenericProductDto;
import com.naveen_productService.productService.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {


    private ProductService productService;

    public CategoryController(@Qualifier("selfProductServiceImpl") ProductService productService){
        this.productService=productService;
    }
    @GetMapping("/")
    private ResponseEntity<List<GenericCategoryDto>> getAllCategories() {
        return new ResponseEntity<List<GenericCategoryDto>>(productService.getAllCategories(), HttpStatus.OK);
    }
    @GetMapping("/{category}/products")
    private ResponseEntity<List<GenericProductDto>> getAllProductsInCategories(@PathVariable String category) throws NotFoundException {
        return new ResponseEntity<List<GenericProductDto>>(productService.getAllProductsInCategory(category), HttpStatus.OK);
    }
}


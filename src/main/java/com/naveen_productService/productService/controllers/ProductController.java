package com.naveen_productService.productService.controllers;

import com.naveen_productService.productService.Exceptions.NotFoundException;
import com.naveen_productService.productService.dtos.ExceptionDto;
import com.naveen_productService.productService.dtos.GenericProductDto;
import com.naveen_productService.productService.models.Product;
import com.naveen_productService.productService.services.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("selfProductServiceImpl") ProductService productService){
        this.productService=productService;
    }

    @PostMapping("/")
    public GenericProductDto CreateProduct(@RequestBody GenericProductDto product){
        return productService.createProduct(product);

    }

    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") UUID id) throws NotFoundException {
        GenericProductDto product = this.productService.getProductById(id);
        return product;
    }
    @GetMapping("/")
    private ResponseEntity<List<GenericProductDto>> getAllProducts() {
        List<GenericProductDto> products = productService.getAllProducts();
        return new ResponseEntity<List<GenericProductDto>>(products,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<String> deleteProduct(@PathVariable("id") UUID id) throws NotFoundException{
        productService.deleteProduct(id);
        return new ResponseEntity<>("product with id: "+id +" deleted succesfully",HttpStatus.OK);
    }
    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException e){
        return new ResponseEntity(new ExceptionDto(e.getMessage(),HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
    }
}

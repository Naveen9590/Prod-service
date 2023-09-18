package com.naveen_productService.productService.services;

import com.naveen_productService.productService.dtos.FakeStoreProductDto;
import com.naveen_productService.productService.dtos.GenericProductDto;
import com.naveen_productService.productService.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements  ProductService {

    private RestTemplateBuilder restTemplateBuilder;



    private String getrequestUrl="https://fakestoreapi.com/products/{id}";
    private String postrequestUrl="https://fakestoreapi.com/products";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder  = restTemplateBuilder;
    }
    @Override
    public GenericProductDto getProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(getrequestUrl, FakeStoreProductDto.class,id);
        FakeStoreProductDto fakeStoreProductDtoObj = response.getBody();
        GenericProductDto product = new GenericProductDto();
        product.setTitle(fakeStoreProductDtoObj.getTitle());
        product.setDescription(fakeStoreProductDtoObj.getDescription());
        product.setImage(fakeStoreProductDtoObj.getImage());
        product.setPrice(fakeStoreProductDtoObj.getPrice());
        product.setCategory(fakeStoreProductDtoObj.getCategory());
        return product;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(postrequestUrl,product,FakeStoreProductDto.class);
        FakeStoreProductDto fakeStoreProductDtoObj = response.getBody();
        GenericProductDto genericProduct = new GenericProductDto();
        genericProduct.setTitle(fakeStoreProductDtoObj.getTitle());
        genericProduct.setDescription(fakeStoreProductDtoObj.getDescription());
        genericProduct.setImage(fakeStoreProductDtoObj.getImage());
        genericProduct.setPrice(fakeStoreProductDtoObj.getPrice());
        genericProduct.setCategory(fakeStoreProductDtoObj.getCategory());
        genericProduct.setId(fakeStoreProductDtoObj.getId());
        return genericProduct;


    }
}

package com.naveen_productService.productService.services;

import com.naveen_productService.productService.Exceptions.InvalidIDException;
import com.naveen_productService.productService.Exceptions.NotFoundException;
import com.naveen_productService.productService.dtos.GenericCategoryDto;
import com.naveen_productService.productService.dtos.GenericProductDto;
import com.naveen_productService.productService.models.Category;
import com.naveen_productService.productService.models.Price;
import com.naveen_productService.productService.models.Product;
import com.naveen_productService.productService.repositories.CategoryRepository;
import com.naveen_productService.productService.repositories.PriceRepository;
import com.naveen_productService.productService.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("selfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;
    private PriceRepository priceRepository;

    public SelfProductServiceImpl(ProductRepository productRepository,CategoryRepository categoryRepository,PriceRepository priceRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.priceRepository = priceRepository;
    }
    @Override
    @Transactional
    public GenericProductDto createProduct(GenericProductDto product) {
        Category category= null;
        Category existingCategory = categoryRepository.findByName(product.getCategory());
        if(existingCategory==null){
            category = new Category();
            category.setName(product.getCategory());
        }
        else {

            category = existingCategory;
//            category.setName(existingCategory.getName());
//            category.setId(existingCategory.getId());
        }
        Price price = new Price();
        price.setPrice(product.getPrice());
        price.setCurrency(product.getCurrency());
        Product producttobeSaved = new Product();
        producttobeSaved.setImage(product.getImage());
        producttobeSaved.setDescription(product.getDescription());
        producttobeSaved.setName(product.getTitle());
        producttobeSaved.setCategory(category);
        producttobeSaved.setPrice(price);
        Product savedProduct= productRepository.save(producttobeSaved);
        GenericProductDto responseObj = new GenericProductDto();
        responseObj.setTitle(savedProduct.getName());
        responseObj.setCurrency(savedProduct.getPrice().getCurrency());
        responseObj.setPrice(savedProduct.getPrice().getPrice());
        responseObj.setImage(savedProduct.getImage());
        responseObj.setCategory(savedProduct.getCategory().getName());
        responseObj.setDescription(savedProduct.getDescription());
        responseObj.setId(savedProduct.getId());
        return  responseObj;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<GenericProductDto> list = new ArrayList<>();
        for(Product product:products){
            GenericProductDto genericProductDto = new GenericProductDto();
            genericProductDto.setDescription(product.getDescription());
            genericProductDto.setImage(product.getImage());
            genericProductDto.setCategory(product.getCategory().getName());
            genericProductDto.setPrice(product.getPrice().getPrice());
            genericProductDto.setCurrency(product.getPrice().getCurrency());
            genericProductDto.setTitle(product.getName());
            genericProductDto.setId(product.getId());
            list.add(genericProductDto);
        }
        return list;
    }

    @Override
    public void deleteProduct(UUID id) throws NotFoundException {
        Product product = productRepository.findById(id).orElse(null);
        if(product==null){
            throw new NotFoundException("product with id: "+id+" does not exist");
        }
        productRepository.deleteById(id);
    }

    @Override
    public GenericProductDto getProductById(UUID id) throws NotFoundException {
        Product returnedProduct = productRepository.findById(id).orElse(null);
        if(returnedProduct==null){
            throw new NotFoundException("product with id: "+id+" does not exist");
        }
        GenericProductDto responseObj = new GenericProductDto();
        responseObj.setTitle(returnedProduct.getName());
        responseObj.setCurrency(returnedProduct.getPrice().getCurrency());
        responseObj.setPrice(returnedProduct.getPrice().getPrice());
        responseObj.setImage(returnedProduct.getImage());
        responseObj.setCategory(returnedProduct.getCategory().getName());
        responseObj.setDescription(returnedProduct.getDescription());
        responseObj.setId(returnedProduct.getId());
        return  responseObj;

    }

    @Override
    public List<GenericCategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<GenericCategoryDto> res=new ArrayList<>();
        for(Category cat:categories){
            GenericCategoryDto item = new GenericCategoryDto();
            item.setId(cat.getId());
            item.setCategoryName(cat.getName());
            res.add(item);
        }
        return res;

    }

    @Override
    public List<GenericProductDto> getAllProductsInCategory(String category) throws NotFoundException {
        Category catItem = categoryRepository.findByName(category);
        if(catItem==null){
            throw new NotFoundException("Category "+category+" Not found.Please check the spelling or try for a different category");
        }
//        List<Product> products = productRepository.findByCategoryId(catItem.getId());
        List<Product> products = catItem.getProducts();
        List<GenericProductDto>result = new ArrayList<>();
        for(Product item:products){
            GenericProductDto itemDto = new GenericProductDto();
            itemDto.setCategory(item.getCategory().getName());
            itemDto.setTitle(item.getName());
            itemDto.setId(item.getId());
            itemDto.setImage(item.getImage());
            itemDto.setDescription(item.getDescription());
            itemDto.setCurrency(item.getPrice().getCurrency());
            itemDto.setPrice(item.getPrice().getPrice());
            result.add(itemDto);
        }
        return result;
    }

    @Override
    public GenericProductDto updateProduct(GenericProductDto product) throws NotFoundException {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        if(existingProduct==null){
            throw new NotFoundException("Cannot find product with id: "+product.getId()+" to update.");
        }
        Category category= null;
        Category existingCategory = categoryRepository.findByName(product.getCategory());
        if(existingCategory==null){
            category = new Category();
            category.setName(product.getCategory());
        }
        else {

            category = existingCategory;
//            category.setName(existingCategory.getName());
//            category.setId(existingCategory.getId());
        }
        Product entityProduct = new Product();
        Price price = new Price();
        price.setPrice(product.getPrice());
        price.setCurrency(product.getCurrency());
        entityProduct.setPrice(price);
        entityProduct.setId(product.getId());
        entityProduct.setCategory(category);
        entityProduct.setName(product.getTitle());
        entityProduct.setDescription(product.getDescription());
        entityProduct.setImage(product.getImage());
        Product result= productRepository.save(entityProduct);
        GenericProductDto resultProduct = new GenericProductDto();
        resultProduct.setPrice(result.getPrice().getPrice());
        resultProduct.setTitle(result.getName());
        resultProduct.setCurrency(result.getPrice().getCurrency());
        resultProduct.setDescription(result.getDescription());
        resultProduct.setImage(result.getImage());
        resultProduct.setCategory(result.getCategory().getName());
        resultProduct.setId(result.getId());
        return resultProduct;


    }
}

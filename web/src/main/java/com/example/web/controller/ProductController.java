package com.example.web.controller;

import com.example.web.model.Product;
import com.example.web.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts(){

    return service.getProducts();
    }

    @GetMapping("/products/{prodId}")
    public Product getProductById(@PathVariable int prodId){

        return service.getProductById(prodId);
    }


    @PostMapping("products/addProduct")
    public ResponseEntity<String> addProduct(@RequestBody Product prod){
        return service.addProduct(prod);


    }

    @PutMapping("products/updateProduct")
    public ResponseEntity<String> updateProduct(@RequestBody Product prod){

        return service.updateProduct(prod);
    }

    @DeleteMapping("/products/{prodId}")
    public ResponseEntity<String> deleteProduct(@PathVariable int prodId){

        return service.deleteProduct(prodId);

    }

}

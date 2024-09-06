package com.example.web.service;

import com.example.web.model.Product;
import com.example.web.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;
//    List<Product> products = new ArrayList<>(Arrays.asList(new Product(101, "Iphone", 50000), new Product(102, "Canon",70000), new Product(103,"Mic",10000)));

    public List<Product> getProducts() {

        return repo.findAll();
    }

    public Product getProductById(int prodId){

        return repo.findById(prodId).orElse(new Product());
    }

    public ResponseEntity<String> addProduct(Product prod){
            repo.save(prod);
            return new ResponseEntity<>("Product Added Successfully",HttpStatus.CREATED);
    }

    public ResponseEntity<String> updateProduct(Product prod){

      repo.save(prod);
      return new ResponseEntity<>("Product Updated Successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<String> deleteProduct(int prodId){

        repo.deleteById(prodId);
        return new ResponseEntity<>("Product Deleted Successfully",HttpStatus.ACCEPTED);
    }

}

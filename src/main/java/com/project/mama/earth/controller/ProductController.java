package com.project.mama.earth.controller;

import com.project.mama.earth.model.Product;
import com.project.mama.earth.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/mamaearth")
@CrossOrigin("*")

public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/add/all")
    public ResponseEntity addAllProducts(@RequestBody List<Product> products) {
        productService.addAllProducts(products);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Product product) {
        productService.update(product);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        productService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}

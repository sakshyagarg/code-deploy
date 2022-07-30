package com.project.mama.earth.service;

import com.project.mama.earth.model.Product;
import com.project.mama.earth.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AuthService authService;

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void addAllProducts(List<Product> products) {
        productRepository.saveAll(products);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public void update(Product product) {
        productRepository.save(product);
    }
}

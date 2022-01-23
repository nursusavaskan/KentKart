package com.example.kentKart_v2.controller;

import com.example.kentKart_v2.dto.ProductDto;
import com.example.kentKart_v2.entity.Product;
import com.example.kentKart_v2.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;
    // POST
    // Saves a Product
    @PostMapping("/add-product")
    public Product saveProduct(@RequestBody ProductDto product) {
        log.info("Inside saveProduct of ProductController");
        return productService.saveProduct(product);
    }

    // GET
    // Finds a Product by ID
    @GetMapping("/{id}")
    public Product findProductByProductId(@PathVariable("id") Long productId) {
        log.info("Inside findProductByProductId of ProductController");
        return productService.findProductByProductId(productId);
    }

    // PUT
    // Updates a Product
    @PutMapping("/{id}")
    public Product updateProductByProductId(@PathVariable("id") Long productId, @RequestBody ProductDto product) {
        log.info("Inside updateProductByProductId of ProductController");
        return productService.updateProductByProductId(productId, product);
    }

    // DELETE
    // Deletes a Product
    @DeleteMapping("/{id}")
    public void deleteProductByProductId(@PathVariable("id") Long productId) {
        log.info("Inside deleteProductByProductId of ProductController");
        productService.deleteProductByProductId(productId);
    }
}

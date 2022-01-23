package com.example.kentKart_v2.service;

import com.example.kentKart_v2.dto.ProductDto;
import com.example.kentKart_v2.entity.Product;
import com.example.kentKart_v2.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // POST
    // Saves a Product
    public Product saveProduct(ProductDto productDto) {
        log.info("Inside saveProduct of ProductService");
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        return productRepository.save(product);
    }

    // GET
    // Finds a Product by ID
    public Product findProductByProductId(Long productId) {
        log.info("Inside findProductByProductId of ProductService");
        return productRepository.findByProductId(productId);
    }

    // PUT
    // Updates a Product
    public Product updateProductByProductId(Long productId, ProductDto productDto) {
        log.info("Inside updateProductByProductId of ProductService");
        Product product = new Product();
        // Dto to Entity
        BeanUtils.copyProperties(productDto, product);
        Product u = productRepository.findByProductId(productId);
        u.setProductName(product.getProductName());
        u.setReleaseDate(product.getReleaseDate());
        return productRepository.save(u);

    }

    // DELETE
    // Deletes a Product
    public void deleteProductByProductId(Long productId) {
        log.info("Inside deleteProductByProductId of ProductService");
        Product product = productRepository.findByProductId(productId);
        productRepository.delete(product);
    }

}

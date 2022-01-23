package com.example.kentKart_v2.controller;

import com.example.kentKart_v2.dto.ProductListPropertyDto;
import com.example.kentKart_v2.dto.ProductListPropertyIdDto;
import com.example.kentKart_v2.entity.ProductListProperty;
import com.example.kentKart_v2.service.ProductListPropertyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productList-property")
@Slf4j
public class ProductListPropertyController {

    @Autowired
    private ProductListPropertyService productListPropertyService;
    // POST
    // Saves a ProductListProperty
    @PostMapping("/add-productList-property")
    public ProductListProperty saveProductListProperty(@RequestBody ProductListPropertyDto productListProperty) {
        log.info("Inside saveProductListProperty of ProductListPropertyController");
        return productListPropertyService.saveProductListProperty(productListProperty);
    }

    // GET
    // Finds a ProductListProperty by ID
    @GetMapping("/{id}")
    public ProductListProperty findProductListPropertyByProductListPropertyId(@PathVariable("id") ProductListPropertyIdDto productListPropertyId) {
        log.info("Inside findProductListPropertyByProductListPropertyId of ProductListPropertyController");
        return productListPropertyService.findProductListPropertyByProductListPropertyId(productListPropertyId);
    }

    // PUT
    // Updates a ProductListProperty
    @PutMapping("/{id}")
    public ProductListProperty updateProductListPropertyByProductListPropertyId(@PathVariable("id") ProductListPropertyIdDto productListPropertyIdDto, @RequestBody ProductListPropertyDto productListProperty) {
        log.info("Inside updateProductListPropertyByProductListPropertyId of ProductListPropertyController");
        return productListPropertyService.updateProductListPropertyByProductListPropertyId(productListPropertyIdDto, productListProperty);
    }

    // DELETE
    // Deletes a ProductListProperty
    @DeleteMapping("/{id}")
    public void deleteProductListPropertyByProductListPropertyId(@PathVariable("id") ProductListPropertyIdDto productListPropertyId) {
        log.info("Inside deleteProductListPropertyByProductListPropertyId of ProductListPropertyController");
        productListPropertyService.deleteProductListPropertyByProductListPropertyId(productListPropertyId);
    }

}

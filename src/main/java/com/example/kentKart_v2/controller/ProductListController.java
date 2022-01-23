package com.example.kentKart_v2.controller;

import com.example.kentKart_v2.dto.ProductListDto;
import com.example.kentKart_v2.entity.ProductList;
import com.example.kentKart_v2.service.ProductListService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productLists")
@Slf4j
public class ProductListController {
    @Autowired
    private ProductListService productListService;
    // POST
    // Saves a ProductList
    @PostMapping("/add-ProductList")
    public ProductList saveProductList(@RequestBody ProductListDto productList) {
        log.info("Inside saveProductList of ProductListController");
        return productListService.saveProductList(productList);
    }

    // GET
    // Finds a ProductList by ID
    @GetMapping("/{id}")
    public ProductList findProductListByProductListId(@PathVariable("id") Long productListId) {
        log.info("Inside findProductListByProductListId of ProductListController");
        return productListService.findProductListByProductListId(productListId);
    }

    // PUT
    // Updates a ProductList
    @PutMapping("/{id}")
    public ProductList updateProductListByProductListId(@PathVariable("id") Long productListId, @RequestBody ProductListDto productList) {
        log.info("Inside updateProductListByProductListId of ProductListController");
        return productListService.updateProductListByProductListId(productListId, productList);
    }

    // DELETE
    // Deletes a ProductList
    @DeleteMapping("/{id}")
    public void deleteProductListByProductListId(@PathVariable("id") Long productListId) {
        log.info("Inside deleteProductListByProductListId of ProductListController");
        productListService.deleteProductListByProductListId(productListId);
    }
}

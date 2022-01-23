package com.example.kentKart_v2.service;

import com.example.kentKart_v2.dto.ProductListDto;
import com.example.kentKart_v2.entity.ProductList;
import com.example.kentKart_v2.repository.ProductListRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductListService {

    @Autowired
    private ProductListRepository productListRepository;

    // POST
    // Saves a ProductList
    public ProductList saveProductList(ProductListDto productListDto) {
        log.info("Inside saveProductList of ProductListService");
        ProductList productList = new ProductList();
        BeanUtils.copyProperties(productListDto, productList);
        return productListRepository.save(productList);
    }

    // GET
    // Finds a ProductList by ID
    public ProductList findProductListByProductListId(Long productListId) {
        log.info("Inside findProductListByProductListId of ProductListService");
        return productListRepository.findByProductListId(productListId);
    }

    // PUT
    // Updates a ProductList
    public ProductList updateProductListByProductListId(Long productListId, ProductListDto productListDto) {
        log.info("Inside updateProductListByProductListId of ProductListService");
        ProductList productList = new ProductList();
        // Dto to Entity
        BeanUtils.copyProperties(productListDto, productList);
        ProductList u = productListRepository.findByProductListId(productListId);
        u.setProductListName(productList.getProductListName());
        u.setDepartmentId(productList.getDepartmentId());
        return productListRepository.save(u);
    }

    // DELETE
    // Deletes a ProductList
    public void deleteProductListByProductListId(Long productListId) {
        log.info("Inside deleteProductListByProductListId of ProductListService");
        ProductList productList = productListRepository.findByProductListId(productListId);
        productListRepository.delete(productList);
    }
}

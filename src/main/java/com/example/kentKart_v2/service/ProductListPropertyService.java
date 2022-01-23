package com.example.kentKart_v2.service;

import com.example.kentKart_v2.dto.ProductListPropertyDto;
import com.example.kentKart_v2.dto.ProductListPropertyIdDto;
import com.example.kentKart_v2.entity.ProductListProperty;
import com.example.kentKart_v2.repository.ProductListPropertyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductListPropertyService {

    @Autowired
    private ProductListPropertyRepository productListPropertyRepository;

    // POST
    // Saves a ProductListProperty
    public ProductListProperty saveProductListProperty(ProductListPropertyDto productListPropertyDto
    ) {
        log.info("Inside saveProductListProperty of ProductListPropertyService");
        ProductListProperty productListProperty = new ProductListProperty();
        BeanUtils.copyProperties(productListPropertyDto, productListProperty);
        return productListPropertyRepository.save(productListProperty);
    }

    // GET
    // Finds a ProductListProperty by ID
    public ProductListProperty findProductListPropertyByProductListPropertyId(ProductListPropertyIdDto productListPropertyIdDto) {
        log.info("Inside findProductListPropertyByProductListPropertyId of ProductListPropertyService");
        return productListPropertyRepository.findByProductListIdAndProductId(productListPropertyIdDto.getProductListId(), productListPropertyIdDto.getProductId());
    }

    // PUT
    // Updates a ProductListProperty
    public ProductListProperty updateProductListPropertyByProductListPropertyId(ProductListPropertyIdDto productListPropertyIdDto, ProductListPropertyDto productListPropertyDto
    ) {
        log.info("Inside updateProductListPropertyByProductListPropertyId of ProductListPropertyService");
        ProductListProperty productListProperty = new ProductListProperty();
        // Dto to Entity
        BeanUtils.copyProperties(productListPropertyDto, productListProperty);
        ProductListProperty u = productListPropertyRepository.findByProductListIdAndProductId(productListPropertyIdDto.getProductListId(), productListPropertyIdDto.getProductId());
        u.setProductListId(productListProperty.getProductListId());
        u.setProductId(productListProperty.getProductId());
        return productListPropertyRepository.save(u);
    }

    // DELETE
    // Deletes a ProductListProperty
    public void deleteProductListPropertyByProductListPropertyId(ProductListPropertyIdDto productListPropertyIdDto) {
        log.info("Inside deleteProductListPropertyByProductListPropertyId of ProductListPropertyService");
        ProductListProperty productListProperty = productListPropertyRepository.findByProductListIdAndProductId(productListPropertyIdDto.getProductListId(),productListPropertyIdDto.getProductId());
        productListPropertyRepository.delete(productListProperty);
    }

}

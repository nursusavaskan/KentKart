package com.example.kentKart_v2.repository;

import com.example.kentKart_v2.entity.ProductListProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductListPropertyRepository extends JpaRepository<ProductListProperty, Long> {

    ProductListProperty findByProductListIdAndProductId(Long productListId, Long productId);

    List<ProductListProperty> findAllByProductListId(Long productListId);
}

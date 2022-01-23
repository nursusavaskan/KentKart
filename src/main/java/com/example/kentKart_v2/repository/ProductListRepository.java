package com.example.kentKart_v2.repository;

import com.example.kentKart_v2.entity.ProductList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductListRepository extends JpaRepository<ProductList, Long> {
    ProductList findByProductListId(Long productListId);

    List<ProductList> findAllByDepartmentId(Long departmentId);
}

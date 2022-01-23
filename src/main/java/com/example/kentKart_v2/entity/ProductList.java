package com.example.kentKart_v2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productListId;
    private Long departmentId;
    private String productListName;
}

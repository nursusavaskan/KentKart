package com.example.kentKart_v2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductListPropertyId implements Serializable {

    private Long productListId;
    private Long productId;

}

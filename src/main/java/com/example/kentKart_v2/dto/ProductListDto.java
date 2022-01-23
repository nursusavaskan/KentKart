package com.example.kentKart_v2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductListDto {
    private Long productListId;
    //private Long ownerId;
    private String productName;
}

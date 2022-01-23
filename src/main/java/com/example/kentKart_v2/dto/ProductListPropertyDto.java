package com.example.kentKart_v2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ProductListPropertyIdDto.class)
public class ProductListPropertyDto {
    @Id
    private Long productListId;
    @Id
    private Long productId;
}

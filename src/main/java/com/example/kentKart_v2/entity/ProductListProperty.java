package com.example.kentKart_v2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ProductListPropertyId.class)
public class ProductListProperty implements Serializable {

    @Id
    private Long productListId;
    @Id
    private Long productId;
}

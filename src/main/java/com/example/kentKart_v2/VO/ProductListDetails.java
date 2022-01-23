package com.example.kentKart_v2.VO;

import com.example.kentKart_v2.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductListDetails {
    String productListListName;
    List<Product> productList;

}

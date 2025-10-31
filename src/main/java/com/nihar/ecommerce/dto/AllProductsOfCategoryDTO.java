package com.nihar.ecommerce.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AllProductsOfCategoryDTO {
    private Long id;
    private String name;
    private List<ProductDTO> products;
}

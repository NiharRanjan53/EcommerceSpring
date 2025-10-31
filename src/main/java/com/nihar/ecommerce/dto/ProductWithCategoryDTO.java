package com.nihar.ecommerce.dto;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductWithCategoryDTO {
    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    private Long id;
    private String title;
    private String brand;
    private boolean popular;
    private CategoryDTO category;
}

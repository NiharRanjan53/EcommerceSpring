package com.nihar.ecommerce.mappers;

import com.nihar.ecommerce.dto.ProductDTO;
import com.nihar.ecommerce.entity.Category;
import com.nihar.ecommerce.entity.Product;

import java.nio.channels.ScatteringByteChannel;

public class ProductMapper {
    public static ProductDTO toDto(Product product){
        return  ProductDTO.builder()
                .id(product.getId())
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .categoryId(product.getCategory().getId())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .build();


    }

    public static Product toEntity(ProductDTO dto, Category category){
        return Product.builder()
                .image(dto.getImage())
                .color(dto.getColor())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .discount(dto.getDiscount())
                .model(dto.getModel())
                .title(dto.getTitle())
                .category(category)
                .brand(dto.getBrand())
                .popular(dto.isPopular())
                .build();
    }
}

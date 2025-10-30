package com.nihar.ecommerce.mappers;

import com.nihar.ecommerce.dto.CategoryDTO;
import com.nihar.ecommerce.entity.Category;

public class CategoryMapper {
    public static CategoryDTO toDto(Category category){
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
    public static Category toEntity(CategoryDTO dto){
        return Category.builder()
                .name(dto.getName())
                .build();
    }

}

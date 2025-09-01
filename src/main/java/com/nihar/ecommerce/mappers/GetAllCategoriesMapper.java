package com.nihar.ecommerce.mappers;

import com.nihar.ecommerce.dto.CategoryDTO;
import com.nihar.ecommerce.dto.FakeStoreCategoryResponseDTO;


import java.util.List;

public class GetAllCategoriesMapper {

    public static FakeStoreCategoryResponseDTO toFakeStoreCategoryDTO() {
        return null;
    }

    public static List<CategoryDTO> toCategoryDto(FakeStoreCategoryResponseDTO dto) {
        return dto.getCategories().stream()
                .map(category -> CategoryDTO.builder()
                        .name(category)
                        .build())
                .toList();
    }

}
package com.nihar.ecommerce.services;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.junit.jupiter.api.Assertions.assertEquals;


import com.nihar.ecommerce.dto.CategoryDTO;
import com.nihar.ecommerce.entity.Category;
import com.nihar.ecommerce.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryService categoryService;


    private Category category1;
    private Category category2;
    private Category category3;

    @BeforeEach
    void setUp() {
        category1 = Category.builder().name("Electronics").build();
        category1.setId(1L);
        category2 = Category.builder().name("Books").build();
        category2.setId(2L);
        category3 = Category.builder().name("Clothing").build();
        category3.setId(3L);

    }

    @Test
    @DisplayName("Should return all categories successfully")
    void getAllCategories_shouldReturnAllCategories() throws IOException {
        // Arrange
        List<Category> categories = new ArrayList<>();

        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        when(categoryRepository.findAll()).thenReturn(categories);  // mocked the repository to return the categories

        // Act
        List<CategoryDTO> result = categoryService.getAllCategories();  // service is actually really called

        // Assert
        assertEquals(result.size(), 3);

    }

    @Test
    @DisplayName("Should return category by name")
    void getByName_shouldReturnCategoryByName() throws Exception {
        // Arrange
        when(categoryRepository.findByName("Electronics")).thenReturn(Optional.of(category1));

        // Act
        CategoryDTO result = categoryService.getByName("Electronics");

        // Assert
        assertEquals(result.getName(), "Electronics");
        verify(categoryRepository, times(1)).findByName("Electronics");

    }
}

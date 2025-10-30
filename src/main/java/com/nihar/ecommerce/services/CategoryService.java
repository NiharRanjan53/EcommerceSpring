package com.nihar.ecommerce.services;

import com.nihar.ecommerce.dto.CategoryDTO;
import com.nihar.ecommerce.entity.Category;
import com.nihar.ecommerce.mappers.CategoryMapper;
import com.nihar.ecommerce.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo){
        this.repo = repo;
    }
    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        List<CategoryDTO> dto = new ArrayList<>();
        for(Category category : repo.findAll()){
            dto.add(CategoryMapper.toDto(category));
        }
        return dto;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toEntity(categoryDTO);
        Category saved = repo.save(category);
        return CategoryMapper.toDto(saved);
    }
}

package com.nihar.ecommerce.services;

import com.nihar.ecommerce.dto.ProductDTO;
import com.nihar.ecommerce.entity.Category;
import com.nihar.ecommerce.entity.Product;
import com.nihar.ecommerce.mappers.ProductMapper;
import com.nihar.ecommerce.repository.CategoryRepository;
import com.nihar.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    private final ProductRepository repo;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository repo, CategoryRepository categoryRepository){
        this.repo = repo;
        this.categoryRepository = categoryRepository;
    }

    public ProductDTO getProductById(Long id) throws Exception {
        return repo.findById(id)
                .map(ProductMapper::toDto)
                .orElseThrow(() -> new Exception("Product not found"));
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) throws Exception{
        Category category = categoryRepository.findById(dto.getCategoryId()).orElseThrow(() -> new Exception("Category not found"));
        Product saved  =  repo.save(ProductMapper.toEntity(dto, category));
        return ProductMapper.toDto(saved);
    }
}

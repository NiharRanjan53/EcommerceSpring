package com.nihar.ecommerce.services;

import com.nihar.ecommerce.dto.ProductDTO;
import com.nihar.ecommerce.dto.ProductWithCategoryDTO;
import com.nihar.ecommerce.entity.Category;
import com.nihar.ecommerce.entity.Product;
import com.nihar.ecommerce.mappers.ProductMapper;
import com.nihar.ecommerce.repository.CategoryRepository;
import com.nihar.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    private final ProductRepository repo;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository repo, CategoryRepository categoryRepository){
        this.repo = repo;
        this.categoryRepository = categoryRepository;
    }

    @Override
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

    @Override
    public List<ProductDTO> getProductsByMinPrice(Double minPrice) {
        List<Product> products= repo.findByPriceGreaterThan(minPrice);
        return products.stream().map(ProductMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductsByKeyword(String keyword) {
        List<Product> products = repo.searchFullText(keyword);
        return products.stream().map(ProductMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategory(long id) throws Exception {
        Product product = repo.findById(id)
                .orElseThrow(()-> new Exception("Product not Found."));

        return ProductMapper.toProductWithCategoryDto(product);
    }
}

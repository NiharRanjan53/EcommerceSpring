package com.nihar.ecommerce.services;

import com.nihar.ecommerce.dto.ProductDTO;
import com.nihar.ecommerce.dto.ProductWithCategoryDTO;
import com.nihar.ecommerce.entity.Category;
import com.nihar.ecommerce.entity.Product;
import com.nihar.ecommerce.exception.ProductNotFoundException;
import com.nihar.ecommerce.exception.ResourceNotFoundException;
import com.nihar.ecommerce.mappers.ProductMapper;
import com.nihar.ecommerce.repository.CategoryRepository;
import com.nihar.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public ProductDTO getProductById(Long id){
//        return repo.findById(id)
//                .map(ProductMapper::toDto)
//                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        Product product =  repo.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id + " not found"));

        return ProductMapper.toDto(product);
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto){
        Category category = categoryRepository.findById(dto.getCategoryId())
                            .orElseThrow(() -> new ResourceNotFoundException("Category", dto.getCategoryId()));
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
    public ProductWithCategoryDTO getProductWithCategory(long id){
        Product product = repo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Product not Found."));

        return ProductMapper.toProductWithCategoryDto(product);
    }
}

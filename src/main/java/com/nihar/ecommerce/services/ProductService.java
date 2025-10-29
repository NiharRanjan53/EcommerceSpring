package com.nihar.ecommerce.services;

import com.nihar.ecommerce.dto.ProductDTO;
import com.nihar.ecommerce.entity.Product;
import com.nihar.ecommerce.mappers.ProductMapper;
import com.nihar.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo){
        this.repo = repo;
    }

    public ProductDTO getProductById(Long id) throws Exception {
        return repo.findById(id)
                .map(ProductMapper::toDto)
                .orElseThrow(() -> new Exception("Product not found"));
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) {
        Product saved  =  repo.save(ProductMapper.toEntity(dto));
        return ProductMapper.toDto(saved);
    }
}

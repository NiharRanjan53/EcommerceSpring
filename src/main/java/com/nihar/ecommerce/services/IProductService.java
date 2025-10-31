package com.nihar.ecommerce.services;

import com.nihar.ecommerce.dto.ProductDTO;
import com.nihar.ecommerce.dto.ProductWithCategoryDTO;

import java.util.List;

public interface IProductService {
    ProductDTO getProductById(Long id);
    ProductDTO createProduct(ProductDTO dto);
    List<ProductDTO> getProductsByMinPrice(Double minPrice);
    List<ProductDTO> getProductsByKeyword(String keyword);
    ProductWithCategoryDTO getProductWithCategory(long id);
}

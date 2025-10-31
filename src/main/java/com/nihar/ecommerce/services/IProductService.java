package com.nihar.ecommerce.services;

import com.nihar.ecommerce.dto.CategoryDTO;
import com.nihar.ecommerce.dto.ProductDTO;
import com.nihar.ecommerce.dto.ProductWithCategoryDTO;
import com.nihar.ecommerce.entity.Product;

import java.io.IOException;
import java.util.List;

public interface IProductService {
    ProductDTO getProductById(Long id) throws Exception;

    ProductDTO createProduct(ProductDTO dto) throws Exception;
    List<ProductDTO> getProductsByMinPrice(Double minPrice);
    List<ProductDTO> getProductsByKeyword(String keyword);
    ProductWithCategoryDTO getProductWithCategory(long id) throws  Exception;
}

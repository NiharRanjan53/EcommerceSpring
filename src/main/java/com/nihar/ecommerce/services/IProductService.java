package com.nihar.ecommerce.services;

import com.nihar.ecommerce.dto.CategoryDTO;
import com.nihar.ecommerce.dto.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface IProductService {
    ProductDTO getProductById(Long id) throws Exception;

    ProductDTO createProduct(ProductDTO dto) throws Exception;
    List<ProductDTO> getProductsByMinPrice(Double minPrice);
}

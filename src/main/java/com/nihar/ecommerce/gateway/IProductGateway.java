package com.nihar.ecommerce.gateway;

import com.nihar.ecommerce.dto.CategoryDTO;
import com.nihar.ecommerce.dto.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface IProductGateway {
    ProductDTO getProductById(Long id) throws Exception;
}

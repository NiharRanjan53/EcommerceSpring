package com.nihar.ecommerce.gateway;

import com.nihar.ecommerce.dto.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryGateway {
    List<CategoryDTO> getAllCategories() throws IOException;
}

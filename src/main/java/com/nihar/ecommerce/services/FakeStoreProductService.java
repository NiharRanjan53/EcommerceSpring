package com.nihar.ecommerce.services;

import com.nihar.ecommerce.dto.ProductDTO;
import com.nihar.ecommerce.dto.ProductWithCategoryDTO;
import com.nihar.ecommerce.gateway.IProductGateway;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductService{

    private final IProductGateway productGateway;
    public  FakeStoreProductService(IProductGateway productGateway){
        this.productGateway = productGateway;
    }

    @Override
    public ProductDTO getProductById(Long id) throws Exception {
        return productGateway.getProductById(id);
    }

    public ProductDTO createProduct(ProductDTO dto) {
        return null;
    }

    public List<ProductDTO> getProductsByMinPrice(Double minPrice) {
        return null;
    }

    public List<ProductDTO> getProductsByKeyword(String keyword) {
        return null;
    }

    public ProductWithCategoryDTO getProductWithCategory(long id) throws Exception {
        return null;
    }
}

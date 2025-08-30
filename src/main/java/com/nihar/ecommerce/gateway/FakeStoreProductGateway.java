package com.nihar.ecommerce.gateway;

import com.nihar.ecommerce.dto.CategoryDTO;
import com.nihar.ecommerce.dto.FakeStoreCategoryResponseDTO;
import com.nihar.ecommerce.dto.FakeStoreProductResponseDTO;
import com.nihar.ecommerce.dto.ProductDTO;
import com.nihar.ecommerce.gateway.api.FakeStoreCategoryAPI;
import com.nihar.ecommerce.gateway.api.FakeStoreProductAPI;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class FakeStoreProductGateway implements IProductGateway {
    private final FakeStoreProductAPI fakeStoreProductAPI;

    public FakeStoreProductGateway(FakeStoreProductAPI fakeStoreProductAPI){
        this.fakeStoreProductAPI = fakeStoreProductAPI;
    }

    @Override
    public ProductDTO getProductById(Long id) throws IOException {
        FakeStoreProductResponseDTO response =  this.fakeStoreProductAPI.getFakeProduct(id).execute().body();
        if(response == null){
            throw  new IOException("Failed to fetch categories from FakeStore API.");
        }
        return response.getProduct();

    }
}

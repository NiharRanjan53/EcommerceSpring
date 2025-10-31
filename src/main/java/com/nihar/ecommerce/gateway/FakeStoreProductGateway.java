package com.nihar.ecommerce.gateway;
import com.nihar.ecommerce.dto.ProductDTO;
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
    public ProductDTO getProductById(Long id){
//        FakeStoreProductResponseDTO response =  this.fakeStoreProductAPI.getFakeProduct(id).execute().body();
//        if(response == null){
//            throw  new Exception("Product not Found");
//        }
//        return response.getProduct();
        return  null;

    }
}

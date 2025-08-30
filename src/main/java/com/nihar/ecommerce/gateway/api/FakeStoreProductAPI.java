package com.nihar.ecommerce.gateway.api;

import com.nihar.ecommerce.dto.FakeStoreCategoryResponseDTO;
import com.nihar.ecommerce.dto.FakeStoreProductResponseDTO;
import org.springframework.web.bind.annotation.PathVariable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;

public interface FakeStoreProductAPI {
    @GET("products/{id}")
    Call<FakeStoreProductResponseDTO> getFakeProduct(@Path("id") Long id) throws IOException;
}

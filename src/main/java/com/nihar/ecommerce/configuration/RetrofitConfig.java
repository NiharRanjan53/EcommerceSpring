package com.nihar.ecommerce.configuration;

import com.nihar.ecommerce.gateway.api.FakeStoreCategoryAPI;
import com.nihar.ecommerce.gateway.api.FakeStoreProductAPI;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {


    @Value("${API_BASE_URL}")
    private String apiBaseUrl;

    @Bean
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl(apiBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public FakeStoreCategoryAPI fakeStoreCategoryApi(Retrofit retrofit) {
        return retrofit.create(FakeStoreCategoryAPI.class);
    }

    @Bean
    public FakeStoreProductAPI fakeStoreProductApi(Retrofit retrofit) {
        return retrofit.create(FakeStoreProductAPI.class);
    }
}

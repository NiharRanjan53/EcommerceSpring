package com.nihar.ecommerce.configuration;

import com.nihar.ecommerce.gateway.api.FakeStoreCategoryAPI;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {
    @Bean
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://fakestoreapi.in/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public FakeStoreCategoryAPI fakeStoreCategoryApi(Retrofit retrofit) {
        return retrofit.create(FakeStoreCategoryAPI.class);
    }
}

package com.nihar.ecommerce.gateway;

import com.nihar.ecommerce.dto.CategoryDTO;
import com.nihar.ecommerce.dto.FakeStoreCategoryResponseDTO;
import com.nihar.ecommerce.gateway.api.FakeStoreCategoryAPI;
import com.nihar.ecommerce.mappers.GetAllCategoriesMapper;
import com.nihar.ecommerce.services.FakeStoreCategoryService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FakeStoreCategoryGateway implements ICategoryGateway{
    private final FakeStoreCategoryAPI fakeStoreCategoryAPI;

    public FakeStoreCategoryGateway(FakeStoreCategoryAPI fakeStoreCategoryAPI){
        this.fakeStoreCategoryAPI = fakeStoreCategoryAPI;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        FakeStoreCategoryResponseDTO response =  this.fakeStoreCategoryAPI.getAllFakeCategories().execute().body();
        if(response == null){
            throw  new IOException("Failed to fetch categories from FakeStore API.");
        }
        return GetAllCategoriesMapper.toCategoryDto(response);

    }
}

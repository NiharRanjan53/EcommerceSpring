package com.nihar.ecommerce.controllers;

import com.nihar.ecommerce.dto.CategoryDTO;
import com.nihar.ecommerce.services.ICategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final ICategoryService categoryService;

    CategoryController(ICategoryService categoryService){

        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCategories(@RequestParam(required = false) String name) throws Exception {
        if(name != null && !name.isBlank()){
            CategoryDTO categoryDTO = categoryService.getByName(name);
            return ResponseEntity.ok(categoryDTO);
        }else{
            List<CategoryDTO> response = categoryService.getAllCategories();
            return ResponseEntity.ok(response);
        }

    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
        return ResponseEntity.ok(categoryService.createCategory(categoryDTO));

    }



}

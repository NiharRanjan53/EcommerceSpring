package com.nihar.ecommerce.controllers;

import com.nihar.ecommerce.dto.ProductDTO;
import com.nihar.ecommerce.dto.ProductWithCategoryDTO;
import com.nihar.ecommerce.services.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO>getProductById(@PathVariable Long id){
        ProductDTO result = this.productService.getProductById(id);
        return ResponseEntity.ok(result);

    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto) throws Exception{
        return ResponseEntity.ok(productService.createProduct(dto));
    }

    @GetMapping(params = "minPrice")
    public ResponseEntity<?> getProductsAboveMinPrice(@RequestParam(required = true) Double minPrice){
        // Validation checks
        if (minPrice != null) {
            if (minPrice < 0) {
                throw new InvalidParameterException("minPrice cannot be negative.");
            }

            List<ProductDTO> products = productService.getProductsByMinPrice(minPrice);

            if (products.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("No products found above price: " + minPrice);
            }

            return ResponseEntity.ok(products);
        } else {
            throw new InvalidParameterException("minPrice parameter is required.");
        }

    }
    @GetMapping(params = "keyword")
    public ResponseEntity<List<ProductDTO>> getProductsByKeyword(@RequestParam(required = true) String keyword) {
        if (keyword == null || keyword.isBlank()) {
            throw new InvalidParameterException("Keyword cannot be empty.");
        }
        List<ProductDTO> products = productService.getProductsByKeyword(keyword);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}/details")
    public ResponseEntity<ProductWithCategoryDTO> getProductWithCategory(@PathVariable Long id){
        ProductWithCategoryDTO result = productService.getProductWithCategory(id);
        return ResponseEntity.ok(result);
    }

}

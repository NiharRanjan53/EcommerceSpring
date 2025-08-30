package com.nihar.ecommerce.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FakeStoreProductResponseDTO {
    private ProductDTO product;
    private String message;
    private String status;

}

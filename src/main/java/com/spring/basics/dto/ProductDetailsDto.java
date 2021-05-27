package com.spring.basics.dto;

import com.spring.basics.models.ProductDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDetailsDto {
    private Long id;
    private String name;
    private String imageName;
    private Long productId;
    private String description;

    public static ProductDetailsDto from(ProductDetails productDetails) {
        return ProductDetailsDto.builder()
                .id(productDetails.getId())
                .name(productDetails.getName())
                .imageName(productDetails.getImageName())
                .productId(productDetails.getProductId())
                .description(productDetails.getDescription())
                .build();
    }

    public static List<ProductDetailsDto> from(List<ProductDetails> productDetails) {
        return productDetails.stream().map(ProductDetailsDto::from).collect(Collectors.toList());
    }
}

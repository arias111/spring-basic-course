package com.spring.basics.services.interfaces;

import com.spring.basics.dto.ProductDetailsDto;
import com.spring.basics.models.ProductDetails;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductDetailsService {
    List<ProductDetails> getAllProducts();

    ProductDetails addProduct(ProductDetailsDto product);
    public ProductDetails getProductById(Long productId);
}

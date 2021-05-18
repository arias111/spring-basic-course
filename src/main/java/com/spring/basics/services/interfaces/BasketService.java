package com.spring.basics.services.interfaces;

import com.spring.basics.dto.ProductDto;

import java.util.List;

public interface BasketService {
    List<ProductDto> getBasket();
    void addToBasket(Long productId);
}

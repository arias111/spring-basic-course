package com.spring.basics.services.interfaces;

import com.spring.basics.dto.BasketDto;
import com.spring.basics.dto.ProductDto;

import java.util.List;

public interface BasketService {
    List<BasketDto> getBasket();
    void addToBasket(Long productId);
    List<BasketDto> getBasketDetails();
}

package com.spring.basics.controllers;

import com.spring.basics.dto.ProductDto;
import com.spring.basics.services.interfaces.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class BasketController {

    @Autowired
    private BasketService basketService;

    @CrossOrigin("http://localhost")
    @GetMapping("/basket")
    public ResponseEntity<List<ProductDto>> getBasket() {
        return ResponseEntity.ok(basketService.getBasket());
    }

    @CrossOrigin("http://localhost")
    @GetMapping("/basket")
    public void addToBasket(@RequestParam Long productId) {
        basketService.addToBasket(productId);
    }
}

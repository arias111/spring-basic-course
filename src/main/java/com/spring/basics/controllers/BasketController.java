package com.spring.basics.controllers;

import com.spring.basics.dto.BasketDto;
import com.spring.basics.dto.ProductIdDto;
import com.spring.basics.security.UserDetailsImpl;
import com.spring.basics.services.interfaces.BasketService;
import com.spring.basics.services.interfaces.SenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BasketController {

    private final SenderService senderService;

    @Autowired
    private BasketService basketService;

    @GetMapping("/basket")
    public ResponseEntity<List<BasketDto>> getBasket() {
        return ResponseEntity.ok(basketService.getBasket());
    }

    @PostMapping("/basket/add")
    public ResponseEntity<?> addToBasket(@RequestBody ProductIdDto productIdDto) {
        basketService.addToBasket(Long.parseLong(productIdDto.getProductId()));
        return ResponseEntity.ok("");
    }

    @GetMapping("/checkout")
    public ResponseEntity<?> checkoutBasket(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        String message = "Your details" + basketService.getBasket();
        senderService.sendMessage("Содержимое корзины","nail_ka_war@mail.ru",message);
        return ResponseEntity.ok("");
    }
}


package com.spring.basics.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeliveryController {

    @GetMapping("/delivery")
    public String getDeliveryPage() {
        return "delivery_page";
    }
}

package com.spring.basics.controllers;

import com.spring.basics.models.Product;
import com.spring.basics.models.ProductDetails;
import com.spring.basics.repositories.CategoriesRepository;
import com.spring.basics.repositories.ProductDetailsRepository;
import com.spring.basics.repositories.ProductsRepository;
import com.spring.basics.services.interfaces.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductDetailController {

    @Autowired
    private ProductDetailsService productDetailsService;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ProductDetailsRepository productDetailsRepository;

    @GetMapping("/productDetails")
    @ResponseBody
    public List<ProductDetails> getProduct(Model model) {
        List<ProductDetails> productDetails = productDetailsRepository.findAll();
        model.addAttribute("productDetails",productDetails);
        return productDetailsService.getAllProducts();
    }

    @GetMapping("/categories/{productId}/detail")
    @ResponseBody
    public ResponseEntity<ProductDetails> getProducts(@PathVariable Long productId) {
        return ResponseEntity.ok(productDetailsRepository.findProductsByProductId(productId));
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/categories/{productId}/details")
    public String getCategoriesPage1(Model model) {
        List<ProductDetails> productDetails = productDetailsRepository.findAll();
        model.addAttribute("productDetails", productDetails);
        return "productDetails";
    }

    @GetMapping("/categories/{categoryId}/{productId}")
    public String getCategoriesPage(@PathVariable Long productId,@PathVariable Long categoryId, Model model) {
        if (productId == null) {
            List<Product> products = productsRepository.findAll();
            model.addAttribute("categories", products);
        } else {
            Optional<Product> product = productsRepository.findById(productId);
            ProductDetails productDetails = productDetailsRepository.findProductsByProductId(productId);
            product.ifPresent(value -> model.addAttribute("name", value.getName()));
            model.addAttribute("productDetails",productDetails);
            return "productDetails";
        }
        return "products";
    }
}

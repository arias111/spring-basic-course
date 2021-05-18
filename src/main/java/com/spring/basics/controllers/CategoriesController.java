package com.spring.basics.controllers;

import com.spring.basics.models.Category;
import com.spring.basics.models.Product;
import com.spring.basics.repositories.CategoriesRepository;
import com.spring.basics.repositories.ProductRepository;
import com.spring.basics.repositories.ProductsRepository;
import com.spring.basics.services.interfaces.ImageSaveService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@Controller
public class CategoriesController {

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private CategoriesRepository categoryRepository;

    @Autowired
    private ImageSaveService imageSaveService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/categories/{categoryId}")
    public String getCategoriesPage(@PathVariable Long categoryId, Model model) {
        if (categoryId == null) {
            List<Category> categories = categoryRepository.findAll();
            model.addAttribute("categories", categories);
        } else {
            Optional<Category> category = categoryRepository.findById(categoryId);
            List<Product> products = productsRepository.findProductsByCategoryId(categoryId);
            category.ifPresent(value -> model.addAttribute("name", value.getName()));
            model.addAttribute("products", products);
            return "products";
        }
        return "categories";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/categories")
    public String getCategoriesPage1(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @GetMapping("/categories/{file-name:.*}")
    public void getFile(@PathVariable("file-name") String filename, HttpServletResponse httpServletResponse) {
        imageSaveService.writeFileToResponse(filename,httpServletResponse);
    }

    @GetMapping("/getCategories")
    @ResponseBody
    public List<Category> getProduct() {
        return categoryRepository.findAll();
    }

}
package com.spring.basics.controllers;

import com.spring.basics.models.Product;
import com.spring.basics.models.User;
import com.spring.basics.repositories.UsersRepository;
import com.spring.basics.security.UserDetailsImpl;
import com.spring.basics.services.interfaces.AdminService;
import com.spring.basics.services.interfaces.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private AdminService adminService;

//    @PreAuthorize("isAuthenticated()")
//    @GetMapping("/admin")
//    public String getUsersPage(Model model) {
//        model.addAttribute("usersList",usersRepository.findAll());
//        return "user-list";
//    }
//    @PreAuthorize("hasAuthority('ADMIN')")
//    @DeleteMapping("/admin/{user-id}")
//    public ResponseEntity<?> deleteUser(@PathVariable("user-id") Long userId) {
//        usersService.deleteUser(userId);
//        return ResponseEntity.accepted().build();
//    }
//    @DeleteMapping("/admin/{id}")
//    public String deleteUser(@PathVariable("id") Long id) {
//        usersService.deleteUser(id);
//        return "redirect:/admin";
//    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String getMainPage() {
        return "admin";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String addProducts(Product form, @RequestParam("file") MultipartFile file, Model model) throws IOException {
        model.addAttribute("message", adminService.addProd(form, file));
        return "admin";
    }
}

package com.spring.basics.services.impletentations;

import com.spring.basics.dto.BasketDto;
import com.spring.basics.models.Product;
import com.spring.basics.models.User;
import com.spring.basics.repositories.ProductsRepository;
import com.spring.basics.services.interfaces.BasketService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class BasketServiceImpl implements BasketService {

    @Autowired
    private ProductsRepository productsRepository;

    @SneakyThrows
    @Override
    @Transactional
    public List<BasketDto> getBasket() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Product> productList = user.getProducts();
        return BasketDto.from(productList);
    }

    @SneakyThrows
    @Override
    @Transactional
    public void addToBasket(Long productId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Product product = productsRepository.findById(productId).orElse(null);
        List<User> userList = product.getUsers();
        userList.add(user);
        product.setUsers(userList);
        productsRepository.save(product);
    }

    @Override
    public List<BasketDto> getBasketDetails() {
        return null;
    }

}

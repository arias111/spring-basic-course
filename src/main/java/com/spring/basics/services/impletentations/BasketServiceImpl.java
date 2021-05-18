package com.spring.basics.services.impletentations;

import com.spring.basics.dto.ProductDto;
import com.spring.basics.models.Product;
import com.spring.basics.models.User;
import com.spring.basics.repositories.ProductRepository;
import com.spring.basics.repositories.UsersRepository;
import com.spring.basics.services.interfaces.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BasketServiceImpl implements BasketService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<ProductDto> getBasket() {
        UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = details.getUsername();
        User user = usersRepository.findByEmail(email).orElse(null);
        List<Product> productList = user.getProducts();
        return ProductDto.from(productList);
    }

    @Override
    public void addToBasket(Long productId) {
        UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = details.getUsername();
        User user = usersRepository.findByEmail(email).orElse(null);
        Product product = productRepository.findById(productId).orElse(null);
        List<Product> productList = user.getProducts();
        productList.add(product);
        user.setProducts(productList);
        usersRepository.save(user);
    }
}

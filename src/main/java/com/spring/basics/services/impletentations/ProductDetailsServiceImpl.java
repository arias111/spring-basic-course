package com.spring.basics.services.impletentations;

import com.spring.basics.dto.ProductDetailsDto;
import com.spring.basics.models.Product;
import com.spring.basics.models.ProductDetails;
import com.spring.basics.repositories.ProductDetailsRepository;
import com.spring.basics.services.interfaces.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {

    @Autowired
    private ProductDetailsRepository productDetailsRepository;


    @Override
    public List<ProductDetails> getAllProducts() { return productDetailsRepository.findAll(); }

    @Override
    public ProductDetails addProduct(ProductDetailsDto product) {
        return null;
    }

    @Override
    public ProductDetails getProductById(Long productId) {
        Optional<ProductDetails> optionalProduct = productDetailsRepository.findById(productId);
        return optionalProduct.get();
    }
}

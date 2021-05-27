package com.spring.basics.services.impletentations;

import com.spring.basics.dto.ProductDto;
import com.spring.basics.dto.ProductsPage;
import com.spring.basics.models.Product;
import com.spring.basics.models.User;
import com.spring.basics.repositories.ProductsRepository;
import com.spring.basics.repositories.UsersRepository;
import com.spring.basics.services.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public List<Product> getAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public Product addProduct(ProductDto product) {
        Product newProduct = Product.builder()
                .name(product.getName())
                .imageName(product.getImageName())
                .build();
        productsRepository.save(newProduct);
        return newProduct;
    }

    @Override
    public ProductsPage search(Integer size, Integer page, String query, String sortParameter, String directionParameter, Long categoryId) {
        Direction direction = Direction.ASC;
        Sort sort = Sort.by(direction, "id");

        if (directionParameter != null) {
            direction = Direction.fromString(directionParameter);
        }

        if (sortParameter != null) {
            sort = Sort.by(direction, sortParameter);
        }

        if (query == null) {
            query = "empty";
        }

        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Product> productsPage = productsRepository.search(query, pageRequest, categoryId);
        return ProductsPage.builder()
                .pagesCount(productsPage.getTotalPages())
                .products(ProductDto.from(productsPage.getContent()))
                .build();
    }

    @Override
    public List<ProductDto> getProductById(Long productId) {
        List<Product> optionalProduct = productsRepository.findProductsByCategoryId(productId);
        return ProductDto.from(optionalProduct);
    }
}

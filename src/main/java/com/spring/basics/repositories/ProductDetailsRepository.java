package com.spring.basics.repositories;

import com.spring.basics.models.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Long> {
    Optional<ProductDetails> findById(Long id);
    ProductDetails findProductsByProductId(Long productId);


}

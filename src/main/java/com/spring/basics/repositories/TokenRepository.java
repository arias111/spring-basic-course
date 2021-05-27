package com.spring.basics.repositories;

import com.spring.basics.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findFirstByToken(String token);
    Optional<Token> findFirstByUserId(Long id);
}
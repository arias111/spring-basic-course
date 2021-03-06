package com.spring.basics.repositories;

import com.spring.basics.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriesRepository extends JpaRepository<Category, Long> {
    Optional<Category> findById(Long id);
    @Query("select service from Category service where (:q = 'empty' or UPPER(service.name) like UPPER(concat('%', :q, '%'))) ")
    Page<Category> search(@Param("q") String q, Pageable pageable);
}
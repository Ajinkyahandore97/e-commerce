package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


    Page<Product> findAllByTitleContaining(String title, Pageable pageable);

    Page<Product> findByLiveTrue(Pageable pageable);
}

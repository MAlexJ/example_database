package com.malex.one_to_one_bidirectional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malex.one_to_one_bidirectional.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {}

package com.malex.one_to_one_unidirectional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malex.one_to_one_unidirectional.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {}

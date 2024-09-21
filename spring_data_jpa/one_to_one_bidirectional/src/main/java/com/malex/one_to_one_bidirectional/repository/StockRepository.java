package com.malex.one_to_one_bidirectional.repository;

import com.malex.one_to_one_bidirectional.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {}

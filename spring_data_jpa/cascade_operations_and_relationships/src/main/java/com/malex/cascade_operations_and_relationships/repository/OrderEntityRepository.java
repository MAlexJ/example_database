package com.malex.cascade_operations_and_relationships.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malex.cascade_operations_and_relationships.entity.OrderEntity;

public interface OrderEntityRepository extends JpaRepository<OrderEntity, Long> {}

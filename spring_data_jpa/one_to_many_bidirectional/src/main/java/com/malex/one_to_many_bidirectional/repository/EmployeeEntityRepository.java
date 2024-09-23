package com.malex.one_to_many_bidirectional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malex.one_to_many_bidirectional.entity.EmployeeEntity;

public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, Long> {}

package com.malex.one_to_many_bidirectional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malex.one_to_many_bidirectional.entity.DepartmentEntity;

public interface DepartmentEntityRepository extends JpaRepository<DepartmentEntity, Long> {}

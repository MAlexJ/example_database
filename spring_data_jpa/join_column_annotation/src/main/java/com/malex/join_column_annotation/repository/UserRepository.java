package com.malex.join_column_annotation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malex.join_column_annotation.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {}

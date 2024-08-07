package com.malex.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.malex.entity.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {}

package com.malex.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document(collection = "users")
@EqualsAndHashCode(exclude = {"id"})
@TypeAlias("UserEntity")
public class UserEntity {

  @MongoId private String id;

  private String username;
}

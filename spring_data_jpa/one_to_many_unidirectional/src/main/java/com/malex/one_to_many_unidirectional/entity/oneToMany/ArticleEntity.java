package com.malex.one_to_many_unidirectional.entity.oneToMany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
@Entity(name = "articles")
public class ArticleEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  /*
  * This indicates to JPA a unidirectional One-to-Many relationship between the Article and the Comment.
  * JPA will automatically generate the necessary database schema to support this relationship.
   */
  @OneToMany (targetEntity = CommentEntity.class)
  private Set<CommentEntity> comments = new HashSet<>();
}

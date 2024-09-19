package com.malex.one_to_many_unidirectional.entity.oneToMany_joinColumn;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;

@Data
@Entity(name = "items")
public class ItemEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "information", nullable = false)
  private String description;

  /*
   * This indicates to JPA a unidirectional One-to-Many relationship between the Article and the Comment.
   * JPA will automatically generate the necessary database schema to support this relationship.
   *
   * FetchType by default:
   *
   * OneToMany: LAZY
   * ManyToOne: EAGER
   * ManyToMany: LAZY
   * OneToOne: EAGER
   * (see JPA 2.1 Spec)
   */
  @OneToMany(targetEntity = DetailEntity.class)
  @JoinColumn(name = "item_id")
  /*
   * Unidirectional with join table:
   * link: https://docs.jboss.org/hibernate/stable/annotations/reference/en/html/entity.html#entity-mapping-association-collections
   */
  private Set<DetailEntity> entities = new HashSet<>();
}

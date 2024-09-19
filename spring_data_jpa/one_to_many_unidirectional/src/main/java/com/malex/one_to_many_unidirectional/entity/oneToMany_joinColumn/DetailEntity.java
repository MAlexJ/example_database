package com.malex.one_to_many_unidirectional.entity.oneToMany_joinColumn;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "details")
public class DetailEntity {

  /*
   * Indicates that the persistence provider must assign primary keys for the entity using a database identity column
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "information", nullable = false)
  private String information;

  @Column(name = "item_id")
  private Long itemId;
}

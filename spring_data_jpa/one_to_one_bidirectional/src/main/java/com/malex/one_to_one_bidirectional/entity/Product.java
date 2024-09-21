package com.malex.one_to_one_bidirectional.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "product_id", nullable = false)
  private Long id;

  @Column(name = "product_name", nullable = false)
  private String productName;

  @Column(name = "product_price", nullable = false)
  private int productPrice;

  /*
   * Product-Stock One-To-One Unidirectional Relationship Mapping
   *
   * With FetchType.LAZY and @ToString(exclude = "stock") at the entity Class level,
   * it will fetch the details of the Parent only i.e. Product
   *
   * With FetchType.EAGER, it will fetch the details of the Child along with the Parent i.e.
   * both Stock and Product details
   *
   */
  @OneToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
  @JoinColumn(name = "stock_id", referencedColumnName = "stock_id")
  private Stock stock;
}

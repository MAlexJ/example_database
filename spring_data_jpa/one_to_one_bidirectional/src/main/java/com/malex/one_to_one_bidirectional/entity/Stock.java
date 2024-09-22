package com.malex.one_to_one_bidirectional.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "stock")
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "stock_id", nullable = false)
  private Long id;

  @Column(name = "stock_quantity", nullable = false)
  private int stockQuantity;

  @Column(name = "stock_status", nullable = false)
  @Enumerated(EnumType.STRING)
  private StockStatus stockStatus;

  // Can define 'cascade = CascadeType.ALL' here as well instead of in Product entity
  @OneToOne(mappedBy = "stock")
  private Product product;
}

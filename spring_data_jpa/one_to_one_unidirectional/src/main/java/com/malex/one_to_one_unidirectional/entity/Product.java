package com.malex.one_to_one_unidirectional.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Objects;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long productId;

  private String productName;

  private int productPrice;

  // Product-Stock One-To-One Unidirectional Relationship Mapping

  // By using CascadeType.ALL, it essentially means that any operation performed on the parent
  // entity should also be performed on the child entity.

  // With FetchType.LAZY and @ToString(exclude = "stock") at the entity Class level,
  // it will fetch the details of the Parent only i.e. Product

  // With FetchType.EAGER, it will fetch the details of the Child along with the Parent i.e.
  // both Stock and Product details

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

  /*
   * @JoinColumn annotation specifies the foreign key column in the Product table
   * that references the id column in the Stock table.
   *
   * This means Foreign key will be created only in the Product table i.e.
   * extra column 'stock_id' will be created in the Product table
   */
  @JoinColumn(name = "stock_id", referencedColumnName = "stockId")
  private Stock stock;

  @Override
  public final boolean equals(Object o) {
    if (this == o) return true;
    if (o == null) return false;
    Class<?> oEffectiveClass =
        o instanceof HibernateProxy
            ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass()
            : o.getClass();
    Class<?> thisEffectiveClass =
        this instanceof HibernateProxy
            ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass()
            : this.getClass();
    if (thisEffectiveClass != oEffectiveClass) return false;
    Product product = (Product) o;
    return getProductId() != null && Objects.equals(getProductId(), product.getProductId());
  }

  @Override
  public final int hashCode() {
    return this instanceof HibernateProxy
        ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
        : getClass().hashCode();
  }
}

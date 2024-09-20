package com.malex.one_to_many_unidirectional.entity.oneToMany_joinColumn;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

@NamedQueries({
  @NamedQuery(
      name = "ItemEntity.findItemWithDetailsByItemId",
      query = "select i from items i left JOIN details d on d.itemId = i.id where i.id = ?1")
})
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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
  @ToString.Exclude
  /*
   * Unidirectional with join table:
   * link: https://docs.jboss.org/hibernate/stable/annotations/reference/en/html/entity.html#entity-mapping-association-collections
   */
  private Set<DetailEntity> details = new HashSet<>();

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
    ItemEntity that = (ItemEntity) o;
    return getId() != null && Objects.equals(getId(), that.getId());
  }

  @Override
  public final int hashCode() {
    return this instanceof HibernateProxy
        ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode()
        : getClass().hashCode();
  }
}

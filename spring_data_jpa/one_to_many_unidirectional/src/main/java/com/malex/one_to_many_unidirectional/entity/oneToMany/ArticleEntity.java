package com.malex.one_to_many_unidirectional.entity.oneToMany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.proxy.HibernateProxy;

/*
 *  Spring Data JPA supports JPQL (Java Persistence Query Language).
 *
 * JPQL is the standardized query language used in JPA (Java Persistence API),
 * and it is very similar to HQL (Hibernate Query Language).
 * JPQL operates on the entity objects defined in the application rather than directly on database tables,
 * allowing queries to be constructed in a more object-oriented way.
 *
 * While HQL is specific to Hibernate, JPQL is the standard used across various JPA implementations, including Hibernate.
 * Since Spring Data JPA abstracts over JPA, it follows the JPQL standard, but it can also work with HQL
 * if Hibernate is the underlying JPA provider.
 */
@NamedQueries({
  @NamedQuery(
      name = "ArticleEntity.findArticleById",
      query = "select a from articles a where a.id = ?1"),
  @NamedQuery(
      name = "ArticleEntity.findArticleWithCommentsByArticleId",
      query = "select a from articles a left JOIN comments c where a.id = ?1")
})
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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
  @OneToMany(targetEntity = CommentEntity.class)
  @ToString.Exclude
  private Set<CommentEntity> comments = new HashSet<>();

  @Override
  public final boolean equals(Object o) {
    if (this == o) return true;
    if (o == null) return false;
    Class<?> oEffectiveClass =
            o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() :
                    o.getClass();
    Class<?> thisEffectiveClass = this instanceof HibernateProxy ?
            ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
    if (thisEffectiveClass != oEffectiveClass) return false;
    ArticleEntity article = (ArticleEntity) o;
    return getId() != null && Objects.equals(getId(), article.getId());
  }

  @Override
  public final int hashCode() {
    return this instanceof HibernateProxy ?
            ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() :
            getClass().hashCode();
  }
}

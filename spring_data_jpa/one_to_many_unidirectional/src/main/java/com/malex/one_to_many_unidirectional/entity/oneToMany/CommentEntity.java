package com.malex.one_to_many_unidirectional.entity.oneToMany;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.proxy.HibernateProxy;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "comments")
public class CommentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "description")
  private String description;

  @Column(name = "date")
  private LocalDateTime date;

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
    CommentEntity comment = (CommentEntity) o;
    return getId() != null && Objects.equals(getId(), comment.getId());
  }

  @Override
  public final int hashCode() {
    return this instanceof HibernateProxy ?
            ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() :
            getClass().hashCode();
  }
}

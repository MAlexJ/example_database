package com.malex.one_to_many_bidirectional.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "department")
public class DepartmentEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "department_id", nullable = false)
  private Long departmentId;

  private String name;

  private String departmentCode;

  /*
   * @OneToMany is used to define a one-to-many relationship between two entities
   *
   * Params:
   *
   * mappedBy - attribute specifies the field in the target entity (many side) that owns the relationship
   *
   * cascade - attribute determines the operations (e.g., save, update, delete)
   *           that should be cascaded to the target entity.
   */
  @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<EmployeeEntity> employees;
}

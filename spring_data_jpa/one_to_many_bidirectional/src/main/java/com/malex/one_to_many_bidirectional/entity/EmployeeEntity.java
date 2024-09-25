package com.malex.one_to_many_bidirectional.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "employee")
public class EmployeeEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "employee_id", nullable = false)
  private Long employeeId;

  private String name;

  /*
   * @ManyToOne is used to define the many-to-one relationship from the target entity (many side)
   * to the owning entity (one side).
   *
   * It indicates that many instances of this entity can be associated with one instance
   * of the owning entity.
   */
  @ManyToOne
  /*
   * @JoinColumn - Specifies a column for joining an entity association or element collection.
   * If the JoinColumn annotation itself is defaulted, a single join column is assumed and the default values apply.
   *
   * name - (Optional) The name of the foreign key column. The table in which it is found depends upon the context.
   * referencedColumnName - (Optional) The name of the column referenced by this foreign key column.
   *
   * SQL: FOREIGN KEY (PersonID) REFERENCES Persons(PersonID)
   */
  @JoinColumn(name = "department_id", referencedColumnName = "department_id")
  private DepartmentEntity department;
}

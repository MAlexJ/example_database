package com.malex.many_to_many_unidirectional.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class CustomNativeRepository {

  @PersistenceContext private EntityManager entityManager;

  @Transactional
  public void runNativeQuery(Long studentId, Long courseId) {
    var query =
        entityManager.createNativeQuery(
            "INSERT INTO student_courses (student_id, course_id) VALUES (?, ?)");
    query.setParameter(1, studentId);
    query.setParameter(2, courseId);
    int executeUpdate = query.executeUpdate();
    log.info("Rows affected - {}", executeUpdate);
  }
}

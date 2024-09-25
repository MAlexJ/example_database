package com.malex.many_to_many_unidirectional.repository;

import com.malex.many_to_many_unidirectional.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {}

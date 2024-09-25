package com.malex.many_to_many_unidirectional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malex.many_to_many_unidirectional.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {}

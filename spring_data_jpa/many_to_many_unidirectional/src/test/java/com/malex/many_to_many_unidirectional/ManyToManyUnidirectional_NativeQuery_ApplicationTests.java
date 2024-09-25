package com.malex.many_to_many_unidirectional;

import com.malex.many_to_many_unidirectional.entity.Course;
import com.malex.many_to_many_unidirectional.entity.Student;
import com.malex.many_to_many_unidirectional.repository.CourseRepository;
import com.malex.many_to_many_unidirectional.repository.CustomNativeRepository;
import com.malex.many_to_many_unidirectional.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class ManyToManyUnidirectional_NativeQuery_ApplicationTests {

  @Autowired private CourseRepository courseRepository;

  @Autowired private StudentRepository studentRepository;

  @Autowired private CustomNativeRepository customNativeRepository;

  @Test
  void createCourseAndAddStudent_and_enrollmentStudentsToCourse() {

    /*
     * Hibernate:
     * insert into course (course_code, name, id) values (?, ?, default)
     */
    var java = new Course();
    java.setName("Java");
    java.setCourseCode("001");
    var courseId = courseRepository.save(java).getCourseId();
    log.info("Save course, id - {}", courseId);

    var max = new Student();
    max.setName("Max");
    var maxId = studentRepository.save(max).getStudentId();
    log.info("Save student, id - {}", maxId);

    var anna = new Student();
    anna.setName("Anna");
    var annaId = studentRepository.save(anna).getStudentId();
    log.info("Save student, id - {}", annaId);

    /* Enrollment of students in the course */

    /*
     * 1. SQL:
     * INSERT  INTO  student_courses (student_id, course_id)  VALUES (?, ?)
     */
    customNativeRepository.runNativeQuery(maxId, courseId);

    /*
     * 1. SQL:
     * INSERT  INTO  student_courses (student_id, course_id)  VALUES (?, ?)
     */
    customNativeRepository.runNativeQuery(annaId, courseId);
  }
}

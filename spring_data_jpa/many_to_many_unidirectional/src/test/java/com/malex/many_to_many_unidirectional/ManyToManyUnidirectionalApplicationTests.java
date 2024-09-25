package com.malex.many_to_many_unidirectional;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.malex.many_to_many_unidirectional.entity.Course;
import com.malex.many_to_many_unidirectional.entity.Student;
import com.malex.many_to_many_unidirectional.repository.CourseRepository;
import com.malex.many_to_many_unidirectional.repository.StudentRepository;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class ManyToManyUnidirectionalApplicationTests {

  @Autowired private CourseRepository courseRepository;

  @Autowired private StudentRepository studentRepository;

  @Test
  void createCourseAndAddStudent() {

    /*
     * Hibernate:
     * insert into course (course_code, name, id) values (?, ?, default)
     */
    var java = new Course();
    java.setName("Java");
    java.setCourseCode("001");
    var persistJavaCourse = courseRepository.save(java);

    log.info("Save course - {}", persistJavaCourse);

    Student max = new Student();
    max.setName("Max");
    studentRepository.save(max);
    log.info("Save student - {}", max);

    Student anna = new Student();
    max.setName("Anna");
    studentRepository.save(anna);
    log.info("Save student - {}", anna);

    assertTrue(max.getCourses().isEmpty());
    assertTrue(anna.getCourses().isEmpty());

    max.setCourses(Set.of(persistJavaCourse));
    anna.setCourses(Set.of(persistJavaCourse));

    studentRepository.save(max);
    studentRepository.save(anna);
  }
}

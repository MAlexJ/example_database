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
  void createCourseAndAddStudent_and_enrollmentStudentsToCourse() {

    /*
     * Hibernate:
     * insert into course (course_code, name, id) values (?, ?, default)
     */
    var java = new Course();
    java.setName("Java");
    java.setCourseCode("001");
    var persistJavaCourse = courseRepository.save(java);

    log.info("Save course - {}", persistJavaCourse);

    var max = new Student();
    max.setName("Max");
    var persistMax = studentRepository.save(max);
    log.info("Save student - {}", max.getName());
    assertTrue(persistMax.getCourses().isEmpty());

    var anna = new Student();
    anna.setName("Anna");
    var persistAnna = studentRepository.save(anna);
    log.info("Save student - {}", anna.getName());
    assertTrue(persistAnna.getCourses().isEmpty());

    /** Enrollment of students in the course */
    persistMax.setCourses(Set.of(persistJavaCourse));
    persistAnna.setCourses(Set.of(persistJavaCourse));

    /*
     * 1. SQL:
     * select s1_0.id, c1_0.student_id, c1_1.id, c1_1.course_code, c1_1.name, s1_0.name
     *   from student s1_0
     *     left join student_courses c1_0 on s1_0.id=c1_0.student_id
     *     left join course c1_1 on c1_1.id=c1_0.course_id
     *   where s1_0.id=?
     *
     *  2. SQL:
     * select c1_0.id, c1_0.course_code, c1_0.name from course c1_0
     * where c1_0.id=?
     *
     * 3. SQL:
     * insert  into  student_courses (student_id, course_id) values (?, ?)
     */
    studentRepository.save(persistMax);

    /*
     *  1. SQL: select
     * 2. SQL: select
     * 3. SQL: insert
     */
    studentRepository.save(persistAnna);
  }
}

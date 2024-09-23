package com.malex.one_to_many_bidirectional;

import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.malex.one_to_many_bidirectional.entity.DepartmentEntity;
import com.malex.one_to_many_bidirectional.entity.EmployeeEntity;
import com.malex.one_to_many_bidirectional.repository.DepartmentEntityRepository;
import com.malex.one_to_many_bidirectional.repository.EmployeeEntityRepository;

@SpringBootTest
class OneToManyBidirectionalApplicationTests {

  @Autowired
  private DepartmentEntityRepository departmentEntityRepository;

  @Autowired
  private EmployeeEntityRepository employeeEntityRepository;

  @Test
  void createDepartmentAndEmployees() {

    DepartmentEntity department = DepartmentEntity.builder()
            .name("Department 1")
            .departmentCode("123")
            .build();

    departmentEntityRepository.save(department);

    EmployeeEntity malex = EmployeeEntity.builder()
            .name("Malex")
            .department(department)
            .build();

    EmployeeEntity cat = EmployeeEntity.builder()
            .name("Cat")
            .department(department)
            .build();

    employeeEntityRepository.saveAll(List.of(malex, cat));




  }
}

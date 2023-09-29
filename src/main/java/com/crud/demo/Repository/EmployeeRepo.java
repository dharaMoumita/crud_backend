package com.crud.demo.Repository;

import com.crud.demo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    List<Employee> findByDepartmentId(int deptId);
}

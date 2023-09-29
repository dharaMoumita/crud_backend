package com.crud.demo.Service;

import com.crud.demo.Entity.Department;
import com.crud.demo.Entity.DepartmentDTO;
import com.crud.demo.Entity.Employee;
import com.crud.demo.Entity.EmployeeDTO;

import java.util.List;

public interface DepartmentService {

    DepartmentDTO addDepartment(Department department);
    List<EmployeeDTO> findByDepartmentId(int id);
    void deleteDepartment(int deptId);
    Department findDepartmentById(int id);
    String deleteEmployeebydept(int dept_id,int emp_id);
    String changeDepartment(int old_dept_id,int emp_id,int new_dept_id);
    List<DepartmentDTO> displayAllDept();
    String updateDept(Department department,int id);
    void addByDepartmentId(List<Employee> emp,int id);
String updateDetailsByDept(EmployeeDTO employee,int dept_id,int emp_id);
    void updateAllEmployees(EmployeeDTO employee,int dept_id);
    DepartmentDTO getDeptbyId(int id);



}

package com.crud.demo.Service;

import com.crud.demo.Entity.Employee;
import com.crud.demo.Entity.EmployeeDTO;

import java.util.List;

public interface EmployeeSerVice {
//     Employee createEmployee(Employee employee);
     List<EmployeeDTO> getAllEmployee();
     EmployeeDTO getEmployeeById(int id);
     void deleteEmployee(int id);
     EmployeeDTO updateEmployees(EmployeeDTO employee,int  id);

//     List<Employee> getEmployeesByDept(int dept_id);
     EmployeeDTO addEmployee(EmployeeDTO employee);
}

package com.crud.demo.Controller;

import com.crud.demo.Entity.Department;
import com.crud.demo.Entity.Employee;
import com.crud.demo.Entity.EmployeeDTO;
import com.crud.demo.Repository.DepartmentRepo;
import com.crud.demo.Repository.EmployeeRepo;
import com.crud.demo.Service.EmployeeSerVice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeSerVice employeeSerVice;
    @Autowired
    public EmployeeController(EmployeeSerVice employeeSerVice) {
        this.employeeSerVice = employeeSerVice;
    }

    @Autowired
    private DepartmentRepo departmentRepo;

    @Autowired
    private EmployeeRepo employeeRepo;


    //Add Employee
    @PostMapping("/employees")
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employee){
        return employeeSerVice.addEmployee(employee);
    }

    //Get all employee
    @GetMapping("/employees")
    public List<EmployeeDTO> findAllEmployees(){
        return employeeSerVice.getAllEmployee();


    }

    //Get employees by id
    @GetMapping("/employees/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable int id){
        return employeeSerVice.getEmployeeById(id);

    }


    //Delete employees
    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeSerVice.deleteEmployee(id);
    }

    //Update employees
    @PutMapping("/employees/{id}")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employee,@PathVariable int id){
        return employeeSerVice.updateEmployees(employee,id);

    }

    //get department of employee
    @GetMapping("/employees/dept/{id}")
    public String getDepartment(@PathVariable int id){
        EmployeeDTO e=employeeSerVice.getEmployeeById(id);
        //Department department=e.getDepartment();
        return null;
    }
//

//    @GetMapping("/getAllPostsByUserId/{dept_id}/getPosts")
//    public ResponseEntity<List<Employee>> getAllPostsByUserId(@PathVariable(value = "dept_id") Integer deptId) {
//        if (!departmentRepo.existsById(deptId)) {
//            throw new EmployeeNotFoundException("Not found User with id = " + deptId);
//        }
//
//        List<Employee> comments = postRepo.findByUserId(userId);
//        return new ResponseEntity<>(comments, HttpStatus.OK);
//    }



//    @GetMapping("/byDepartment/{departmentId}")
//    public ResponseEntity<List<Employee>> getEmployeesByDepartmentId(@PathVariable Integer departmentId) {
//        List<Employee> employees = employeeSerVice.getEmployeesByDept(departmentId);
//        if (employees.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(employees);
//    }


}

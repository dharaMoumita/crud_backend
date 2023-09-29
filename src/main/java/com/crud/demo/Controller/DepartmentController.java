package com.crud.demo.Controller;

import com.crud.demo.Entity.Department;
import com.crud.demo.Entity.DepartmentDTO;
import com.crud.demo.Entity.Employee;
import com.crud.demo.Entity.EmployeeDTO;
import com.crud.demo.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentController {
    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    //Add department
    @PostMapping("/department")
    public DepartmentDTO addDept(@RequestBody Department department){
        return departmentService.addDepartment(department);

    }

    //Delete Department
    @DeleteMapping("/department/{id}")
    public void deleteDepartment(@PathVariable int id){
        departmentService.deleteDepartment(id);
    }


    //Display all department
    @GetMapping("/department")
    public List<DepartmentDTO> getDepartment(){
        return departmentService.displayAllDept();
    }

    //Get Department by id
    @GetMapping("/department/{id}")
    public DepartmentDTO getDepartmentById(@PathVariable int id){

        return departmentService.getDeptbyId(id);

    }

    //Get employees according to department
    @GetMapping("/dept/{id}")
    public List<EmployeeDTO> getEmployeeByDeptId(@PathVariable int id){
        return departmentService.findByDepartmentId(id);

    }

    //Delete employee by department
    @DeleteMapping("/department/{emp_id}/{dept_id}")
    public String deleteEmployeebydept(@PathVariable int emp_id,
                                         @PathVariable int dept_id){
       return departmentService.deleteEmployeebydept(emp_id,dept_id);

    }


    //Change employee's department
    @PutMapping("department/{old_dept_id}/{emp_id}/{new_dept_id}")
    public String updateEmpByDept(@PathVariable int old_dept_id,@PathVariable int emp_id,
                                    @PathVariable int new_dept_id){
        return departmentService.changeDepartment(old_dept_id, emp_id, new_dept_id);
    }

    //Add list of employees
    @PostMapping("/department/{id}")
    public List<EmployeeDTO> addEmployeesByDeptId(@RequestBody List<Employee> employeesList,@PathVariable int id){
         departmentService.addByDepartmentId(employeesList,id);
         return departmentService.findByDepartmentId(id);
    }

    //Update details of single Employee
    @PutMapping("/departmentUpdate/{dept_id}/{emp_id}")
    public String changeDetailsByDepartment(@RequestBody EmployeeDTO employee,@PathVariable int dept_id,@PathVariable int emp_id){

        return departmentService.updateDetailsByDept(employee,dept_id,emp_id);
    }

    //Update department details
    @PutMapping("/dept/{id}")
    public  String updateDepartment(@RequestBody Department department,@PathVariable int id){
        return  departmentService.updateDept(department,id);
    }

    //Update details of all employees
    @PutMapping("/department/{dept_id}")
    public void updateAllEmployees(@RequestBody EmployeeDTO employee,@PathVariable int dept_id){
        departmentService.updateAllEmployees(employee,dept_id);
    }

//    @PutMapping("/dept/{dept_id}")
//    public void deleteDepartMent(@PathVariable Integer dept_id){
//        departmentService.deleteDepartmentAndNull(dept_id);
//    }
}

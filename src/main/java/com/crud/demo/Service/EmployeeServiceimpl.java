package com.crud.demo.Service;

import com.crud.demo.Entity.Department;
import com.crud.demo.Entity.Employee;
import com.crud.demo.Entity.EmployeeDTO;
import com.crud.demo.Repository.DepartmentRepo;
import com.crud.demo.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceimpl implements  EmployeeSerVice{
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private DepartmentRepo departmentRepo;
//   @Autowired
//    private DepartmentService departmentService;




    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> employeeList= employeeRepo.findAll();
        List<EmployeeDTO> employeeDTOList=new ArrayList<>();
        for(Employee e:employeeList){
            int dept_id=e.getDepartment().getId();
            EmployeeDTO employeeDTO=new EmployeeDTO(e.getId(), e.getFirstName(), e.getLastName(), e.getEmail(), dept_id);
            employeeDTOList.add(employeeDTO);
        }
        return employeeDTOList;
    }

    @Override
    public EmployeeDTO getEmployeeById(int id) {
        Employee temp=employeeRepo.findById(id).orElse(null);
        Department department=temp.getDepartment();
        EmployeeDTO employeeDTO=new EmployeeDTO(temp.getId(), temp.getFirstName(), temp.getFirstName(), temp.getEmail(), department.getId());
        return employeeDTO;
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public EmployeeDTO updateEmployees(EmployeeDTO employeeDTO, int id) {
        Employee employee1=employeeRepo.findById(id).orElse(null);
        System.out.println(employee1);
        System.out.println(employeeDTO);
        if(employeeDTO.getFirstName()!=null) employee1.setFirstName(employeeDTO.getFirstName());
        if(employeeDTO.getLastName()!=null) employee1.setLastName(employeeDTO.getLastName());
        if(employeeDTO.getEmail()!=null) employee1.setEmail(employeeDTO.getEmail());

        employeeRepo.save(employee1);


      return EmployeetoEmployeeDto(employee1);
    }

//    @Override
//    public List<Employee> getEmployeesByDept(int dept_id) {
//        return employeeRepo.findByDepartmentId(dept_id);



    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO){
        Department department=departmentRepo.findById(employeeDTO.getDept_id()).orElse(null);

            Employee employee = new Employee(employeeDTO.getFirstName(),employeeDTO.getLastName(),employeeDTO.getEmail());
            employee.setDepartment(department);
            employeeRepo.save(employee);

            return  EmployeetoEmployeeDto(employee);

    }

     private EmployeeDTO EmployeetoEmployeeDto(Employee employee){
        EmployeeDTO employeeDTO=new EmployeeDTO(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getDepartment().getId());
        return employeeDTO;
    }
     private Employee EmployeeDTOtoEmployee(EmployeeDTO employeeDTO){
        Employee employee=new Employee();
        employee.setLastName(employeeDTO.getLastName());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDepartment(departmentRepo.findById(employeeDTO.getDept_id()).orElse(null));
        return employee;
    }
//    @Override
//    public List<Employee> getEmployeesByDept(int dept_id) {
//        return employeeRepo.findByDepartmentId(dept_id);
//    }

//    @Override
//    public Employee createEmployee(Employee employee) {
//
//        int d=employee.getDepartment().getId();
//        if(departmentService.findDepartmentById(d)==null)
//            departmentService.addDepartment(employee.getDepartment());
//
//        return employeeRepo.save(employee);
//    }


}

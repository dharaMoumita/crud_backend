package com.crud.demo.Service;

import com.crud.demo.Entity.Department;
import com.crud.demo.Entity.DepartmentDTO;
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
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
    private EmployeeSerVice employeeSerVice;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public DepartmentDTO addDepartment(Department department) {
        Department department1=departmentRepo.save(department);
        return  DepartmentToDepartmentDTO(department1);

    }



      @Override
    public List<EmployeeDTO> findByDepartmentId(int id) {
            Department department=departmentRepo.findById(id).orElse(null);
            List<EmployeeDTO> employeeDTOList=new ArrayList<>();
            for(Employee i: department.getEmployees()){
                EmployeeDTO employeeDTO=new EmployeeDTO(i.getId(),i.getFirstName(),i.getLastName(),i.getEmail(),i.getDepartment().getId());
                employeeDTOList.add(employeeDTO);
            }
            return employeeDTOList;
    }

    @Override
    public void deleteDepartment(int deptId) {
        Department department=departmentRepo.findById(deptId).orElse(null);
        departmentRepo.delete(department);
    }

    @Override
    public Department findDepartmentById(int id) {
        Optional<Department> dept=departmentRepo.findById(id);
        Department temp=null;
        if(dept.isPresent()){
            temp=dept.get();
        }
        System.out.println(temp);
        return temp;
    }

    @Override
    public String deleteEmployeebydept(int emp_id, int dept_id) {
        Employee employee=employeeRepo.findById(emp_id).orElse(null);
        if(employee.getDepartment().getId()!=dept_id){
            return "Not in your Department";
        }

        else{
            employeeSerVice.deleteEmployee(emp_id);
        }
        return "Employee Deleted";
    }

    @Override
    public String changeDepartment(int old_dept_id, int emp_id, int new_dept_id) {
        Employee employee=employeeRepo.findById(emp_id).orElse(null);
        if(employee.getDepartment().getId()!=old_dept_id){
            return "Not in your department";
        }
        else {
            employee.setDepartment(this.findDepartmentById(new_dept_id));
            //System.out.println(employee);
           employeeRepo.save(employee);
           return "Department Changed";
        }

    }

    @Override
    public List<DepartmentDTO> displayAllDept() {
        List<DepartmentDTO>departmentDTOList=new ArrayList<>();
        List<Department> dept=departmentRepo.findAll();
        for(Department i:dept){
            DepartmentDTO departmentDTO=DepartmentToDepartmentDTO(i);
            departmentDTOList.add(departmentDTO);
        }

        return departmentDTOList;
    }

    @Override
    public String updateDept(Department department,int id) {
        // Optional<Department> dept=departmentRepo.findById(department.getId());
        Department department1 = departmentRepo.findById(id).orElse(null);
        if (department1 != null) {
            department1.setName(department.getName());
            departmentRepo.save(department1);
            return "Updated";
        }

        else{
                return "Department not Present";
            }


    }

    @Override
    public void addByDepartmentId(List<Employee> emp,int id) {
        for (Employee i:emp){
            i.setDepartment(findDepartmentById(id));
            employeeRepo.save(i);
        }
       // return findByDepartmentId(id);
    }

    public boolean findEmpByDept(int emp_id,int dept_id){
//        List<Employee> empList=findByDepartmentId(dept_id);
//        for(Employee i:empList){
//            if(i.getId()==emp_id)
//                return true;
//        }
        return false;
    }

    @Override
    public String updateDetailsByDept(EmployeeDTO employeeDTO,int dept_id,int emp_id) {

        Employee employee1=employeeRepo.findById(emp_id).orElse(null);
        if(employee1!=null) {
            if(employeeDTO.getFirstName()!=null) employee1.setFirstName(employeeDTO.getFirstName());
            if(employeeDTO.getLastName()!=null) employee1.setLastName(employeeDTO.getLastName());
            if(employeeDTO.getEmail()!=null) employee1.setEmail(employeeDTO.getEmail());

            employeeRepo.save(employee1);
           // System.out.println(employeeRepo.findById(employee.getId()));
            return "Updated";
        }
        else {
            return "Employee not present";
        }
    }

    @Override
    public void updateAllEmployees(EmployeeDTO employeeDTO,int dept_id) {
        Department department=departmentRepo.findById(dept_id).orElse(null);
        List<Employee> employeeList=department.getEmployees();
        for(Employee i:employeeList){
            if(employeeDTO.getFirstName()!=null) i.setFirstName(employeeDTO.getFirstName());
            if(employeeDTO.getLastName()!=null) i.setLastName(employeeDTO.getLastName());
            if(employeeDTO.getEmail()!=null) i.setEmail(employeeDTO.getEmail());
            employeeRepo.save(i);

        }



    }

    @Override
    public DepartmentDTO getDeptbyId(int id) {
        Department department=findDepartmentById(id);
        DepartmentDTO departmentDTO=DepartmentToDepartmentDTO(department);
        return departmentDTO;
    }


    private Department DepartmentDTOtoDepartment(DepartmentDTO departmentDTO){
        Department department=new Department(departmentDTO.getName());
        return department;
    }
    private DepartmentDTO DepartmentToDepartmentDTO(Department department){
        DepartmentDTO departmentDTO=new DepartmentDTO(department.getId(), department.getName());
        return departmentDTO;
    }

    }



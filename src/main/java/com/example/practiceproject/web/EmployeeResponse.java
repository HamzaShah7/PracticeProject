package com.example.practiceproject.web;

import com.example.practiceproject.domain.Employee;
import com.example.practiceproject.exceptions.UserNotFoundException;
import com.example.practiceproject.repo.EmployeeRepo;
import com.example.practiceproject.services.impl.EmployeeDTO;
import com.example.practiceproject.services.inter.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeResponse {

    private final EmployeeRepo employeeRepo;
    private final EmployeeService employeeService;

    public EmployeeResponse(EmployeeRepo employeeRepo, EmployeeService employeeService) {
        this.employeeRepo = employeeRepo;
        this.employeeService = employeeService;
    }


    @GetMapping("/Employees")
    public List<Employee> retrieveAllEmployee(){
        return employeeRepo.findAll();
    }

    @GetMapping("/Employees/{id}")
    public Optional<Employee> retrieveEmployee(@PathVariable int id){
        Optional<Employee> emp = employeeRepo.findById(id);
        if (emp.isEmpty()){
            throw new UserNotFoundException("id: "+id);
        }
        return emp;
    }

    @DeleteMapping("/Employees/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeRepo.deleteById(id);
    }

    @PostMapping("/Employees")
    public ResponseEntity<Object> createEmployee(@RequestBody Employee employee){
        Employee emp =employeeRepo.save(employee);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(emp.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/Department/Employees")
    public List<EmployeeDTO> getEmployeesByDepartment(@RequestParam String dept){

        List<EmployeeDTO> employeesByDepartment = employeeService.findByDepartmentName(dept);

        //List<EmployeeDTO> employeeDTOList = employeeService.ConvertEntityToDTO(employeesByDepartment);

        if (employeesByDepartment.isEmpty()){
            throw new UserNotFoundException("Department: "+dept);
        }
        return employeesByDepartment;
    }
}
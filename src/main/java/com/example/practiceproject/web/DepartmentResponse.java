package com.example.practiceproject.web;

import com.example.practiceproject.domain.Department;
import com.example.practiceproject.exceptions.UserNotFoundException;
import com.example.practiceproject.repo.DepartmentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentResponse {

    @Autowired
    private DepartmentRepo departmentRepo;

    @GetMapping("/Departments")
    public List<Department> retrieveAllDepartment(){
        return departmentRepo.findAll();
    }

    @GetMapping("/Department")
    public Optional<Department> retrieveDepartment(@RequestParam String dept){
        Optional<Department> department = departmentRepo.findById(dept);
        if (department.isEmpty()){
            throw new UserNotFoundException("Department Name: "+dept);
        }
        return department;
    }

    @DeleteMapping("/Departments/{name}")
    public void deleteDepartment(@RequestParam String name){
        departmentRepo.deleteById(name);
    }

    @PostMapping("/Departments")
    public ResponseEntity<Object> createDepartment(@RequestBody Department department){
        Department dept =departmentRepo.save(department);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{deptName}")
                .buildAndExpand(dept.getDeptName())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
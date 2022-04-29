package com.example.practiceproject.web;

import com.example.practiceproject.domain.Employee;
import com.example.practiceproject.domain.Salary;
import com.example.practiceproject.exceptions.UserNotFoundException;
import com.example.practiceproject.repo.EmployeeRepo;
import com.example.practiceproject.repo.SalaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class SalaryResponse {

    @Autowired
    private SalaryRepo salaryRepo;

    @GetMapping("/Salaries")
    public List<Salary> retrieveAllEmployee(){
        return salaryRepo.findAll();
    }

    @GetMapping("/Salaries/{id}")
    public Optional<Salary> retrieveEmployee(@PathVariable int id){
        Optional<Salary> sal = salaryRepo.findById(id);
        if (sal.isEmpty()){
            throw new UserNotFoundException("id: "+id);
        }
        return sal;
    }

    @DeleteMapping("/Salaries/{id}")
    public void deleteEmployee(@PathVariable int id){
        salaryRepo.deleteById(id);
    }

    @PostMapping("/Salaries")
    public ResponseEntity<Object> createEmployee(@RequestBody Salary sal){
        Salary salary = salaryRepo.save(sal);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(salary.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}

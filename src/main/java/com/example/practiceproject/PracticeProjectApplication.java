package com.example.practiceproject;

import com.example.practiceproject.domain.Department;
import com.example.practiceproject.domain.Employee;
import com.example.practiceproject.domain.Leaves;
import com.example.practiceproject.repo.DepartmentRepo;
import com.example.practiceproject.repo.EmployeeRepo;
import com.example.practiceproject.repo.LeavesRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PracticeProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticeProjectApplication.class, args);
    }


    @Bean
    CommandLineRunner commandLineRunner1(DepartmentRepo departmentRepo){
        return args -> {
            departmentRepo.save(new Department("Sales"));
            departmentRepo.save(new Department("IT"));
            departmentRepo.save(new Department("Finance"));
        };
    }

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepo employeeRepo, DepartmentRepo departmentRepo){
        return args -> {
            employeeRepo.save(new Employee("Ali",new Date(2019,12,2), departmentRepo.findById("Sales").get()));
            employeeRepo.save(new Employee("Hassan",new Date(2016,11,2), departmentRepo.findById("IT").get()));
            employeeRepo.save(new Employee("Aslam",new Date(2021,12,2), departmentRepo.findById("Sales").get()));
        };
    }
}

package com.example.practiceproject.services;

import com.example.practiceproject.domain.Employee;
import com.example.practiceproject.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<EmployeeDTO> getAllEmployee(String dept){
        return employeeRepo.findAll()
                .stream()
                .map(employee -> convertEntitytoDTO(employee,dept))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public EmployeeDTO convertEntitytoDTO(Employee employee, String dept){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        if (dept.equals(employee.getDepartment().getDeptName())) {
            employeeDTO.setDeptName(employee.getDepartment().getDeptName());
            employeeDTO.setEmpName(employee.getEmpName());
            employeeDTO.setSalary(employee.getSalary());
            employeeDTO.setId(employee.getId());
            return employeeDTO;
        }
        return null;
    }
}

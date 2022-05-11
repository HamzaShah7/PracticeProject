package com.example.practiceproject.services.impl;

import com.example.practiceproject.domain.Employee;
import com.example.practiceproject.repo.EmployeeRepo;
import com.example.practiceproject.services.inter.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public List<EmployeeDTO> ConvertEntityToDTO(List<Employee> employeeList){
       return employeeList.stream().map(employee -> EntitytoDTO(employee)).collect(Collectors.toList());
    }

    public EmployeeDTO EntitytoDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setDeptName(employee.getDepartment().getDeptName());
        employeeDTO.setEmpName(employee.getEmpName());
        employeeDTO.setId(employee.getId());
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> findAll() {
        return this.ConvertEntityToDTO(employeeRepo.findAll());
    }

    @Override
    public List<EmployeeDTO> findByDepartmentName(String dept) {
        var allEmployee = employeeRepo.getAllEmployee(dept);
        if(!allEmployee.isEmpty())
            return this.ConvertEntityToDTO(allEmployee);
        else
            return null;
    }
}
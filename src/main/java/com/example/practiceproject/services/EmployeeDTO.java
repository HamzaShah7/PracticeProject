package com.example.practiceproject.services;

import lombok.Data;

@Data
public class EmployeeDTO {
    private Integer id;
    private String empName;
    private Integer salary;
    private String deptName;
}

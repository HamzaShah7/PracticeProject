package com.example.practiceproject.services.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class EmployeeDTO {
    private Integer id;
    private String empName;
    private String deptName;
}
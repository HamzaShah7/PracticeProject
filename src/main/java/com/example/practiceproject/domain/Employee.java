package com.example.practiceproject.domain;

import com.example.practiceproject.repo.EmployeeRepo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Employee")
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "empName",nullable = false)
    private String empName;

    private Date joinDate;

    @ManyToOne
    private Department department;

    public Employee(){
    }

    public Employee(String empName, Date joinDate, Department department) {
        this.empName = empName;
        this.joinDate = joinDate;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
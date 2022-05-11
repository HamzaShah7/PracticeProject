package com.example.practiceproject.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Salary implements Serializable {

    @Id
    private Integer id;
    private Date CreatedDate;
    private Integer salary;

    @ManyToOne()
    private Employee employee;

    public Salary(){

    }

    public Salary(Integer id, Date createdDate, Integer salary, Employee employee) {
        this.id = id;
        CreatedDate = createdDate;
        this.salary = salary;
        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date createdDate) {
        CreatedDate = createdDate;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}

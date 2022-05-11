package com.example.practiceproject.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Leaves implements Serializable {

    @Id
    private Integer id;

    private Integer numberOfLeaves;
    private Date startDate;
    private Date endDate;


    @ManyToOne
    private Employee employee;

    public Leaves(Integer id, Integer numberOfLeaves, Date startDate, Date endDate, Employee employee) {
        this.id = id;
        this.numberOfLeaves = numberOfLeaves;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employee = employee;
    }

    public Leaves() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberOfLeaves() {
        return numberOfLeaves;
    }

    public void setNumberOfLeaves(Integer numberOfLeaves) {
        this.numberOfLeaves = numberOfLeaves;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }
}

package com.example.practiceproject.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class MedicalAllowance implements Serializable {

    @Id
    private Integer id;
    private Integer amount;

    @OneToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    public MedicalAllowance(){}

    public MedicalAllowance(Integer id, Integer amount, Employee employee) {
        this.id = id;
        this.amount = amount;
        this.employee = employee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
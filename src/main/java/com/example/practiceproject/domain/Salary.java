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

    @ManyToOne()
    private Employee employee;

    public Salary(){

    }

    public Salary(Integer id, Date createdDate) {
        this.id = id;
        CreatedDate = createdDate;
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
}

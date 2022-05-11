package com.example.practiceproject.repo;

import com.example.practiceproject.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee , Integer> {

    @Query(value = "select employee from Employee employee where employee.department.deptName = :deptName")
    List<Employee> getAllEmployee(@Param("deptName") String deptName);

}

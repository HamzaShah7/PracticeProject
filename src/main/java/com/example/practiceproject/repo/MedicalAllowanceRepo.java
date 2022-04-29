package com.example.practiceproject.repo;

import com.example.practiceproject.domain.MedicalAllowance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalAllowanceRepo extends JpaRepository<MedicalAllowance , Integer> {
}

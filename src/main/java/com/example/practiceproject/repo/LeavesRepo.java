package com.example.practiceproject.repo;

import com.example.practiceproject.domain.Leaves;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeavesRepo extends JpaRepository<Leaves , Integer> {
}

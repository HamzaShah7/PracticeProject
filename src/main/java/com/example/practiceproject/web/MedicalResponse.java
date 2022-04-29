package com.example.practiceproject.web;

import com.example.practiceproject.domain.Leaves;
import com.example.practiceproject.domain.MedicalAllowance;
import com.example.practiceproject.exceptions.UserNotFoundException;
import com.example.practiceproject.repo.LeavesRepo;
import com.example.practiceproject.repo.MedicalAllowanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

public class MedicalResponse 
{
    @Autowired
    private MedicalAllowanceRepo medicalAllowanceRepo;

    @GetMapping("/MedicalAllowance")
    public List<MedicalAllowance> retrieveAllLeaves(){
        return medicalAllowanceRepo.findAll();
    }

    @GetMapping("/MedicalAllowance/{id}")
    public Optional<MedicalAllowance> retrieveEmployee(@PathVariable int id){
        Optional<MedicalAllowance> med = medicalAllowanceRepo.findById(id);
        if (med.isEmpty()){
            throw new UserNotFoundException("id: "+id);
        }
        return med;
    }

    @DeleteMapping("/MedicalAllowance/{id}")
    public void deleteEmployee(@PathVariable int id){
        medicalAllowanceRepo.deleteById(id);
    }

    @PostMapping("/MedicalAllowance")
    public ResponseEntity<Object> createEmployee(@RequestBody MedicalAllowance med){
        MedicalAllowance medicalAllowance = medicalAllowanceRepo.save(med);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(medicalAllowance.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}

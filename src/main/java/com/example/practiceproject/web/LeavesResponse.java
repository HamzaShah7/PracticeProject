package com.example.practiceproject.web;

import com.example.practiceproject.domain.Leaves;
import com.example.practiceproject.exceptions.UserNotFoundException;
import com.example.practiceproject.repo.LeavesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class LeavesResponse {

    @Autowired
    private LeavesRepo leavesRepo;

    @GetMapping("/Leaves")
    public List<Leaves> retrieveAllLeaves(){
        return leavesRepo.findAll();
    }

    @GetMapping("/Leaves/{id}")
    public Optional<Leaves> retrieveEmployee(@PathVariable int id){
        Optional<Leaves> leave = leavesRepo.findById(id);
        if (leave.isEmpty()){
            throw new UserNotFoundException("id: "+id);
        }
        return leave;
    }

    @DeleteMapping("/Leaves/{id}")
    public void deleteEmployee(@PathVariable int id){
        leavesRepo.deleteById(id);
    }

    @PostMapping("/Leaves")
    public ResponseEntity<Object> createEmployee(@RequestBody Leaves lea){
        Leaves leave =leavesRepo.save(lea);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(leave.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}

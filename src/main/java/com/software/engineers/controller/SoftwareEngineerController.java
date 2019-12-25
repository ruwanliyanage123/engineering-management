package com.software.engineers.controller;

import com.software.engineers.exception.SoftwareEngineerNotFoundException;
import com.software.engineers.model.SoftwareEngineer;
import com.software.engineers.repository.SoftwareEngineerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "engineers")
public class SoftwareEngineerController {
    @Autowired
    SoftwareEngineerRepository softwareEngineerRepository;

    //to retrieve all software engineers
    @GetMapping("allengineers")
    public List<SoftwareEngineer> getAllEngineers(){
        return softwareEngineerRepository.findAll();
    }

    //to add a new engineer
    @PostMapping("/addengineer")
    public SoftwareEngineer addEngineer(@RequestBody SoftwareEngineer softwareEngineer){
        return softwareEngineerRepository.save(softwareEngineer);
    }

    //to retrieve one engineer
    @GetMapping("/oneengineer/{id}")
    public SoftwareEngineer getEngineer(@PathVariable int id){
        SoftwareEngineer softwareEngineer = softwareEngineerRepository.findById(id)
                .orElseThrow(()->new SoftwareEngineerNotFoundException(String.format("%s",id)));
        return softwareEngineer;
    }

    //to delete one engineer
    @DeleteMapping("/deleteengineer/{id}")
    public ResponseEntity<?> deleteEngineer(@PathVariable int id){
        SoftwareEngineer softwareEngineer = softwareEngineerRepository.findById(id)
                .orElseThrow(()->new SoftwareEngineerNotFoundException(String.format("%s",id)));
        softwareEngineerRepository.delete(softwareEngineer);
        return ResponseEntity.ok().build();
    }
}

package com.software.engineers.controller;

import com.software.engineers.model.SoftwareEngineer;
import com.software.engineers.repository.SoftwareEngineerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "engineers")
public class SoftwareEngineerController {
    @Autowired
    SoftwareEngineerRepository softwareEngineerRepository;

    //for retrieve all software engineers
    @GetMapping("allengineers")
    public List<SoftwareEngineer> getAllEngineers(){
        return softwareEngineerRepository.findAll();
    }
}

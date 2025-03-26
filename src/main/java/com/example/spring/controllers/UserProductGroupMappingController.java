package com.example.spring.controllers;

import com.example.spring.entities.UserProductGroupMapping;
import com.example.spring.service.UserProductGroupMappingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/group-mapping")
@AllArgsConstructor
public class UserProductGroupMappingController {

    @Autowired
    private UserProductGroupMappingService mappingService;

    // Save a new mapping
    @PostMapping
    public void save(@RequestBody UserProductGroupMapping mapping) {
        mappingService.insertIgnore(mapping);
    }
}


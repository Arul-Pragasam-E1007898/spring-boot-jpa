package com.example.spring.service;

import com.example.spring.entities.UserProductGroupMapping;
import com.example.spring.repository.UserProductGroupMappingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserProductGroupMappingService {

    @Autowired
    private UserProductGroupMappingRepository repository;

    public void upsert(UserProductGroupMapping mapping) {
        repository.upsert(mapping.getId(), mapping.getOrganisationId(), mapping.getAccountId(),
                mapping.getUserId(), mapping.getGroupId());
    }

    public void insertIgnore(UserProductGroupMapping mapping) {
        repository.insertIgnore(mapping.getId(), mapping.getOrganisationId(), mapping.getAccountId(),
                mapping.getUserId(), mapping.getGroupId());
    }
}


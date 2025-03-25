package com.example.spring.controllers;

import com.example.spring.entities.Audit;
import com.example.spring.entities.AuditRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class AuditService {

    @Autowired
    private AuditRepository auditRepository;

    @Transactional
    public void recordUpdate() {
        Audit update = Audit.builder().action("Update").time(LocalDateTime.now()).build();
        auditRepository.save(update);
    }
}


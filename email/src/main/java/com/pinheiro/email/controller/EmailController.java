package com.pinheiro.email.controller;

import com.pinheiro.email.models.EmailModel;
import com.pinheiro.email.services.EmailService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/emails")
public class EmailController {

    @Autowired
    private EmailService service;
    @GetMapping
    public ResponseEntity<List<EmailModel>> findAll(){
        List<EmailModel> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmailModel> findById(@PathVariable UUID id){
        EmailModel email = service.findById(id);
        return ResponseEntity.ok().body(email);
    }
}

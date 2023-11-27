package com.demo.atvPessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaaController {

    @Autowired
    private PessoaaService service;

    @PostMapping
    public ResponseEntity<Object> createPessoa(@RequestBody Pessoaa pessoaa) {
        return ResponseEntity.status(HttpStatus.OK).body(service.createPessoaa(pessoaa));
    }
}

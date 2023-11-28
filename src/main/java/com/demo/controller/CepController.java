package com.demo.controller;

import com.demo.dto.CepDto;
import com.demo.facede.CepFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
public class CepController {

    @Autowired
    private CepFacade cepFacade;
    @GetMapping("/{cep}")
    public CepDto buscadorCep(@PathVariable String cep) {
        return cepFacade.buscadorCep(cep);
    }
}

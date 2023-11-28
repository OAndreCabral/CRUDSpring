package com.demo.facede;

import com.demo.dto.CepDto;
import com.demo.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CepFacade {

    private CepService service;

    public CepDto buscadorCep(String cep){
        return service.obterCep(cep);
    }
}

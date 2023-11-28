package com.demo.service;

import com.demo.dto.CepDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( url = "https://viacep.com.br/ws/",name = "cep")
public interface CepService {
    @GetMapping("{cep}/json")
    CepDto obterCep(@PathVariable String cep);
}

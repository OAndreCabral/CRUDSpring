package com.demo.atvPessoa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaaService {

    @Autowired
    private PessoaaRepository repository;

    public Pessoaa createPessoaa(Pessoaa pessoaa) {
        return repository.save(pessoaa);
    }
}

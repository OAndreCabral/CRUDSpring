package com.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private Long id;
    private String cpf;
    private String sexo;
    private String nascimento;
    private List<Endereco> enderecos = new ArrayList<>();

    public Pessoa() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }
}

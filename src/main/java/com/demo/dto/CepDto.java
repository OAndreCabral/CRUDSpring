package com.demo.dto;

public record CepDto(
        String cep,
        String logradouro,
        String bairro,
        String localidade,
        String uf
) {}


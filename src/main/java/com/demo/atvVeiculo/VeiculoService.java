package com.demo.atvVeiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;

    public Veiculo gravarVeiculo(Veiculo veiculo){
        return repository.save(veiculo);
    }
    public List<Veiculo> buscarTudo(){
        return repository.findAll();
    }

    public Optional<Veiculo> buscarUm(Long id){
        return repository.findById(id);
    }

    public void deletarVeiculo(Optional<Veiculo> veiculo){
        repository.delete(veiculo.get());
    }
}

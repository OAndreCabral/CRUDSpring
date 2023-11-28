package com.demo.controller;

import com.demo.model.Pessoa;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    private final List<Pessoa> listaDePessoa = new ArrayList<>();
    private Pessoa pessoa;
    private Long id = Long.valueOf((1));

    @PostMapping()
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa1) {
        pessoa = new Pessoa();
        pessoa.setId(Long.valueOf(id++));
        pessoa.setCpf(pessoa1.getCpf());
        pessoa.setSexo(pessoa1.getSexo());
        pessoa.setNascimento(pessoa1.getNascimento());
        listaDePessoa.add(pessoa);

        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
    }
    @GetMapping("")
    public List<Pessoa> listarPessoas() {
        return listaDePessoa;
    }
    @GetMapping("/{cpf}")
    public ResponseEntity<Pessoa> consultarPorCPF(@PathVariable String cpf) {
        Optional<Pessoa> pessoaLocalizada = listaDePessoa.stream()
                .findFirst()
                .filter(pessoa1 -> pessoa1.getCpf().equals(cpf));

        return pessoaLocalizada
                .map(pessoa1 -> ResponseEntity.ok(pessoa1))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarPessoa(
            @PathVariable(value = "id") Long id,
            @RequestBody Pessoa pessoaAtualizada
    ){
        if (!listaDePessoa.isEmpty()) {
            for (Pessoa pessoa : listaDePessoa) {
                if (pessoa.getId().equals(id)){
                    pessoa.setCpf(pessoaAtualizada.getCpf());
                    pessoa.setSexo(pessoaAtualizada.getSexo());
                    pessoa.setNascimento(pessoaAtualizada.getNascimento());

                    return ResponseEntity.status(HttpStatus.OK).body(pessoa);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPessoa(
            @PathVariable(value = "id") Long id
    ){
        if (!listaDePessoa.isEmpty()) {
            for (Pessoa pessoa : listaDePessoa) {
                if (pessoa.getId().equals(id)) {
                    listaDePessoa.remove((pessoa));
                    return ResponseEntity.status(HttpStatus.OK).body("Deleted");
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
    }
}

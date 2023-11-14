package com.demo.controller;


import com.demo.model.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private final List<Produto> listaDeProduto = new ArrayList<>();
    private Produto produto;
    private Long codigo = Long.valueOf((1));

    @GetMapping("")
    public List<Produto> listDeProduto() {
        return listaDeProduto;
    }

    @GetMapping("/{idProduto}")
    public ResponseEntity<Object> idProduto(@PathVariable(value = "idProduto") Long id){

        if (!listaDeProduto.isEmpty()) {
            for (Produto produto : listaDeProduto) {
                if (produto.getCodigo() == id){
                    return ResponseEntity.status(HttpStatus.OK).body(produto);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
    }

    @PostMapping()
    public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto p1){

        produto = new Produto();
        produto.setCodigo(Long.valueOf(codigo++));
        produto.setDescricao(p1.getDescricao());
        produto.setValor(p1.getValor());
        listaDeProduto.add(produto);

        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarProduto(
            @PathVariable(value = "id") Long id,
            @RequestBody Produto produtoAtualizado
    ){
        if (!listaDeProduto.isEmpty()) {
            for (Produto produto : listaDeProduto) {
                if (produto.getCodigo() == id){
                    produto.setDescricao(produtoAtualizado.getDescricao());
                    produto.setValor(produtoAtualizado.getValor());

                    return ResponseEntity.status(HttpStatus.OK).body(produto);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto inexistente/não encontrado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarProduto(
            @PathVariable(value = "id") Long id
    ){
        if (!listaDeProduto.isEmpty()) {
            for (Produto produto : listaDeProduto) {
                if(produto.getCodigo() == id) {
                    listaDeProduto.remove(produto);
                    return ResponseEntity.status(HttpStatus.OK).body(produto);
                }
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
    }
}


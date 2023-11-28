package com.demo.atvVeiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @PostMapping
    public ResponseEntity<Object> gravarVeiculo(@RequestBody Veiculo veiculo) {
        return ResponseEntity.status(HttpStatus.OK).body(service.gravarVeiculo(veiculo));
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> buscarTudo() {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarTudo());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Veiculo>> buscarUm(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.buscarUm(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarVeiculo(
            @RequestBody Veiculo veiculo,
            @PathVariable(value = "id") Long id) {

        Optional<Veiculo> veic = service.buscarUm(id);

        if (veic.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não encontrado");

        }
        Veiculo veiculo1 = veic.get();
        veiculo1.setModelo(veiculo.getModelo());
        veiculo1.setMarca(veiculo.getMarca());
        veiculo1.setCor(veiculo.getCor());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body((service.gravarVeiculo(veiculo1)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarVeiculo(@PathVariable(value = "id") Long id){

        Optional<Veiculo> veic = service.buscarUm(id);

        if(veic.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Não encontrado");
        }
        service.deletarVeiculo(veic);

        return ResponseEntity.status(HttpStatus.OK).body("Veiculo Apagado!");
    }
}

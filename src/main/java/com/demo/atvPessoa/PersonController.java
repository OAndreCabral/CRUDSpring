package com.demo.atvPessoa;

import com.demo.atvVeiculo.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping
    public ResponseEntity<Object> createPessoa(@RequestBody Person person) {
        return ResponseEntity.status(HttpStatus.OK).body(service.createPerson(person));
    }
    @GetMapping
    public ResponseEntity<List<Person>> listAllPerson() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listAllPerson());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> listById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.listById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePerson(
            @RequestBody Person person,
            @PathVariable(value = "id") Long id) {

        Optional<Person> personTest = service.listById(id);

        if (personTest.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não encontrado >)");
        }
        Person person1 = personTest.get();
        person1.setNome(person.getNome());
        person1.setCPF(person.getCPF());
        person1.setSexo(person.getSexo());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.updatePerson(person1));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePerson(@PathVariable(value = "id") Long id){

        Optional<Person> personEncontrada = service.listById(id);

        if(personEncontrada.isEmpty()){
            return ResponseEntity.status(HttpStatus.OK).body("Não existe por enquanto ^^");
        }
        service.deletePerson(personEncontrada);

        return ResponseEntity.status(HttpStatus.OK).body("Person deletada!");
    }
}

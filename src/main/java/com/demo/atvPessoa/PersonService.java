package com.demo.atvPessoa;

import com.demo.atvVeiculo.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Person createPerson(Person person) {
        if (!person.getVeiculos().isEmpty()){
            for(Veiculo veiculo : person.getVeiculos()){
                veiculo.setPerson(person);
            }
        }
        return repository.save(person);
    }
    public List<Person> listAllPerson() {
        return repository.findAll();
    }
    public Optional<Person> listById(Long id) {
        return repository.findById(id);
    }
    public Person updatePerson(Person person) {
        return repository.save(person);
    }
    public void deletePerson(Optional<Person> person){
        repository.delete(person.get());
    }
}

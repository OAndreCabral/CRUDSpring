package com.demo.atvPessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaaRepository extends JpaRepository<Pessoaa, Long> {

}

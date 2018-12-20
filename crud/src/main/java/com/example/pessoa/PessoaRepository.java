package com.example.pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository 
	extends JpaRepository<Pessoa, Integer> {

}

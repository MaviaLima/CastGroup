package com.example.pessoa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repositorio;

	public <S extends Pessoa> S salvarPessoa(S entity) {
		return repositorio.save(entity);
	}

	public List<Pessoa> listarTodos() {
		return repositorio.findAll();
	}

	public void excluir(Integer id) {
		repositorio.deleteById(id);
	}

	public Pessoa buscarPorId(Integer id) {
		return repositorio.findById(id).orElse(null);
	}
	
	
}

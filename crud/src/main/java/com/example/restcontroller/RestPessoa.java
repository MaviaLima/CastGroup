package com.example.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.pessoa.Pessoa;
import com.example.pessoa.PessoaService;

@RestController
@RequestMapping("/rest/pessoas")
public class RestPessoa {

	@GetMapping("/id")
	public String pessoa() {
		return "Ola";
	}
	
	@Autowired
	private PessoaService service;
	
	@GetMapping("/")
	public ModelAndView listarPessoas() {
		ModelAndView mv = new ModelAndView("pessoa/pessoas-list");
		mv.addObject("lista", service.listarTodos());
		return mv;
	}
	
	
	
	@GetMapping("/{id}")
	public ModelAndView exibirEdicao(@PathVariable("id") int id) {
		Pessoa p = service.buscarPorId(id);
		ModelAndView mv = new ModelAndView("pessoa/pessoa-form");
		mv.addObject("pessoa", p);
		return mv;
	}
	
	@GetMapping("/salvar/{id}")
	public String salvarPessoa(@Valid @ModelAttribute Integer id, 
			Errors result) {
		Pessoa p = service.buscarPorId(id);
		if(result.hasErrors()) {
			return "pessoa/pessoa-form";
		}
		service.salvarPessoa(p);
		return "redirect:/pessoas/";
	}
	
//	@GetMapping("/salvar/{id}")
//	public void salvarPessoa(@PathVariable("id") int id) {
//		Pessoa p = service.buscarPorId(id);
//		service.salvarPessoa(p);	
//	}

	@GetMapping("/remover/{id}")
	public void remover(@PathVariable("id") int id) {
		service.excluir(id);
	}

	
}

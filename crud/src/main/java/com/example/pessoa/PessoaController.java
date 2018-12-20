package com.example.pessoa;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.pessoa.Pessoa;
import com.example.pessoa.PessoaService;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {
	
		@Autowired
		private PessoaService service;
		
		@GetMapping("/")
		public ModelAndView listarPessoas() {
			ModelAndView mv = new ModelAndView("pessoa/pessoas-list");
			mv.addObject("lista", service.listarTodos());
			return mv;
		}
		
		@GetMapping("/novo")
		public String exibirForm(@ModelAttribute Pessoa pessoa) {
			return "pessoa/pessoa-form";
		}
		
		@PostMapping("/salvar")
		public String salvarContato(@Valid @ModelAttribute Pessoa pessoa, 
				Errors result) {
			if(result.hasErrors()) {
				return "pessoa/pessoa-form";
			}
			service.salvarPessoa(pessoa);
			return "redirect:/pessoas/";
		}
		
		@GetMapping("/editar/{id}")
		public ModelAndView exibirEdicao(@PathVariable("id") int id) {
			Pessoa p = service.buscarPorId(id);
			ModelAndView mv = new ModelAndView("pessoa/pessoa-form");
			mv.addObject("pessoa", p);
			return mv;
		}

		@GetMapping("/remover/{id}")
		public ModelAndView remover(@PathVariable("id") int id) {
			service.excluir(id);
			return listarPessoas();
		}

	
}

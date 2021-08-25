package br.edu.infnet.bootaluno.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.bootaluno.modelo.Aluno;
import br.edu.infnet.bootaluno.modelo.Turma;
import br.edu.infnet.bootaluno.service.AlunoService;
import br.edu.infnet.bootaluno.service.TurmaService;

@Controller
@RequestMapping(value = "/aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private TurmaService turmaService;
	
	@RequestMapping(value = "/cadastro",  method = RequestMethod.GET)
	public String cadastro() {
		return "aluno/form";
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Aluno usuario) {
		
		//executar a ação de salvar
		alunoService.salvar(usuario);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listaAlunos(Model model) {
		List<Aluno> alunos =  alunoService.listAll();
		model.addAttribute("alunos", alunos);
		return "aluno/index";
	}
	
	
	@RequestMapping(value = "/formedit/{codigo}", method = RequestMethod.GET)
	public String formEdit(@PathVariable("codigo") Integer codigo, Model model) {
		Optional<Aluno> byId = alunoService.getById(codigo);
		if(byId.isPresent()) {
			model.addAttribute("aluno", byId.get());
		}
		return "aluno/edit";
	}
	
	
	@RequestMapping(value = "/inscricao/{codigo}", method = RequestMethod.GET)
	public String inscricao(@PathVariable("codigo") Integer codigo, Model model) {
		Optional<Aluno> byId = alunoService.getById(codigo);
		if(byId.isPresent()) {
			model.addAttribute("aluno", byId.get());
		}
		
		
		List<Turma> turmas = turmaService.listAll();
		model.addAttribute("turmas", turmas);
		
		return "aluno/inscricao";
	}
	
	
	
	
}

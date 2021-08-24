package br.edu.infnet.bootaluno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.bootaluno.modelo.Turma;
import br.edu.infnet.bootaluno.service.TurmaService;

@Controller
@RequestMapping(value = "/turma")
public class TurmaController {

	@Autowired
	private TurmaService turmaService;
	
	@RequestMapping(value = "/cadastro",  method = RequestMethod.GET)
	public String cadastro() {
		return "turma/form";
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Turma turma) {
		turmaService.salvar(turma);
		return "redirect:/turma/lista";
	}
	
	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public String listaAlunos(Model model) {
		List<Turma> turmas =  turmaService.listAll();
		model.addAttribute("turmas", turmas);
		return "turma/index";
	}
	
	
}

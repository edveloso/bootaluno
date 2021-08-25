package br.edu.infnet.bootaluno.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
		
		//executar a ação de salvar
		turmaService.salvar(turma);
		
		return "redirect:/turma/";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listaTurmas(Model model) {
		List<Turma> turmas =  turmaService.listAll();
		model.addAttribute("turmas", turmas);
		return "turma/index";
	}
	
	
	@RequestMapping(value = "/formedit/{codigo}", method = RequestMethod.GET)
	public String formEdit(@PathVariable("codigo") Integer codigo, Model model) {
		Optional<Turma> byId = turmaService.getById(codigo);
		if(byId.isPresent()) {
			model.addAttribute("turma", byId.get());
		}
		return "turma/edit";
	}
	

	@RequestMapping(value = "/delete/{codigo}", method = RequestMethod.GET)
	public String delete(@PathVariable("codigo") Integer codigo) {
		turmaService.delete(codigo);
		return "redirect:/turma/";
	}
	
	
	
	
}

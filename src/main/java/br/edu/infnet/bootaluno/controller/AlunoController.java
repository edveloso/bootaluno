package br.edu.infnet.bootaluno.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.infnet.bootaluno.modelo.Aluno;
import br.edu.infnet.bootaluno.service.AlunoService;

@Controller
@RequestMapping(value = "/aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	
	
	@RequestMapping(value = "/cadastro",  method = RequestMethod.GET)
	public String cadastro() {
		return "aluno/form";
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Aluno usuario) {
		
		//executar a ação de salvar
		alunoService.salvar(usuario);
		
		return "redirect:/aluno/";
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
	

	@RequestMapping(value = "/delete/{codigo}", method = RequestMethod.GET)
	public String delete(@PathVariable("codigo") Integer codigo) {
		alunoService.delete(codigo);
		return "redirect:/aluno/";
	}
	
	
	
	
}

package br.edu.infnet.bootaluno.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.bootaluno.modelo.Aluno;
import br.edu.infnet.bootaluno.service.AlunoService;

@RestController
@RequestMapping("/api/alunos")
public class AlunoResource {

	/*
	 * GET, POST, PUT, DELETE 
	 * get retorna 1 ou retorna uma lista (paginada ou não)
	 * post inclusão
	 * put  alteração
	 * delete exclusão
	 * 
	 * CRUD
	 */
	
	private AlunoService alunoService;
	
	public AlunoResource(AlunoService alunoService) {
		this.alunoService = alunoService;
	}
	
	@GetMapping
	public List<Aluno> listAll() {
		return alunoService.listAll();
	}

	@GetMapping("/{id}")
	public Aluno getAlunoById(@PathVariable  Integer id) {
		Optional<Aluno> alunoByID = alunoService.getById(id);
		return alunoByID.get();
	}
	  
	
	@DeleteMapping("/{id}")
	public Aluno deleteAlunoById(@PathVariable  Integer id) {
		alunoService.delete(id);
		return null;
	}
	
	
	
	
}

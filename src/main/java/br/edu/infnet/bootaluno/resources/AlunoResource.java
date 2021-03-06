package br.edu.infnet.bootaluno.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	public ResponseEntity<List<Aluno>> listAll() {
		return ResponseEntity.ok(alunoService.listAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Aluno> getAlunoById(@PathVariable  Integer id) {
		Optional<Aluno> alunoByID = alunoService.getById(id);
		if(!alunoByID.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(alunoByID.get());
	}
	  
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAlunoById(@PathVariable  Integer id) {
		alunoService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<?> createAluno(@RequestBody Aluno aluno){
		Aluno alunoDB = alunoService.salvar(aluno);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(alunoDB.getCodigo()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	
	
}

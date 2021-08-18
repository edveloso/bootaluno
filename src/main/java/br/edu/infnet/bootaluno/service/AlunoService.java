package br.edu.infnet.bootaluno.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.bootaluno.modelo.Aluno;
import br.edu.infnet.bootaluno.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	public void salvar(Aluno aluno) {
		//aplicar as regras de negócio
		alunoRepository.save(aluno);
	}

}

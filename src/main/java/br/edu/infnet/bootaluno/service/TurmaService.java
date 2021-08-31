package br.edu.infnet.bootaluno.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.bootaluno.modelo.Turma;
import br.edu.infnet.bootaluno.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;
	
	public void salvar(Turma turma) {
		turmaRepository.save(turma);
	}

	public List<Turma> listAll() {
		return turmaRepository.findAll();
	}

	public List<Turma> listByAlunoID(Integer codigo) {
		return turmaRepository.listTurmaByAlunoID(codigo);
	}
	
	public Optional<Turma> getById(Integer codigo) {
		return turmaRepository.findById(codigo);
	}

	public void delete(Integer codigo) {
		turmaRepository.deleteById(codigo);
	}

}

package br.edu.infnet.bootaluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.bootaluno.modelo.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}

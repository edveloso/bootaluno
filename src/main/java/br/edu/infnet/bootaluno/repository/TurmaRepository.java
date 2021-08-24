package br.edu.infnet.bootaluno.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.bootaluno.modelo.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

}

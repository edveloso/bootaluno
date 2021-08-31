package br.edu.infnet.bootaluno.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.infnet.bootaluno.modelo.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

	
	@Query(value = " select * from turma x where codigo not in(select t.codigo from turma t, aluno_turma at, aluno a where t.codigo = at.turma_id and a.codigo = at.aluno_id and a.codigo =  (:codigo) )  ",  nativeQuery=true)
	List<Turma> listTurmaByAlunoID(@Param("codigo")  Integer codigo);
	
}

package br.edu.infnet.bootaluno.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Aluno {

	@Id @GeneratedValue
	private Integer codigo;
	
	private String nome;
	private String email; 
	
	
	@ManyToMany
	@JoinTable(
			name = "aluno_turma",
			joinColumns = @JoinColumn(name = "aluno_id"),
			inverseJoinColumns = @JoinColumn(name="turma_id")
				)
	private List<Turma> turmas;

	public Aluno() {
	}
	
	public Aluno(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
	
}

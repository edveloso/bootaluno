package br.edu.infnet.bootaluno.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Aluno {

	@Id @GeneratedValue
	private Integer codigo;
	
	private String nome;
	private String email; 

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
	
}

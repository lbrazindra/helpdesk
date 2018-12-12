package br.com.helpdesk.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DepartamentoChamado {

	@Id
	@GeneratedValue
	private int idDepartamentoChamado;
	private String nomeDepartamento;

	public int getIdDepartamentoChamado() {
		return idDepartamentoChamado;
	}

	public void setIdDepartamentoChamado(int idDepartamentoChamado) {
		this.idDepartamentoChamado = idDepartamentoChamado;
	}

	public String getNomeDepartamento() {
		return nomeDepartamento;
	}

	public void setNomeDepartamento(String nomeDepartamento) {
		this.nomeDepartamento = nomeDepartamento;
	}

}

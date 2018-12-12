package br.com.helpdesk.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Status {

	@Id
	@GeneratedValue
	private int idStatus;
	private String nomeStatus;
	private String descricaoStatus;

	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public String getNomeStatus() {
		return nomeStatus;
	}

	public void setNomeStatus(String nomeStatus) {
		this.nomeStatus = nomeStatus;
	}

	public String getDescricaoStatus() {
		return descricaoStatus;
	}

	public void setDescricaoStatus(String descricaoStatus) {
		this.descricaoStatus = descricaoStatus;
	}

}

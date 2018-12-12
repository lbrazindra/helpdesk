package br.com.helpdesk.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Chamado {

	@Id
	@GeneratedValue
	private int idChamado;
	private String descricao;
	private String tituloChamado;
	@OneToOne
	private Status status;
	@OneToOne
	private DepartamentoChamado departamentoChamado;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataAbertura = Calendar.getInstance();
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataFechamento;
	private Integer idUsuarioClienteChamado;
	private Integer idUsuarioAdmChamado;
	private String nomeUsuarioAdmChamado;

	public Integer getIdUsuarioClienteChamado() {
		return idUsuarioClienteChamado;
	}

	public void setIdUsuarioClienteChamado(Integer idUsuarioClienteChamado) {
		this.idUsuarioClienteChamado = idUsuarioClienteChamado;
	}

	public Integer getIdUsuarioAdmChamado() {
		return idUsuarioAdmChamado;
	}

	public void setIdUsuarioAdmChamado(Integer idUsuarioAdmChamado) {
		this.idUsuarioAdmChamado = idUsuarioAdmChamado;
	}

	public int getIdChamado() {
		return idChamado;
	}

	public void setIdChamado(int idChamado) {
		this.idChamado = idChamado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTituloChamado() {
		return tituloChamado;
	}

	public void setTituloChamado(String tituloChamado) {
		this.tituloChamado = tituloChamado;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Calendar getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Calendar dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public DepartamentoChamado getDepartamentoChamado() {
		return departamentoChamado;
	}

	public void setDepartamentoChamado(DepartamentoChamado departamentoChamado) {
		this.departamentoChamado = departamentoChamado;
	}

	public String getNomeUsuarioAdmChamado() {
		return nomeUsuarioAdmChamado;
	}

	public void setNomeUsuarioAdmChamado(String nomeUsuarioAdmChamado) {
		this.nomeUsuarioAdmChamado = nomeUsuarioAdmChamado;
	}
	

}
package br.com.helpdesk.modelo;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.primefaces.event.timeline.TimelineSelectEvent;

public class ModeloRelatorios {
	private int idChamado;
	private String descricao;
	private int idUsuarioAdmChamado;
	private int idUsuarioClienteChamado;
	private String tituloChamado;
	private int departamentoChamado_idDepartamentoChamado;
	private int status_idStatus;
	private int idUsuario;
	private String email;
	private int idUsuarioLogado;
	private String login;
	private String nome;
	private String senha;
	private int telefone;
	private Boolean usuarioAdm;
	private int idStatus;
	private String descricaoStatus;
	private String nomeStatus;
	private int idDepartamentoChamado;
	private String nomeDepartamento;
	private String nomeUsuarioAdmChamado;
	private Timestamp dataAbertura;
	private Timestamp dataFechamento;
	private String nomeAdm;
	private String emailAdm;
	private int telefoneAdm;

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

	public int getIdUsuarioAdmChamado() {
		return idUsuarioAdmChamado;
	}

	public void setIdUsuarioAdmChamado(int idUsuarioAdmChamado) {
		this.idUsuarioAdmChamado = idUsuarioAdmChamado;
	}

	public int getIdUsuarioClienteChamado() {
		return idUsuarioClienteChamado;
	}

	public void setIdUsuarioClienteChamado(int idUsuarioClienteChamado) {
		this.idUsuarioClienteChamado = idUsuarioClienteChamado;
	}

	public String getTituloChamado() {
		return tituloChamado;
	}

	public void setTituloChamado(String tituloChamado) {
		this.tituloChamado = tituloChamado;
	}

	public int getDepartamentoChamado_idDepartamentoChamado() {
		return departamentoChamado_idDepartamentoChamado;
	}

	public void setDepartamentoChamado_idDepartamentoChamado(int departamentoChamado_idDepartamentoChamado) {
		this.departamentoChamado_idDepartamentoChamado = departamentoChamado_idDepartamentoChamado;
	}

	public int getStatus_idStatus() {
		return status_idStatus;
	}

	public void setStatus_idStatus(int status_idStatus) {
		this.status_idStatus = status_idStatus;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdUsuarioLogado() {
		return idUsuarioLogado;
	}

	public void setIdUsuarioLogado(int idUsuarioLogado) {
		this.idUsuarioLogado = idUsuarioLogado;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public Boolean getUsuarioAdm() {
		return usuarioAdm;
	}

	public void setUsuarioAdm(Boolean usuarioAdm) {
		this.usuarioAdm = usuarioAdm;
	}

	public int getIdStatus() {
		return idStatus;
	}

	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}

	public String getDescricaoStatus() {
		return descricaoStatus;
	}

	public void setDescricaoStatus(String descricaoStatus) {
		this.descricaoStatus = descricaoStatus;
	}

	public String getNomeStatus() {
		return nomeStatus;
	}

	public void setNomeStatus(String nomeStatus) {
		this.nomeStatus = nomeStatus;
	}

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

	public String getNomeUsuarioAdmChamado() {
		return nomeUsuarioAdmChamado;
	}

	public void setNomeUsuarioAdmChamado(String nomeUsuarioAdmChamado) {
		this.nomeUsuarioAdmChamado = nomeUsuarioAdmChamado;
	}

	public String getNomeAdm() {
		return nomeAdm;
	}

	public void setNomeAdm(String nomeAdm) {
		this.nomeAdm = nomeAdm;
	}

	public String getEmailAdm() {
		return emailAdm;
	}

	public void setEmailAdm(String emailAdm) {
		this.emailAdm = emailAdm;
	}

	public int getTelefoneAdm() {
		return telefoneAdm;
	}

	public void setTelefoneAdm(int telefoneAdm) {
		this.telefoneAdm = telefoneAdm;
	}

	public Timestamp getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Timestamp dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Timestamp getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Timestamp dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

}

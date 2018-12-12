package br.com.helpdesk.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.hql.internal.ast.tree.BooleanLiteralNode;

@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private int idUsuario;
	private String nome;

	private int telefone;
	private String email;
	private String login;
	private String senha;
	private Boolean usuarioAdm;
	private Integer idUsuarioLogado;
	
	public Integer getIdUsuarioLogado() {
		return idUsuarioLogado;
	}

	public void setIdUsuarioLogado(Integer idUsuarioLogado) {
		this.idUsuarioLogado = idUsuarioLogado;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Boolean getUsuarioAdm() {
		return usuarioAdm;
	}

	public void setUsuarioAdm(Boolean usuarioAdm) {
		this.usuarioAdm = usuarioAdm;
	}

}

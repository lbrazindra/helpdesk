package br.com.helpdesk.dao;

import javax.persistence.EntityManager;

import br.com.helpdesk.modelo.DepartamentoChamado;
import br.com.helpdesk.modelo.Status;
import br.com.helpdesk.modelo.Usuario;

public class PopulaBanco {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		// Insere status
		Status aberto = geraStatus("Chamado criado recentemente.", "Em aberto");
		em.persist(aberto);
		Status atendimento = geraStatus("Chamado em atendimento.", "Em atendimento");
		em.persist(atendimento);
		Status retornado = geraStatus("Chamado retornado ao solicitante.", "Retornado ao cliente");
		em.persist(retornado);
		Status finalizado = geraStatus("Chamado criado finalizado pelo.", "Finalizado");
		em.persist(finalizado);
		Status fechado = geraStatus("Chamado fechado pelo ADM.", "Fechado");
		em.persist(fechado);

		// Insere usuários
		Usuario usuario1 = geraUsuario("loginAdm", "senhaAdm", "nomeAdm", true, 1234);
		em.persist(usuario1);
		Usuario usuario2 = geraUsuario("loginComum", "senhaComum", "nomeComum", false, 12345678);
		em.persist(usuario2);
		Usuario usuario3 = geraUsuario("loginAdm2", "senhaAdm2", "nomeAdm2", true, 4321);
		em.persist(usuario3);
		Usuario usuario4 = geraUsuario("loginComum2", "senhaComum2", "nomeComum2", false, 87654321);
		em.persist(usuario4);

		// Insere Departamento
		DepartamentoChamado departamentoChamado1 = geraDepartamentoChamado("Diretoria");
		em.persist(departamentoChamado1);
		DepartamentoChamado departamentoChamado2 = geraDepartamentoChamado("RH");
		em.persist(departamentoChamado2);
		DepartamentoChamado departamentoChamado3 = geraDepartamentoChamado("Desenvolvimento");
		em.persist(departamentoChamado3);
		DepartamentoChamado departamentoChamado4 = geraDepartamentoChamado("Gerencia");
		em.persist(departamentoChamado4);
		DepartamentoChamado departamentoChamado5 = geraDepartamentoChamado("Outros");
		em.persist(departamentoChamado5);

		// Commita os dados e fecha a conexao
		em.getTransaction().commit();
		em.close();
	}

	private static Status geraStatus(String descricaoStatus, String nomeStatus) {
		Status status = new Status();
		status.setDescricaoStatus(descricaoStatus);
		status.setNomeStatus(nomeStatus);
		return status;
	}

	private static Usuario geraUsuario(String login, String senha, String nome, Boolean usuarioAdm, int telefone) {
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		usuario.setTelefone(telefone);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		usuario.setUsuarioAdm(usuarioAdm);
		return usuario;
	}

	private static DepartamentoChamado geraDepartamentoChamado(String nomeDepartamento) {
		DepartamentoChamado departamentoChamado = new DepartamentoChamado();
		departamentoChamado.setNomeDepartamento(nomeDepartamento);
		return departamentoChamado;
	}
}

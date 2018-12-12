package br.com.helpdesk.dao;

import javax.persistence.EntityManager;

import br.com.helpdesk.modelo.Chamado;
import br.com.helpdesk.modelo.DepartamentoChamado;
import br.com.helpdesk.modelo.Status;

public class PopulaBancoChamados {

	public static void main(String[] args) {

		EntityManager em = new JPAUtil().getEntityManager();

		em.getTransaction().begin();

		// Gera chamados
		Chamado chamado = geraChamado("primeiroChamadoDescricaoprimeiroChamadoDescricao", "primeiroTitulo", 1, 1);
		chamado.setIdUsuarioClienteChamado(2);
		em.persist(chamado);
		Chamado chamado2 = geraChamado("segundoChamadoDescricaosegundoChamadoDescricao", "segundoTitulo", 2, 2);
		chamado2.setIdUsuarioAdmChamado(1);
		chamado2.setNomeUsuarioAdmChamado("nomeAdnm");
		chamado2.setIdUsuarioClienteChamado(2);
		em.persist(chamado2);
		Chamado chamado3 = geraChamado("terceiroChamadoDescricaoterceiroChamadoDescricao", "terceiroTitulo", 3, 3);
		chamado3.setIdUsuarioAdmChamado(1);
		chamado3.setNomeUsuarioAdmChamado("nomeAdm");
		chamado3.setIdUsuarioClienteChamado(2);
		em.persist(chamado3);
		Chamado chamado4 = geraChamado("quartoChamadoDescricaoquartoChamadoDescricao", "quartoTitulo", 4, 4);
		chamado4.setIdUsuarioAdmChamado(2);
		chamado4.setNomeUsuarioAdmChamado("nomeAdm2");
		chamado4.setIdUsuarioClienteChamado(2);
		em.persist(chamado4);
		Chamado chamado5 = geraChamado("quintoChamadoDescricaoquintoChamadoDescricao", "quintoTitulo", 5, 5);
		chamado5.setIdUsuarioAdmChamado(2);
		chamado5.setNomeUsuarioAdmChamado("nomeAdm2");
		chamado5.setIdUsuarioClienteChamado(2);
		em.persist(chamado5);
		Chamado chamado6 = geraChamado("sextoChamadoDescricaosextoChamadoDescricao", "sextoTitulo", 1, 1);
		chamado6 .setIdUsuarioClienteChamado(2);
		em.persist(chamado6 );
		Chamado chamado7 = geraChamado("setimoChamadoDescricaosetimoChamadoDescricao", "setimoTitulo", 2, 1);
		chamado7.setIdUsuarioClienteChamado(4);
		em.persist(chamado7);
		

		// Commita os dados e fecha a conexao
		em.getTransaction().commit();
		em.close();
	}

	private static Chamado geraChamado(String descricao, String tituloChamado, Integer departamentoChamado,
			Integer status) {
		Chamado chamado = new Chamado();
		chamado.setDepartamentoChamado(new DAO<DepartamentoChamado>(DepartamentoChamado.class).buscaPorId(departamentoChamado));
		chamado.setStatus(new DAO<Status>(Status.class).buscaPorId(status));
		chamado.setDescricao(descricao);
		chamado.setTituloChamado(tituloChamado);
		return chamado;
	}

}

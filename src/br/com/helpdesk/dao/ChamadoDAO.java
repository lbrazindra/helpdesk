package br.com.helpdesk.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.helpdesk.modelo.Chamado;
import br.com.helpdesk.modelo.Usuario;

public class ChamadoDAO {
	Usuario usuario = new Usuario();

	public List<Chamado> listaTodosPorId(String idUsuario, String booleano) {
		EntityManager em = new JPAUtil().getEntityManager();
		Integer idUsuario2 = Integer.parseInt(idUsuario);
		Boolean booleano2 = Boolean.valueOf(booleano);
		List<Chamado> lista = null;
//		Acho que essa está errada. confirmar com o Renan
//		TypedQuery<Chamado> query2 = em.createQuery(
//				"from Chamado where idUsuarioAdmChamado = :arg1 or status_idStatus = 1 and status_idStatus != 5 order by STATUS_IDSTATUS",
//				Chamado.class);
		if (booleano2) {
			TypedQuery<Chamado> query2 = em.createQuery(
					"from Chamado where (idUsuarioAdmChamado = :arg1 or idUsuarioAdmChamado is null) and status_idStatus != 5 order by STATUS_IDSTATUS", Chamado.class);
			query2.setParameter("arg1", idUsuario2);
			List<Chamado> lista2 = query2.getResultList();
			em.close();
			return lista2;
		}
		if (booleano2 == false) {
			TypedQuery<Chamado> query2 = em.createQuery(
					"from Chamado where idUsuarioClienteChamado = :arg1 and status_idStatus != 5 order by STATUS_IDSTATUS", Chamado.class);
			query2.setParameter("arg1", idUsuario2);
			List<Chamado> lista3 = query2.getResultList();
			em.close();
			return lista3;
		}
		return lista;
	}

	public List<Chamado> listaTodosPorUsuarioADM() {
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Chamado> query2 = em.createQuery(
				"from Chamado c inner join fetch c.idUsuarioAdmChamado as p", Chamado.class);
//		from DetalhesProduto d inner join fetch d.produto as p

		List<Chamado> lista3 = query2.getResultList();
		em.close();
		return lista3;
	}
}

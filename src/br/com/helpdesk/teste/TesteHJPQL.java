package br.com.helpdesk.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.helpdesk.dao.JPAUtil;
import br.com.helpdesk.modelo.Usuario;

public class TesteHJPQL {

	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();

		String jpql = "select u from Usuario u where idUsuario = 1";
		Query query = em.createQuery(jpql);
	
		List<Usuario> resultados = query.getResultList();
		
		for (Usuario usuario : resultados) {
			System.out.println("Login" + usuario.getLogin());
			System.out.println("Nome" + usuario.getNome());
			
		}
		
		em.getTransaction().commit();
		em.close();
	}

}

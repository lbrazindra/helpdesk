package br.com.helpdesk.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.helpdesk.modelo.Usuario;

public class UsuarioDAO {

	public boolean existe(Usuario usuario) {
		EntityManager em = new JPAUtil().getEntityManager();
		TypedQuery<Usuario> query = em.createQuery(
				"select u from Usuario u where u.login = :pLogin and u.senha = :pSenha", Usuario.class);
		
		query.setParameter("pLogin", usuario.getLogin());
		query.setParameter("pSenha", usuario.getSenha());
		try {
			Usuario resultado = query.getSingleResult();	
		} catch(NoResultException ex) {
			return false;
		}
		
		em.close();

		return true;
	}

}

package br.com.helpdesk.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.helpdesk.dao.DAO;
import br.com.helpdesk.dao.UsuarioDAO;
import br.com.helpdesk.modelo.Usuario;

@ManagedBean
@ViewScoped
public class LoginBean {
	private Usuario usuario = new Usuario();
	private Usuario usuarioLogado;
	
	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public String efetuarLogin() {
		System.out.println("Fazendo login " + this.usuario.getLogin());
		FacesContext context = FacesContext.getCurrentInstance();

		boolean existe = new UsuarioDAO().existe(this.usuario);
		String usuarioAtivo = this.usuario.getLogin();
		if(existe) {
			this.usuario = new DAO<Usuario>(Usuario.class).buscaPorLogin(usuarioAtivo.toString());
		}
		
		if (existe) {
			context.getExternalContext().getSessionMap().put("usuarioLogado", this.usuario);
			
			return "chamado?Faces-redirect=true";
		}
		
		context.addMessage(null, new FacesMessage("Usuário não encontra, se não possuir peça para a central te cadastrar."));
		context.getExternalContext().getFlash().setKeepMessages(true);

		return "login?faces-redirect=true";
	}
	public String deslogar() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap().remove("usuarioLogado");

		return "login?faces-redirect=true";
	}

}

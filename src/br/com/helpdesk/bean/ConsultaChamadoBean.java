package br.com.helpdesk.bean;

import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.helpdesk.dao.ChamadoDAO;
import br.com.helpdesk.dao.DAO;
import br.com.helpdesk.modelo.Chamado;
import br.com.helpdesk.modelo.DepartamentoChamado;
import br.com.helpdesk.modelo.Status;
import br.com.helpdesk.modelo.Usuario;

@ManagedBean
@ViewScoped
public class ConsultaChamadoBean {
	private Chamado chamado = new Chamado();
	private Integer departamentoId;
	private Integer statusId;
	private Usuario usuario;
	private Usuario usuarioAtivo;
	private Usuario usuarioLogadoParaExibir;
	private Usuario usuarioLogadoParaExibir2;

	private List<DepartamentoChamado> departamentoChamado = new DAO<DepartamentoChamado>(DepartamentoChamado.class)
			.listaTodos();
	private List<Status> status = new DAO<Status>(Status.class).listaTodos();

	public ConsultaChamadoBean() {
		this.usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.get("usuarioLogado");
		String booleano = this.usuario.getUsuarioAdm().toString();
		String idUsuariologado = String.valueOf(this.usuario.getIdUsuario());
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("idNovoUsuario", idUsuariologado);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("booleanoNovoUsuario", booleano);
		if (FacesContext.getCurrentInstance().getExternalContext().getFlash().get("chamadoSelecionado") != null) {
			String teste = FacesContext.getCurrentInstance().getExternalContext().getFlash().get("chamadoSelecionado")
					.toString();
			Integer chamadoSelecionado = Integer.valueOf(teste);
			Chamado chamadoTeste = new DAO<Chamado>(Chamado.class).buscaPorId(chamadoSelecionado);
			this.chamado = chamadoTeste;
			getUsuario();
		}
	}

	public void gravar(String id) {
		if (this.chamado.getDepartamentoChamado() == null) {
			FacesContext.getCurrentInstance().addMessage("",
					new FacesMessage(FacesMessage.SEVERITY_ERROR,"Aciona o botão Gravar Departamento para depois Gravar o Chamado.", "messages"));
			return;
		}
		System.out.println("Gravando livro " + this.chamado.getTituloChamado());
		chamado.setStatus(new DAO<Status>(Status.class).buscaPorId(1));
		this.chamado.setIdUsuarioClienteChamado(Integer.parseInt(id));
		new DAO<Chamado>(Chamado.class).adiciona(this.chamado);
		FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage("Chamado salvo com sucesso."));

	}

	public void gravarDepartamento() {
		DepartamentoChamado dptoChamado = new DAO<DepartamentoChamado>(DepartamentoChamado.class)
				.buscaPorId(this.departamentoId);
		this.chamado.setDepartamentoChamado(dptoChamado);
		System.out.println("Novo departamento atualizado: " + chamado.getDepartamentoChamado());
		FacesContext.getCurrentInstance().addMessage("messages",
				new FacesMessage("Departamento adicionado com sucesso."));
	}

	public String abrirChamado(Integer idDoChamado) {
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("chamadoSelecionado", idDoChamado);
		return "chamado?faces-redirect=true";
	}

	public String consultarChamados(String idUsuariologado, String booleano) {
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("idUsuariologado", idUsuariologado);
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("booleano", booleano);
		return "consultaChamado?faces-redirect=true";
	}

	public List<Chamado> getChamados() {
		String idUsuariologado = (String) FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.get("idUsuariologado");
		if (idUsuariologado != null) {
			String booleano = (String) FacesContext.getCurrentInstance().getExternalContext().getFlash()
					.get("booleano");
			List<Chamado> chamadoLocal = new ChamadoDAO().listaTodosPorId(idUsuariologado, booleano);
			return chamadoLocal;
		} else {
			String id = (String) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("idNovoUsuario");
			String b = (String) FacesContext.getCurrentInstance().getExternalContext().getFlash()
					.get("booleanoNovoUsuario");
			List<Chamado> chamadoLocal = new ChamadoDAO().listaTodosPorId(id, b);
			return chamadoLocal;
		}
	}

	public Chamado getChamado() {
		return chamado;
	}

	public String relatorios() {
		return "relatorios?faces-redirect=true";
	}

	public String abrirRelatorios() {
		return "relatorios?faces-redirect=true";
	}

	public String novoChamado() {
		return "chamado?faces-redirect=true";
	}

	public List<DepartamentoChamado> getDepartamentoChamado() {
		return departamentoChamado;
	}

	public void setDepartamentoChamado(List<DepartamentoChamado> departamentoChamado) {
		this.departamentoChamado = departamentoChamado;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public Integer getDepartamentoId() {
		return departamentoId;
	}

	public void setDepartamentoId(Integer departamentoId) {
		this.departamentoId = departamentoId;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Usuario getUsuarioAtivo() {
		String teste = FacesContext.getCurrentInstance().getExternalContext().getFlash().get("chamadoSelecionado")
				.toString();
		this.usuario = new DAO<Usuario>(Usuario.class).buscaPorLogin(teste);
		return usuarioAtivo;
	}

	public void atualizar() {
		System.out.println("Atualizando livro " + this.chamado.getTituloChamado());
		new DAO<Chamado>(Chamado.class).atualiza(this.chamado);
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Chamado atualizado com sucesso."));
	}

	public void atuar(String id, String nome) {
		chamado.setStatus(new DAO<Status>(Status.class).buscaPorId(2));
		this.chamado.setIdUsuarioAdmChamado(Integer.valueOf(id));
		this.chamado.setNomeUsuarioAdmChamado(nome);
		new DAO<Chamado>(Chamado.class).atualiza(this.chamado);
		FacesContext.getCurrentInstance().addMessage("",
				new FacesMessage("Usuário ADM atuando no chamado com sucesso."));
	}

	public void reabrir() {
		chamado.setStatus(new DAO<Status>(Status.class).buscaPorId(1));
		new DAO<Chamado>(Chamado.class).atualiza(this.chamado);
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Chamado reaberto com sucesso."));
	}

	public void retornarAoCliente() {
		chamado.setStatus(new DAO<Status>(Status.class).buscaPorId(3));
		new DAO<Chamado>(Chamado.class).atualiza(this.chamado);
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Chamado retornado ao cliente com sucesso."));
	}

	public void finalizarChamado() {
		chamado.setStatus(new DAO<Status>(Status.class).buscaPorId(4));
		new DAO<Chamado>(Chamado.class).atualiza(this.chamado);
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Chamado finalizado com sucesso."));
	}

	public void fechar() {
		chamado.setStatus(new DAO<Status>(Status.class).buscaPorId(5));
		this.chamado.setDataFechamento(Calendar.getInstance());
		new DAO<Chamado>(Chamado.class).atualiza(this.chamado);
		FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Chamado fechado com sucesso."));
	}

	public List<Status> getStatus() {
		return status;
	}

	public Usuario getUsuarioLogadoParaExibir() {
		if (this.chamado.getIdUsuarioClienteChamado() != null) {
			this.usuarioLogadoParaExibir = new DAO<Usuario>(Usuario.class)
					.buscaPorId(this.chamado.getIdUsuarioClienteChamado());
			return usuarioLogadoParaExibir;
		} else {
			Usuario usuario2 = new Usuario();
			return usuario2;
		}

	}

	public void setUsuarioLogadoParaExibir(Usuario usuarioLogadoParaExibir) {
		this.usuarioLogadoParaExibir = usuarioLogadoParaExibir;
	}

	public Usuario getUsuarioLogadoParaExibir2() {
		if (this.chamado.getIdUsuarioAdmChamado() != null) {
			this.usuarioLogadoParaExibir2 = new DAO<Usuario>(Usuario.class)
					.buscaPorId(this.chamado.getIdUsuarioAdmChamado());
			return usuarioLogadoParaExibir2;
		} else {
			Usuario usuario2 = new Usuario();
			return usuario2;
		}
	}

	public void setUsuarioLogadoParaExibir2(Usuario usuarioLogadoParaExibir2) {
		this.usuarioLogadoParaExibir2 = usuarioLogadoParaExibir2;
	}

}

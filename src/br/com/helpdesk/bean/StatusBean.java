package br.com.helpdesk.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.helpdesk.dao.DAO;
import br.com.helpdesk.modelo.Status;

@ManagedBean
@ViewScoped
public class StatusBean {
	private Status status = new Status();
	private List<Status> listaDeStatus = new DAO<Status>(Status.class).listaTodos();

	public List<Status> getStatus() {
		return new DAO<Status>(Status.class).listaTodos();
	}

	public List<Status> getListaDeStatus() {
		return listaDeStatus;
	}

	public void setListaDeStatus(List<Status> listaDeStatus) {
		this.listaDeStatus = listaDeStatus;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}

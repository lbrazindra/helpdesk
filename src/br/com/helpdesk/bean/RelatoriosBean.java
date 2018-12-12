package br.com.helpdesk.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.helpdesk.modelo.Chamado;
import br.com.helpdesk.modelo.ModeloRelatorios;
import br.com.helpdesk.teste.TesteDAO;

@ManagedBean
@ViewScoped
public class RelatoriosBean {
	private Chamado chamado = new Chamado();

	public Chamado getChamado() {
		return chamado;
	}

	public void setChamado(Chamado chamado) {
		this.chamado = chamado;
	}

	public List<ModeloRelatorios> getRelatorios() {
//		return new ChamadoDAO().listaTodosPorUsuarioADM();
		try {
				return new TesteDAO().buscar();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List<ModeloRelatorios> getRelatoriosAdm() {
//		return new ChamadoDAO().listaTodosPorUsuarioADM();
		try {
				return new TesteDAO().buscar();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

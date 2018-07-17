package br.com.devdojo.maratonajsf.adriano.bean.comunicacao;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.devdojo.maratonajsf.adriano.model.Estudante;

@Named
@ViewScoped
public class Comunicacao6Bean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Estudante> estudanteList = new Estudante().getEstudanteList();
	public List<Estudante> getEstudanteList() {
		return estudanteList;
	}
	public void setEstudanteList(List<Estudante> estudanteList) {
		this.estudanteList = estudanteList;
	}
	public String editar(int index) {
		Estudante estudante = estudanteList.get(index);
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		flash.put("estudante", estudante);		
		return "comunicacao7?faces-redirect=true";
	}
}

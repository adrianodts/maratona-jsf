package br.com.devdojo.maratonajsf.adriano.bean.comunicacao;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.devdojo.maratonajsf.adriano.model.Estudante;
import br.com.devdojo.maratonajsf.adriano.util.ApplicationMapUtil;

@Named
@ViewScoped
public class Comunicacao11Bean implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Estudante> estudanteList = new Estudante().getEstudanteList();
	
	public List<Estudante> getEstudanteList() {
		return estudanteList;
	}
	public void setEstudanteList(List<Estudante> estudanteList) {
		this.estudanteList = estudanteList;
	}	
	public String editar(Estudante estudante) {
		ApplicationMapUtil.setValueFromApplicationMap("estudante", estudante);
		return "comunicacao12?faces-redirect=true";
	}
}

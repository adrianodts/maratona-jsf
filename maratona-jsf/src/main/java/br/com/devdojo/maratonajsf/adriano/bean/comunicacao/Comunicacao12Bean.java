package br.com.devdojo.maratonajsf.adriano.bean.comunicacao;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.devdojo.maratonajsf.adriano.model.Estudante;
import br.com.devdojo.maratonajsf.adriano.util.ApplicationMapUtil;

@Named
@RequestScoped
public class Comunicacao12Bean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Estudante estudante = new Estudante();
	private List<Estudante> estudanteList = new Estudante().getEstudanteList();
//	
//	public List<Estudante> getEstudanteList() {
//		return estudanteList;
//	}
//	public void setEstudanteList(List<Estudante> estudanteList) {
//		this.estudanteList = estudanteList;
//	}	
	public Estudante getEstudante() {
		return estudante;
	}
	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
	public void init() {
		estudante = (Estudante)ApplicationMapUtil.getValueFromApplicationMap("estudante");
	}
	public String salvar() {
		//estudanteList.add(new Estudante(estudante.getNome(), estudante.getSobrenome(), estudante.getNota1()));
		int index = estudanteList.indexOf((Estudante)ApplicationMapUtil.getValueFromApplicationMap("estudante"));
		estudanteList.get(index).setNome(estudante.getNome());
		estudanteList.get(index).setSobrenome(estudante.getSobrenome());
		estudanteList.get(index).setNota1(estudante.getNota1());
		Estudante.setEstudanteList(estudanteList);
		estudante = new Estudante();
		return "comunicacao11?faces-redirect=true";
	}
}

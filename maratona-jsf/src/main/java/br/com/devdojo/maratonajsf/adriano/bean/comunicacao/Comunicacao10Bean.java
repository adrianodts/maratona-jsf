package br.com.devdojo.maratonajsf.adriano.bean.comunicacao;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.devdojo.maratonajsf.adriano.model.Estudante;

@Named
@ViewScoped
public class Comunicacao10Bean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Estudante estudante = new Estudante();
	private List<Estudante> estudanteList = new Estudante().getEstudanteList();
	
	public Estudante getEstudante() {
		return estudante;
	}
	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
	public List<Estudante> getEstudanteList() {
		return estudanteList;
	}
	public void setEstudanteList(List<Estudante> estudanteList) {
		this.estudanteList = estudanteList;
	}	
	public void remover(Estudante estudante) {
		estudanteList.remove(estudante);
	}
	public void salvar() {
		estudanteList.add(new Estudante(estudante.getNome(), estudante.getSobrenome(), estudante.getNota1()));
		estudante = new Estudante();
	}
}

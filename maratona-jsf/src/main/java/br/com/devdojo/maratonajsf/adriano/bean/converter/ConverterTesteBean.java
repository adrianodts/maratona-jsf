package br.com.devdojo.maratonajsf.adriano.bean.converter;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.devdojo.maratonajsf.adriano.model.Estudante;

@Named
@ViewScoped
public class ConverterTesteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Estudante> estudanteList = new Estudante().getEstudanteList();
	private Estudante estudante;
	
	public List<Estudante> getEstudanteList() {
		return estudanteList;
	}
	public void setEstudanteList(List<Estudante> estudanteList) {
		this.estudanteList = estudanteList;
	}
	public Estudante getEstudante() {
		return estudante;
	}
	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
		System.out.println("setEstudante: " + estudante);
	}
	
	public void save() {
		System.out.println("Salvando");
		System.out.println(this.getEstudante());
	}
}

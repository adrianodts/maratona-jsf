
package br.com.devdojo.maratonajsf.adriano.bean.validator;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.devdojo.maratonajsf.adriano.model.Estudante;

@Named
@ViewScoped
public class ValidatorTesteBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Estudante estudante = new Estudante();
	
	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public void save() {
		System.out.println("Salvando");
		System.out.println(estudante.getEmail());
	}
	
}

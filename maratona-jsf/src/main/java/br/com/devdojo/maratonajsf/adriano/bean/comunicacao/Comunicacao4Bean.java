package br.com.devdojo.maratonajsf.adriano.bean.comunicacao;

import java.io.Serializable;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.devdojo.maratonajsf.adriano.model.Estudante;

@Named
@ViewScoped
public class Comunicacao4Bean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String buttonName = "Nome do botão do bean";
	private Estudante estudante = new Estudante();
	
	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public String getButtonName() {
		return buttonName;
	}

	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}

	public void execute(ActionEvent event) {
		String nome = (String)event.getComponent().getAttributes().get("nome");
		String adjetivo = (String)event.getComponent().getAttributes().get("adjetivo");
		Estudante estudante = (Estudante)event.getComponent().getAttributes().get("estudante");
		System.out.println(nome);
		System.out.println(adjetivo); 		
		System.out.println(estudante);
	}
}

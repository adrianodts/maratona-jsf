package br.com.devdojo.maratonajsf.adriano.bean.comunicacao;

import java.io.Serializable;

import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class Comunicacao5Bean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nome;
	private String sobrenome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		System.out.println("veio do setPropertyActionListener " + nome);
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		System.out.println("veio do setPropertyActionListener " + sobrenome);
		this.sobrenome = sobrenome;
	}

	public void execute(ActionEvent event) {
		System.out.println("Dentro do execute " + nome);
		System.out.println("Dentro do execute " + sobrenome);
	}
	public String execute() {
		System.out.println("Dentro do execute " + nome);
		System.out.println("Dentro do execute " + sobrenome);
		return null;
	}
}

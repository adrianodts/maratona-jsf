package br.com.devdojo.maratonajsf.adriano.bean.comunicacao;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.devdojo.maratonajsf.adriano.model.Estudante;
import br.com.devdojo.maratonajsf.adriano.util.ApplicationMapUtil;

@Named
@RequestScoped
public class ComunicacaoImmediateBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Estudante estudante = new Estudante();
	private Estudante estudante2 = new Estudante();
	
	public Estudante getEstudante() {
		return estudante;
	}
	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
	public void init() {
		estudante = (Estudante)ApplicationMapUtil.getValueFromApplicationMap("estudante");
	}
	public Estudante getEstudante2() {
		return estudante2;
	}
	public void setEstudante2(Estudante estudante2) {
		this.estudante2 = estudante2;
	}
	public void voltar() {
		System.out.println("Nome: " + estudante2.getNome());
		System.out.println("Sobrenome: " + estudante2.getSobrenome());
		//return "comunicacao11?faces-redirect=true";
	}
}

package br.com.devdojo.maratonajsf.adriano.bean.comunicacao;

import java.io.Serializable;
import java.util.Date;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class Comunicacao3Bean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String sobrenome;
	private Date data;
	
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public void init() {
//		if(!FacesContext.getCurrentInstance().isPostback()) {
			System.out.println("Criou Comunicacao3Bean");
			System.out.println(nome);
			System.out.println(sobrenome);
			System.out.println(data);
//		}
	}
}

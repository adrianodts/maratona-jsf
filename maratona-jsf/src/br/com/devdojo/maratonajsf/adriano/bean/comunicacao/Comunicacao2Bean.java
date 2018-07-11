package br.com.devdojo.maratonajsf.adriano.bean.comunicacao;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.Param;

@Named
@ViewScoped
public class Comunicacao2Bean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject @Param(name = "nome")	
	private String nome;
	@Inject @Param(name = "sobrenome")	
	private String sobrenome;
	
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
	@PostConstruct
	public void init() {
		System.out.println("Criou Comunicacao2Bean");
		//Map<String, String> paramsMap = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		//nome = paramsMap.get("nome");
		//sobrenome = paramsMap.get("sobrenome");	
		System.out.println(nome);
		System.out.println(sobrenome);	
	}
	public void imprimirAtributos() {
		String initParameter = FacesContext.getCurrentInstance().getExternalContext().getInitParameter("images.location");
		System.out.println(initParameter);
	}
}

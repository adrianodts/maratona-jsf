package br.com.devdojo.maratonajsf.adriano.bean.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class TesteRequestBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<String> personagens;
	private List<String> personagemSelecionado = new ArrayList<String>();
	
	public List<String> getPersonagemSelecionado() {
		return personagemSelecionado;
	}

	public void setPersonagemSelecionado(List<String> personagemSelecionado) {
		this.personagemSelecionado = personagemSelecionado;
	}

	public void selecionarPersonagem() {
		int index = ThreadLocalRandom.current().nextInt(3);
		String personagem = personagens.get(index);
		personagemSelecionado.add(personagem);
	}
	
	@PostConstruct
	public void init() {
		personagens = Arrays.asList("Yusuke", "Hiei", "Kurama");
		System.out.println(personagens);
	}
	
	public String redirect() {
		return "index2?faces-redirect=true";
	}
}

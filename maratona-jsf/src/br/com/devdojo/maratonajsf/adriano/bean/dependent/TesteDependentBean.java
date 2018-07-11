package br.com.devdojo.maratonajsf.adriano.bean.dependent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named
@Dependent
public class TesteDependentBean implements Serializable {

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
		personagens = Arrays.asList("Batman", "Aquaman", "Superman");
		System.out.println(personagens);
		System.out.println("Entrou no @PostConstruct" + this.getClass().getName());
	}
	
}

package br.com.devdojo.maratonajsf.adriano.bean.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.devdojo.maratonajsf.adriano.bean.dependent.TesteDependentBean;
import br.com.devdojo.maratonajsf.adriano.bean.session.TesteSessionBean;

@Named
@ViewScoped
public class TesteViewBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<String> personagens;
	private List<String> personagemSelecionado = new ArrayList<String>();
	private final TesteDependentBean dependentBean;
	private final TesteSessionBean sessionBean; 


	@Inject
	public TesteViewBean(
			TesteDependentBean dependentBean,
			TesteSessionBean sessionBean)
	{
		this.dependentBean = dependentBean;
		this.sessionBean = sessionBean;
	}
	
	public List<String> getPersonagemSelecionado() {
		return personagemSelecionado;
	}

	public void setPersonagemSelecionado(List<String> personagemSelecionado) {
		this.personagemSelecionado = personagemSelecionado;
	}
	
	

	public TesteDependentBean getDependentBean() {
		return dependentBean;
	}
	
	public TesteSessionBean getSessionBean() {
		return sessionBean;
	}
	
	public void selecionarPersonagem() {
		int index = ThreadLocalRandom.current().nextInt(3);
		String personagem = personagens.get(index);
		personagemSelecionado.add(personagem);
		dependentBean.getPersonagemSelecionado().add(personagem);
	}
	
	@PostConstruct
	public void init() {
		personagens = Arrays.asList("Naruto", "Hinata", "Yondaime");
		System.out.println(personagens);
		System.out.println("Entrou no @PostConstruct" + this.getClass().getName());
	}
	
	
}

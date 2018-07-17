package br.com.devdojo.maratonajsf.adriano.bean.session;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.devdojo.maratonajsf.adriano.model.Estudante;

@Named
@SessionScoped
public class TesteSessionBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<String> personagens;
	private List<String> personagemSelecionado = new ArrayList<String>();
	private Estudante estudante;
	
	

	public void logar()
	{
		estudante = new Estudante();
	}
	
	public List<String> getPersonagemSelecionado() {
		return personagemSelecionado;
	}

	public void setPersonagemSelecionado(List<String> personagemSelecionado) {
		this.personagemSelecionado = personagemSelecionado;
	}
	
	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public void selecionarPersonagem() {
		int index = ThreadLocalRandom.current().nextInt(3);
		String personagem = personagens.get(index);
		personagemSelecionado.add(personagem);
	}
	
	@PostConstruct
	public void init() {
		personagens = Arrays.asList("Gohan", "Goku", "Vegeta");
		logar();
		System.out.println(personagens);
		System.out.println("Entrou no @PostConstruct" + this.getClass().getName());
	}
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "session?faces-redirect=true";
	}
	
}

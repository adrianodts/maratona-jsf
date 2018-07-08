package br.com.devdojo.maratonajsf.adriano.bean.conversation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ConversationScoped 
public class TesteConversationBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<String> personagens;
	private List<String> personagemSelecionado = new ArrayList<String>();
	
	public List<String> getPersonagemSelecionado() {
		return personagemSelecionado;
	}

	public void setPersonagemSelecionado(List<String> personagemSelecionado) {
		this.personagemSelecionado = personagemSelecionado;
	}

	
	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	public void selecionarPersonagem() {
		int index = ThreadLocalRandom.current().nextInt(3);
		String personagem = personagens.get(index);
		personagemSelecionado.add(personagem);
	}
	
	@Inject
	private Conversation conversation;
	
	//@PostConstruct
	public void init() {
		personagens = Arrays.asList("Luffy", "Zoro", "Sanji");
		System.out.println(personagens);
		System.out.println("Entrou no @PostConstruct" + this.getClass().getName());
		
		if(conversation.isTransient())
		{
			//Long running
			conversation.begin();
			System.out.println("Iniciando conversation scoped, ID: " + conversation.getId());
		}
	}
	
	public String endConversation() {
		if(!conversation.isTransient())
		{
			conversation.end();
			System.out.println("Finalizando conversation scoped");
		}
		return "conversation?faces-redirect=true";
	}
}

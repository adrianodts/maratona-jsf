package br.com.devdojo.maratonajsf.adriano.bean.application;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped 
public class TesteApplicationBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<String> categoriaList;
	
	@PostConstruct
	public void init() {
		categoriaList = Arrays.asList("RPG", "SCI-FI", "Terror");
		System.out.println(categoriaList);
		System.out.println("Entrou no @PostConstruct" + this.getClass().getName());
	}

	public List<String> getCategoriaList() {
		return categoriaList;
	}

	public void setCategoriaList(List<String> categoriaList) {
		this.categoriaList = categoriaList;
	}
	
	public void mudarLista()
	{
		categoriaList = Arrays.asList("RPG", "SCI-FI", "Terror", "Comedy");
	}
}

package br.com.devdojo.maratonajsf.adriano.bean.application;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.devdojo.maratonajsf.adriano.bean.dependent.TesteDependentBean;
import br.com.devdojo.maratonajsf.adriano.bean.session.TesteSessionBean;

@Named
@ApplicationScoped 
public class TesteApplicationBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<String> categoriaList;

	private final TesteDependentBean dependentBean;
	private final TesteSessionBean sessionBean;
	
	@Inject
	public TesteApplicationBean(
			TesteDependentBean dependentBean, 
			TesteSessionBean sessionBean) {
		this.dependentBean = dependentBean;
		this.sessionBean =sessionBean;
	}
	
	@PostConstruct
	public void init() {
		categoriaList = Arrays.asList("RPG", "SCI-FI", "Terror");
		sessionBean.selecionarPersonagem();
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
	
	public TesteDependentBean getDependentBean() {
		return dependentBean;
	}

	public TesteSessionBean getSessionBean() {
		return sessionBean;
	}

	
}

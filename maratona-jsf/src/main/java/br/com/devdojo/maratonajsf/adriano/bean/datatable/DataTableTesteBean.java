package br.com.devdojo.maratonajsf.adriano.bean.datatable;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.devdojo.maratonajsf.adriano.model.Estudante;

@Named
@ViewScoped
public class DataTableTesteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Estudante> estudanteList = new Estudante().getEstudanteList();
	private Set<Estudante> estudanteSet = new HashSet<>(new Estudante().getEstudanteList());
	private  LinkedList<Estudante> estudanteLinkedList = new LinkedList<>(new Estudante().getEstudanteList());
	private Map<String, Estudante> mapEstudanteList = new HashMap<>();

	public Map<String, Estudante> getMapEstudanteList() {
		return mapEstudanteList;
	}

	public void setMapEstudanteList(Map<String, Estudante> mapEstudanteList) {
		this.mapEstudanteList = mapEstudanteList;
	}

	public void init()
	{
		mapEstudanteList.put("Estudante 1", new Estudante(1, "Clark", "Kent", 9));
		mapEstudanteList.put("Estudante 2", new Estudante(2, "Bruce ", "Wayne", 8));
		mapEstudanteList.put("Estudante 3", new Estudante(3, "Diana", "Prince", 10));
	}
	
	public Set<Estudante> getEstudanteSet() {
		return estudanteSet;
	}

	public void setEstudanteSet(Set<Estudante> estudanteSet) {
		this.estudanteSet = estudanteSet;
	}

	public LinkedList<Estudante> getEstudanteLinkedList() {
		return estudanteLinkedList;
	}

	public void setEstudanteLinkedList(LinkedList<Estudante> estudanteLinkedList) {
		this.estudanteLinkedList = estudanteLinkedList;
	}

	public List<Estudante> getEstudanteList() {
		return estudanteList;
	}

	public void setEstudanteList(List<Estudante> estudanteList) {
		this.estudanteList = estudanteList;
	}
	
	public void orderByName(String ordem) {
		if(ordem.equals("asc"))
			estudanteList.sort(Comparator.comparing(Estudante::getNome));
		else if(ordem.equals("desc"))
			estudanteList.sort(Comparator.comparing(Estudante::getNome).reversed());
	}
	public void orderBySobreNome(String ordem) {
		if(ordem.equals("asc"))
			estudanteList.sort(Comparator.comparing(Estudante::getSobrenome));
		else if(ordem.equals("desc"))
			estudanteList.sort(Comparator.comparing(Estudante::getSobrenome).reversed());
	}
	public void orderByNota1(String ordem) {
		if(ordem.equals("asc"))
			estudanteList.sort(Comparator.comparing(Estudante::getNota1));
		else if(ordem.equals("desc"))
			estudanteList.sort(Comparator.comparing(Estudante::getNota1).reversed());
	}
	
	
}

package br.com.devdojo.maratonajsf.adriano.beans;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.devdojo.maratonajsf.adriano.model.Estudante;

@Named
@ViewScoped
public class EstudanteRegistrarBean implements Serializable {
	private String[] nomesArray = {"Devdojo", "eh", "foda"};
	private List<String> nomesList = Arrays.asList("Adriano", "Maria", "Jose");
	private Set<String> nomesSet = new HashSet<String>(Arrays.asList("Goku", "Naruto", "Luffy"));
	private Map<String, String> nomesMap = new HashMap<String, String>();
	private boolean mostrarNotas = false;
	private String toogleNotas = (this.mostrarNotas ? "EsconderNotas" : "Exibir Notas");
	
	{	
		nomesMap.put("Goku", "O mais forte");
		nomesMap.put("One Piece", "O mais longo");
		nomesMap.put("Naruto", "O mais lenga lenga");
	}
	
	public void executar() {
		System.out.println("Fazendo uma busca no BD");
		System.out.println("Processando os dados");
		System.out.println("Exibindo os dados");
	}
	
	public void executar(String parametro) {
		System.out.println("Fazendo uma busca no BD com o parametro: " + parametro);
		System.out.println("Processando os dados");
		System.out.println("Exibindo os dados");
	}
	
	public String executarRetorno(String parametro) {
		return "Quem eh o lindao ? " + parametro;
	}
	
	public String irParaIndex2() {
		return "index2";
	}
	
	public Map<String, String> getNomesMap() {
		return nomesMap;
	}

	public void setNomesMap(Map<String, String> nomesMap) {
		this.nomesMap = nomesMap;
	}

	public Set<String> getNomesSet() {
		return nomesSet;
	}

	public void setNomesSet(Set<String> nomesSet) {
		this.nomesSet = nomesSet;
	}

	public List<String> getNomesList() {
		return nomesList;
	}

	public void setNomesList(List<String> nomesList) {
		this.nomesList = nomesList;
	}

	public String[] getNomesArray() {
		return nomesArray;
	}

	public void setNomesArray(String[] nomesArray) {
		this.nomesArray = nomesArray;
	}

	private Estudante estudante = new Estudante();
	
	private static final long serialVersionUID = 1L;
	
	private String mensagem;
	
	public String getMensagem() {
		return mensagem;
	}
	
	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}

	public void saySomething() {
		this.mensagem = "Ajax message : Welcome " + estudante.getNome();
//		if("".equals(nome) || nome ==null){
//			return "";
//		}else{
//			return "Ajax message : Welcome " + nome;
//		} 
	}
	
//	public void exibirNotas() {
//		this.mostrarNotas =! this.mostrarNotas;
//	}

	public void exibirEscondereNotas() {
		this.mostrarNotas =! this.mostrarNotas;
		this.toogleNotas = (this.mostrarNotas ? "EsconderNotas" : "Exibir Notas");
	}

	public boolean isMostrarNotas()
	{
		return this.mostrarNotas;
	}
	
	public String getToogleNotas()
	{
		return this.toogleNotas;
	}
}

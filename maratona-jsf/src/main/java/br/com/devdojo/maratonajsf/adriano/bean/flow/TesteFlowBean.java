package br.com.devdojo.maratonajsf.adriano.bean.flow;

import java.io.Serializable;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;

@Named
@FlowScoped(value="registration")
public class TesteFlowBean implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String sobreNome;
	private String endereco;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public void salvar() {
		System.out.println("Salvando no banco");
		System.out.println("Nome: " + this.getNome());
		System.out.println("Sobrenome: " + this.getSobreNome());
		System.out.println("Endereço: " + this.getEndereco());
		//return "exitToInicio";
	}
	
}

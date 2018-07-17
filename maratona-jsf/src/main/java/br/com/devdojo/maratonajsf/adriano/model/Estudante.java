package br.com.devdojo.maratonajsf.adriano.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.devdojo.maratonajsf.adriano.model.enums.Turno;

public class Estudante {

	private String nome = "Adriano";
	private String sobrenome = "Dantas";
	private double nota1 = 10; 
	private double nota2 = 9;
	private double nota3 = 9;
	private Turno turno = Turno.MATUTINO;
	
	private static List<Estudante> estudanteList = new ArrayList<Estudante>(Arrays.asList(
			new Estudante("Clark", "Kent", 9),
			new Estudante("Bruce ", "Wayne", 8),
			new Estudante("Diana", "Prince", 10)));
	
	public static void setEstudanteList(List<Estudante> estudanteList) {
		Estudante.estudanteList = estudanteList;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public double getNota1() {
		return nota1;
	}
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	public double getNota2() {
		return nota2;
	}
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	public double getNota3() {
		return nota3;
	}
	public void setNota3(double nota3) {
		this.nota3 = nota3;
	}
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	public Estudante() {}
	public Estudante(String nome,String sobrenome, double nota1) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.nota1 = nota1;
	}
	
	public List<Estudante> getEstudanteList() {		
		return estudanteList;
	}
	

}

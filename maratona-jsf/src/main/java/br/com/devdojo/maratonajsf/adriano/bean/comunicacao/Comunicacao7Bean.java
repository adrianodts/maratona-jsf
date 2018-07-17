package br.com.devdojo.maratonajsf.adriano.bean.comunicacao;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.devdojo.maratonajsf.adriano.model.Estudante;

@Named
@ViewScoped
public class Comunicacao7Bean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Estudante estudante;

	public Estudante getEstudante() {
		return estudante;
	}

	public void onLoad()
	{
		Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
		estudante = (Estudante)flash.get("estudante");		
	}
}

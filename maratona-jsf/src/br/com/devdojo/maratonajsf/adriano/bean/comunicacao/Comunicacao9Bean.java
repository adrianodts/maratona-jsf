package br.com.devdojo.maratonajsf.adriano.bean.comunicacao;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.omnifaces.util.Faces;

@Named
@ViewScoped
public class Comunicacao9Bean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static String key = "nome";
	private String value;
	
	public String getValue() {
		return value;
	}

	public void init() {
		value = getCookieValue(key);
	}

	public void removerCookie() {
		Faces.addResponseCookie(key, null, 0);
		value = null;
	}
	
	private String getCookieValue(String key) {
		return Faces.getRequestCookie(key);
	}
}

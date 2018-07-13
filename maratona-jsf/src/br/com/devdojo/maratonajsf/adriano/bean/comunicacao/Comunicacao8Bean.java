package br.com.devdojo.maratonajsf.adriano.bean.comunicacao;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.servlet.http.Cookie;

import org.omnifaces.util.Faces;

@Named
@ViewScoped
public class Comunicacao8Bean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static String key = "nome";
	private String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void init() {
		Map<String, Object> cookies = FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap();
		
		//Obtendo cookie da forma mais fácil
		System.out.println("Obtendo cookie através do médoto -> Faces.getRequestCookie() : "+ Faces.getRequestCookie(key));
		
		//ou isso :(		
		if(cookies.get(key) != null) {
			Cookie cookie = (Cookie)cookies.get(key);
			try {
				String cookieValueDecoded = URLDecoder.decode(cookie.getValue(), "UTF-8");
				System.out.println("Obtendo cookie através do método mais penoso -> " + cookieValueDecoded);
			}catch(UnsupportedEncodingException ex) {
				ex.printStackTrace();
			}
		}
		System.out.println(cookies);
	}
	public String salvarCookie() {
		//Omnifaces facilita o trabaho com cookies
		Faces.addResponseCookie(key, value, -1); //maxAge = -1 (live forever)
		return "comunicacao9?faces-redirect=true";
	}
}

package br.com.devdojo.maratonajsf.adriano.bean.flowbuilder;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;

@Named
@FlowScoped(value="newpendencie")
public class TesteFlowBuilderNestedBean implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName;
	private String userSurname;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSurname() {
		return userSurname;
	}
	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}
	
	public String validarUser() {
		System.out.println("Fazendo consulta na SERASA");
		System.out.println("Fazendo consulta no SPC");
		if(this.userName.equals("") || this.userSurname.equals("")) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário não passou nas pendências", "Algum detalge útil"));
			return null;
		}
		return "proceedToNewRegistration3";
	}
}

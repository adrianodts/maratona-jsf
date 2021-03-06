package br.com.devdojo.maratonajsf.adriano.bean.flow;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.flow.FlowScoped;
import javax.inject.Named;

@Named
@FlowScoped(value="pendencie")
public class TesteFlowNestedBean implements Serializable {

	
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
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usu�rio n�o passou nas pend�ncias", "Algum detalge �til"));
		return null;
		//return "proceedToRegistration";
	}
}

package br.com.devdojo.maratonajsf.adriano.validators;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.devdojo.maratonajsf.adriano.bean.login.LoginBean;

@Named
@RequestScoped
public class Validators implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<String> emailsDB = Arrays.asList(
			"adrianodts@gmail.com", 
			"teste@devdojo.com"
		);
		
		@Inject
		private LoginBean loginBean;
		
		public void validateDuplicatedEmail(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
			
			System.out.println(loginBean.getLanguage());
			String email = (String)o;
			String mensagemValidacao = MessageFormat.format(getResourceBundleString("m","duplicatedEmailValidator"), email);
			
			if(emailsDB.contains(email)) {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagemValidacao,"");
				throw new ValidatorException(message);
			}
		}
		
		public static String getResourceBundleString(String resourceBundleName, String resourceBundleKey)
	        throws MissingResourceException {
		    FacesContext facesContext = FacesContext.getCurrentInstance();
		    ResourceBundle bundle = facesContext.getApplication().getResourceBundle(facesContext, resourceBundleName);
		    return bundle.getString(resourceBundleKey);
		}
}

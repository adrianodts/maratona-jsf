package br.com.devdojo.maratonajsf.adriano.Converters;

import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.devdojo.maratonajsf.adriano.model.Estudante;

@FacesConverter(value="estudanteConverter")
public class EstudanteConverter implements Converter {
	private List<Estudante> estudanteList = new Estudante().getEstudanteList();
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null || !value.matches("\\d+")) {
			return null;
		}
		//Esse código deve ser trocado em caso de uma busca no banco de dados
//		Estudante estudante = new Estudante();
//		estudante.setId(Integer.parseInt(value));
//		int index = estudanteList.indexOf(estudante);
//		estudante = estudanteList.get(index);
//		System.out.println("EstudanteConverter return --> " + estudante);
//		return estudante;
		Object o = this.getAttributesFrom(component).get(value);
		System.out.println("EstudanteConverter return --> " + (Estudante)o);
		return o;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null && !value.equals("")) {
			Estudante estudante = (Estudante)value;
			if(estudante.getId() != null) {
				this.addAttribute(component, estudante);
				return estudante.getId().toString();
			}
		}
		return null;
	}
	
	public Map<String, Object> getAttributesFrom(UIComponent component){
		return component.getAttributes();
	}
	
	public void addAttribute(UIComponent component, Estudante estudante){
		getAttributesFrom(component).put(estudante.getId().toString(), estudante);
	}
	
}

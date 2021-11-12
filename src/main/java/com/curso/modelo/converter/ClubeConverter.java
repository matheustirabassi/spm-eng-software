package com.curso.modelo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.curso.dao.ClubeDAO;
import com.curso.modelo.Clube;
import com.curso.util.cdi.CDIServiceLocator;



@FacesConverter(forClass=Clube.class)
public class ClubeConverter implements Converter<Object> {

	private ClubeDAO clubeDAO;
	
	public ClubeConverter() {
		this.clubeDAO = CDIServiceLocator.getBean(ClubeDAO.class);
	}
	
	@Override    //converte tipo String para objeto - necessário mapear do modelo relacional para obj
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Clube retorno = null;

		if (value != null) {
			retorno = this.clubeDAO.buscarPeloCodigo(Long.parseLong(value));
		}

		return retorno;
	}

	@Override  //converte de objeto para codigo - necessário mapear do modelo obj para relacional
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Clube) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}

}
package com.curso.modelo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.curso.dao.FederacaoDAO;
import com.curso.modelo.Federacao;
import com.curso.util.cdi.CDIServiceLocator;



@FacesConverter(forClass=Federacao.class)
public class FederacaoConverter implements Converter<Object> {

	private FederacaoDAO federacaoDAO;
	
	public FederacaoConverter() {
		this.federacaoDAO = CDIServiceLocator.getBean(FederacaoDAO.class);
	}
	
	@Override    //converte tipo String para objeto - necessário mapear do modelo relacional para obj
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Federacao retorno = null;

		if (value != null) {
			retorno = this.federacaoDAO.buscarPeloCodigo(Long.parseLong(value));
		}

		return retorno;
	}

	@Override  //converte de objeto para codigo - necessário mapear do modelo obj para relacional
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Federacao) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());
			
			return retorno;
		}
		
		return "";
	}

}
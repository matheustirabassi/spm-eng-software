package com.curso.modelo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.curso.dao.LoginDAO;
import com.curso.modelo.Login;
import com.curso.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Login.class)
public class LoginConverter implements Converter<Object> {

	private LoginDAO loginDAO;

	public LoginConverter() {
		this.loginDAO = CDIServiceLocator.getBean(LoginDAO.class);
	}

	@Override // converte tipo String para objeto - necessário mapear do modelo relacional
				// para obj
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Login retorno = null;

		if (value != null) {
			retorno = this.loginDAO.findById(Integer.parseInt(value));
		}

		return retorno;
	}

	@Override // converte de objeto para codigo - necessário mapear do modelo obj para
				// relacional
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Integer codigo = ((Login) value).getId();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}

		return "";
	}

}
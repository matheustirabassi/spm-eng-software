package com.curso.modelo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.curso.modelo.Tutor;
import com.curso.service.TutorService;
import com.curso.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Tutor.class)
public class TutorConverter implements Converter<Object> {

	private TutorService service;

	public TutorConverter() {
		this.service = CDIServiceLocator.getBean(TutorService.class);
	}

	@Override // converte tipo String para objeto - necessário mapear do modelo relacional
				// para obj
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null) {
			return this.service.buscarPorId(Long.parseLong(value));
		}

		return null;
	}

	@Override // converte de objeto para codigo - necessário mapear do modelo obj para
				// relacional
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Long codigo = ((Tutor) value).getCpf();
			return (codigo == null ? null : codigo.toString());
		}

		return "";
	}

}
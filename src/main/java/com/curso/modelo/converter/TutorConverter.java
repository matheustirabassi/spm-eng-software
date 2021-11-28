package com.curso.modelo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.curso.dao.TutorDAO;
import com.curso.modelo.Tutor;
import com.curso.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Tutor.class)
public class TutorConverter implements Converter<Tutor> {

  private TutorDAO dao;

  public TutorConverter() {
    dao = CDIServiceLocator.getBean(TutorDAO.class);
  }

  @Override // converte tipo String para objeto - necessário mapear do modelo relacional
            // para obj
  public Tutor getAsObject(FacesContext context, UIComponent component, String value) {
    if (value != null) {
      return dao.findById(Long.parseLong(value));
    }

    return null;
  }

  @Override // converte de objeto para codigo - necessário mapear do modelo obj para
            // relacional
  public String getAsString(FacesContext context, UIComponent component, Tutor value) {
    if (value != null) {
      Long codigo = value.getCpf();
      return codigo == null ? null : codigo.toString();
    }

    return "";
  }

}

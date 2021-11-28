package com.curso.modelo.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.curso.dao.AgendamentoDAO;
import com.curso.modelo.Agendamento;
import com.curso.util.cdi.CDIServiceLocator;

@FacesConverter(forClass = Agendamento.class)
public class AgendamentoConverter implements Converter<Agendamento> {

  private AgendamentoDAO dao;

  public AgendamentoConverter() {
    this.dao = CDIServiceLocator.getBean(AgendamentoDAO.class);
  }

  @Override // converte tipo String para objeto - necessário mapear do modelo relacional
            // para obj
  public Agendamento getAsObject(FacesContext context, UIComponent component, String value) {
    if (value != null) {
      return this.dao.findById(Long.parseLong(value));
    }

    return null;
  }

  @Override // converte de objeto para codigo - necessário mapear do modelo obj para
            // relacional
  public String getAsString(FacesContext context, UIComponent component, Agendamento value) {
    if (value != null) {
      Long codigo = value.getId();
      return codigo == null ? null : codigo.toString();
    }

    return "";
  }

}

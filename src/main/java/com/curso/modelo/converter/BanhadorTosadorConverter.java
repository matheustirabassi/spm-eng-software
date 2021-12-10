package com.curso.modelo.converter;

import com.curso.dao.BanhadorTosadorDAO;
import com.curso.modelo.BanhadorTosador;
import com.curso.util.cdi.CDIServiceLocator;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Conversor da classe BanhadorTosador.
 *
 * @author Matheus Henrique
 *
 */
@FacesConverter(forClass = BanhadorTosador.class)
public class BanhadorTosadorConverter implements Converter<BanhadorTosador> {

  private BanhadorTosadorDAO dao;

  public BanhadorTosadorConverter() {
    this.dao = CDIServiceLocator.getBean(BanhadorTosadorDAO.class);
  }

  /**
   * converte tipo String para objeto - necessário mapear do modelo relacional para obj.
   *
   */
  @Override
  public BanhadorTosador getAsObject(FacesContext context, UIComponent component, String value) {
    BanhadorTosador retorno = null;

    if (value != null) {
      retorno = this.dao.findById(Long.parseLong(value));
    }

    return retorno;
  }


  /**
   * converte de objeto para codigo necessário mapear do modelo obj para relacional.
   *
   */
  @Override
  public String getAsString(FacesContext context, UIComponent component,
      BanhadorTosador value) {
    if (value != null) {
      Long codigo = value.getId();
      return (codigo == null ? null : codigo.toString());
    }

    return "";
  }

}

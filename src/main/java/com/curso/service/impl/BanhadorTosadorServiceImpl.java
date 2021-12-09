package com.curso.service.impl;

import java.util.List;
import com.curso.dao.GenericDAO;
import com.curso.modelo.BanhadorTosador;
import com.curso.service.BanhadorTosadorService;

public class BanhadorTosadorServiceImpl extends GenericServiceImpl<BanhadorTosador>
    implements BanhadorTosadorService {

  private static final long serialVersionUID = 1L;

  @Override
  public List<BanhadorTosador> findByExample(BanhadorTosador example, Integer start,
      Integer limit) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected GenericDAO<BanhadorTosador> getDAO() {
    // TODO Auto-generated method stub
    return null;
  }

}

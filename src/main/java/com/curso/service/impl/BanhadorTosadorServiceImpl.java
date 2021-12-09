package com.curso.service.impl;

import com.curso.dao.BanhadorTosadorDAO;
import com.curso.dao.GenericDAO;
import com.curso.modelo.BanhadorTosador;
import com.curso.service.BanhadorTosadorService;
import java.util.List;
import javax.inject.Inject;

public class BanhadorTosadorServiceImpl extends GenericServiceImpl<BanhadorTosador>
    implements BanhadorTosadorService {

  private static final long serialVersionUID = 1L;
  @Inject
  private BanhadorTosadorDAO banhadorTosadorDao;

  @Override
  public List<BanhadorTosador> findByExample(BanhadorTosador example, Integer start,
      Integer limit) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected GenericDAO<BanhadorTosador> getDAO() {
    return banhadorTosadorDao;
  }

}

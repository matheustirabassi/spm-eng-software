package com.curso.dao;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import com.curso.modelo.BanhadorTosador;

public class BanhadorTosadorDAO implements Serializable, GenericDAO<BanhadorTosador> {

  private static final long serialVersionUID = 1L;

  @Inject
  private EntityManager manager;

  @Override
  public BanhadorTosador findById(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<BanhadorTosador> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BanhadorTosador save(BanhadorTosador t) {
    // TODO Auto-generated method stub
    return manager.merge(t);
  }

  @Override
  public BanhadorTosador saveOrUpdate(BanhadorTosador t) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void saveOrUpdateAll(List<BanhadorTosador> t) {
    // TODO Auto-generated method stub

  }

  @Override
  public void delete(BanhadorTosador t) {
    // TODO Auto-generated method stub

  }

}

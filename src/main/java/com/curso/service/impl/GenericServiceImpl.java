package com.curso.service.impl;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import com.curso.dao.GenericDAO;
import com.curso.service.GenericService;

public abstract class GenericServiceImpl<T> implements GenericService<T>, Serializable {
  private static final long serialVersionUID = 1L;

  @Inject
  protected abstract GenericDAO<T> getDAO();

  @Override
  @Transactional
  public void delete(T t) {
    getDAO().delete(t);
  }

  @Override
  @Transactional
  public List<T> findAll() {
    return getDAO().findAll();
  }

  @Override
  @Transactional
  public T findById(Long id) {
    return getDAO().findById(id);
  }

  @Override
  @Transactional
  public T saveOrUpdate(T t) {
    return getDAO().saveOrUpdate(t);
  }

}

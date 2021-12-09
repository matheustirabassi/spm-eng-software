package com.curso.service;

import java.util.List;

public interface GenericService<T> {

  public T saveOrUpdate(T entity);

  public void delete(T entity);

  public T findById(Long id);

  public List<T> findByExample(T example, Integer start, Integer limit);

  public List<T> findAll();
}

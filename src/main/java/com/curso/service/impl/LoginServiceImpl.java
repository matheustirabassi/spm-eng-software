package com.curso.service.impl;

import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import com.curso.dao.GenericDAO;
import com.curso.dao.LoginDAO;
import com.curso.modelo.Login;
import com.curso.service.LoginService;

public class LoginServiceImpl extends GenericServiceImpl<Login> implements LoginService {

  private static final long serialVersionUID = 1L;
  @Inject
  private LoginDAO loginDAO;


  @Override
  protected GenericDAO<Login> getDAO() {
    return loginDAO;
  }


  @Override
  public List<Login> findByExample(Login example, Integer start, Integer limit) {
    // TODO Auto-generated method stub
    return Collections.emptyList();
  }


  @Override
  public Login findByEmail(String email) {
    try {
      return loginDAO.findByEmail(email);
    } catch (NoResultException e) {
      e.getMessage();
    }
    return null;

  }


  @Override
  public List<Login> findByName(String nome) {
    return loginDAO.findByName(nome);
  }

}

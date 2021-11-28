package com.curso.service;

import java.util.List;

import com.curso.modelo.Login;

public interface LoginService extends GenericService<Login> {

  public Login findByEmail(String email);

  public List<Login> findByName(String nome);

}

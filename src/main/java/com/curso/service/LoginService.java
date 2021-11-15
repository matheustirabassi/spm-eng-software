package com.curso.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.curso.dao.LoginDAO;
import com.curso.modelo.Login;
import com.curso.util.NegocioException;

public class LoginService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private LoginDAO loginDAO;


	public void save(Login login) throws NegocioException {		
		this.loginDAO.save(login);		
	}	
	
	public List<Login> findAll() {
		return loginDAO.findAll();
	}
	
	public void delete(Login login) throws NegocioException {
		loginDAO.delete(login);		
	}

	
	public Login findByEmail(String email) {
		return loginDAO.findByEmail(email);
		
	}
	
	public List<Login> findByName(String nome){
		return loginDAO.findByName(nome);
	}
	

	public List<Login> buscarLogins() {
		return loginDAO.findAll();
	}
}

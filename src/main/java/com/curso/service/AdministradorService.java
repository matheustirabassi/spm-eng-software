package com.curso.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.curso.dao.AdministradorDAO;
import com.curso.modelo.Administrador;
import com.curso.util.NegocioException;

public class AdministradorService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private AdministradorDAO administradorDAO;


	public void save(Administrador administrador) throws NegocioException {		
		this.administradorDAO.save(administrador);		
	}	
	
	public List<Administrador> findAll() {
		return administradorDAO.findAll();
	}
	
	public void delete(Administrador administrador) throws NegocioException {
		administradorDAO.delete(administrador);		
	}

	
	public Administrador findByEmail(String email) {
		return administradorDAO.findByEmail(email);
		
	}
	
	public List<Administrador> findByName(String nome){
		return administradorDAO.findByName(nome);
	}
	

	public List<Administrador> buscarAdministradores() {
		return administradorDAO.findAll();
	}
}

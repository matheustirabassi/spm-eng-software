package com.curso.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import com.curso.dao.TutorDAO;
import com.curso.modelo.Tutor;
import com.curso.util.NegocioException;

public class TutorService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private TutorDAO tutorDAO;


	public void salvar(Tutor tutor) throws NegocioException {		
		this.tutorDAO.save(tutor);		
	}	
	
	public List<Tutor> buscarTodos() {
		return tutorDAO.findAll();
	}
	
	public void excluir(Tutor tutor) throws NegocioException {
		tutorDAO.delete(tutor);		
	}

	
	public Tutor buscarPorEmail(String email) {
		return tutorDAO.findByEmail(email);
		
	}
	
	public List<Tutor> buscarPorNome(String nome){
		return tutorDAO.findByName(nome);
	}
	public Tutor buscarPorId(Long cpf) {
		return tutorDAO.findById(cpf);
	}
}

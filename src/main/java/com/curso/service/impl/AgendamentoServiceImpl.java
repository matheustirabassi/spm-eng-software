package com.curso.service.impl;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import com.curso.dao.AgendamentoDAO;
import com.curso.dao.GenericDAO;
import com.curso.modelo.Agendamento;
import com.curso.service.AgendamentoService;

public class AgendamentoServiceImpl extends GenericServiceImpl<Agendamento> implements AgendamentoService {
	
	private static final long serialVersionUID = 1L;
	@Inject
	private AgendamentoDAO agendamentoDAO;

	@Override
	public Agendamento saveOrUpdate(Agendamento entity) {
		return agendamentoDAO.save(entity);
	}

	@Override
	public void delete(Agendamento entity) {
		agendamentoDAO.delete(entity);

	}

	@Override
	public Agendamento findById(Long id) {
		return agendamentoDAO.findById(id);
	}

	@Override
	public List<Agendamento> findByExample(Agendamento example, Integer start, Integer limit) {
		return Collections.emptyList();
	}

	@Override
	public List<Agendamento> findAll() {
		return agendamentoDAO.findAll();
	}

	@Override
	protected GenericDAO<Agendamento> getDAO() {
		return agendamentoDAO;
	}
}

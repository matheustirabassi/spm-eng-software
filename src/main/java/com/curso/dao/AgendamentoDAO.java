package com.curso.dao;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.curso.modelo.Agendamento;
import com.curso.util.jpa.Transactional;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class AgendamentoDAO implements Serializable, GenericDAO<Agendamento> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Override
	@Transactional
	public Agendamento save(Agendamento agendamento) {
		log.info("gravando agendamento...");
		return manager.merge(agendamento);
	}

	@Override
	@Transactional
	public void delete(Agendamento agendamento) {
		try {
			log.info("excluindo agendamento...");
			agendamento = findById(agendamento.getId());
			manager.remove(agendamento);
			manager.flush();
		} catch (PersistenceException e) {
			log.error(e.getLocalizedMessage());

		}
	}

	@Override
	public Agendamento findById(Long codigo) {
		return manager.find(Agendamento.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Agendamento> findAll() {
		List<Agendamento> result = manager.createNamedQuery("Agendamento.buscarTodos").getResultList();
		if (result != null) {
			return result;
		}
		return Collections.emptyList();
	}

	@SuppressWarnings("unchecked")
	public List<Agendamento> findWithPagination(int first, int pageSize) {
		return manager.createNamedQuery("Agendamento.buscarTodos").setFirstResult(first).setMaxResults(pageSize)
				.getResultList();
	}

	@Override
	public Agendamento saveOrUpdate(Agendamento t) {
		return null;
	}

	@Override
	public void saveOrUpdateAll(List<Agendamento> t) {
	}
}
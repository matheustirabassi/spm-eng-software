package com.curso.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.curso.modelo.Agendamento;
import com.curso.util.NegocioException;
import com.curso.util.jpa.Transactional;

import lombok.extern.log4j.Log4j;

@Log4j
public class AgendamentoDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	@Transactional
	public void salvar(Agendamento agendamento) {
		log.info("gravando agendamento...");
		manager.merge(agendamento);
	}

	@Transactional
	public void excluir(Agendamento agendamento) throws NegocioException {
		log.info("excluindo agendamento...");
		agendamento = buscarPeloCodigo(agendamento.getId());
		try {
			manager.remove(agendamento);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Este agendamento não pode ser excluído.");
		}
	}

	public Agendamento buscarPeloCodigo(Long codigo) {
		return manager.find(Agendamento.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Agendamento> buscarTodos() {
		return manager.createNamedQuery("Agendamento.buscarTodos").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Agendamento> buscarComPaginacao(int first, int pageSize) {
		return manager.createNamedQuery("Agendamento.buscarTodos").setFirstResult(first).setMaxResults(pageSize)
				.getResultList();
	}

	public Long encontrarQuantidadeDeClubes() {
		return manager.createQuery("select count(c) from Agendamento c", Long.class).getSingleResult();
	}
}
package com.curso.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.jboss.logging.Logger;

import com.curso.modelo.Federacao;
import com.curso.util.NegocioException;
import com.curso.util.jpa.Transactional;

public class FederacaoDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Logger log = Logger.getLogger(FederacaoDAO.class);
	@Inject
	private EntityManager manager;
	
	
	@Transactional
	public void salvar(Federacao federacao) {
		log.info("Gravando federação");
		manager.merge(federacao);
	}
	
	@Transactional
	public void excluir(Federacao federacao) throws NegocioException {
		federacao = buscarPeloCodigo(federacao.getCodigo());
		try {
			manager.remove(federacao);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Esta federação não pode ser excluída.");
		}
	}
	
	
	
	/*
	 * Buscas
	 */	
	
	public Federacao buscarPeloCodigo(Long codigo) {
		return manager.find(Federacao.class, codigo);
	}
	
	@SuppressWarnings("unchecked")
	public List<Federacao> buscarTodos() {
		log.info("Buscando federação");
		log.error("Buscando todas as federações");
		return manager.createNamedQuery("Federacao.buscarTodos").getResultList();
	}
	
		
	@SuppressWarnings("unchecked")
	public List<Federacao> buscarComPaginacao(int first, int pageSize) {
		return manager.createNamedQuery("Federacao.buscarTodos")
							.setFirstResult(first)
							.setMaxResults(pageSize)
							.getResultList();
	}

	public Long encontrarQuantidadeDeFederacoes() {
		return manager.createQuery("select count(c) from Federacao c", Long.class).getSingleResult();
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	
		
	
}
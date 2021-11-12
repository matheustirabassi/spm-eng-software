package com.curso.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.hibernate.exception.ConstraintViolationException;
import org.jboss.logging.Logger;

import com.curso.modelo.Atleta;
import com.curso.util.NegocioException;
import com.curso.util.jpa.Transactional;

public class AtletaDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	private Logger log = Logger.getLogger(FederacaoDAO.class);
	@Transactional
	public void salvar(Atleta atleta) throws NegocioException {
		log.info("gravando atleta...");
		try {
			manager.merge(atleta);

		} catch (ConstraintViolationException e) {
			throw new NegocioException("Violação de restrição, provavelmente e-mail já existe.");
		}
	}
	
	@Transactional
	public void excluir(Atleta atleta) throws NegocioException {
		log.info("excluindo atleta...");
		atleta = buscarPeloCodigo(atleta.getCodigo());
		try {
			manager.remove(atleta);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Este atleta não pode ser excluído.");
		}
	}
	
	
	
	/*
	 * Buscas
	 */	
	
	public Atleta buscarPeloCodigo(Long codigo) {
		return manager.find(Atleta.class, codigo);
	}
	
	@SuppressWarnings("unchecked")
	public List<Atleta> buscarTodos() {
		return manager.createNamedQuery("Atleta.buscarTodos").getResultList();
	}	
		
	public Atleta buscarPeloEmail(String email) {
		return manager.createNamedQuery("Atleta.buscarPorEmail", Atleta.class)
				.setParameter("email", email)
				.getSingleResult();
	}	
	
	public List<Atleta> buscarPeloNome(String nome) {
		
		String jpql = "from Atleta a where a.nome LIKE :nome";		
		TypedQuery<Atleta> query = manager.createQuery(jpql, Atleta.class);		
		query.setParameter("nome", "%" + nome.toUpperCase() + "%");			
		return query.getResultList();		
	}	
		
	@SuppressWarnings("unchecked")
	public List<Atleta> buscarComPaginacao(int first, int pageSize) {
		return manager.createNamedQuery("Atleta.buscarTodos")
							.setFirstResult(first)
							.setMaxResults(pageSize)
							.getResultList();
	}

	public Long encontrarQuantidadeDeAtletas() {
		return manager.createQuery("select count(a) from Atleta a", Long.class).getSingleResult();
	}
}
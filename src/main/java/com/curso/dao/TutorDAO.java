package com.curso.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.hibernate.exception.ConstraintViolationException;
import org.jboss.logging.Logger;

import com.curso.modelo.Tutor;
import com.curso.util.NegocioException;
import com.curso.util.jpa.Transactional;

public class TutorDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	private Logger log = Logger.getLogger(FederacaoDAO.class);

	@Transactional
	public void save(Tutor tutor) throws NegocioException {
		log.info("gravando tutor...");
		try {
			manager.merge(tutor);

		} catch (ConstraintViolationException e) {
			throw new NegocioException("Violação de restrição, provavelmente e-mail já existe.");
		}
	}

	@Transactional
	public void delete(Tutor tutor) throws NegocioException {
		log.info("excluindo tutor...");
		tutor = findById(tutor.getCpf());
		try {
			manager.remove(tutor);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Este tutor não pode ser excluído.");
		}
	}

	public Tutor getTutor(String email, String senha) {

		try {
			log.info("Obtendo tutor..");
			return (Tutor) manager.createNamedQuery("Tutor.getTutor", Tutor.class).setParameter("email", email)
					.setParameter("senha", senha).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	public Tutor findById(Long id) {
		log.info("procurando por id do tutor...");
		return manager.find(Tutor.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Tutor> findAll() {
		log.info("procurando todos os tutors...");
		return manager.createNamedQuery("Tutor.findAll").getResultList();
	}

	public Tutor findByEmail(String email) {
		log.info("procurando o tutor por email...");
		return manager.createNamedQuery("Tutor.findByEmail", Tutor.class).setParameter("email", email)
				.getSingleResult();
	}

	public List<Tutor> findByName(String nome) {
		log.info("buscando tutor por nome...");
		String jpql = "from Tutor a where a.nome LIKE :nome";
		TypedQuery<Tutor> query = manager.createQuery(jpql, Tutor.class);
		query.setParameter("nome", "%" + nome.toUpperCase() + "%");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Tutor> buscarComPaginacao(int first, int pageSize) {
		log.info("buscando com paginação...");
		return manager.createNamedQuery("Tutor.findAll").setFirstResult(first).setMaxResults(pageSize).getResultList();
	}

	public Long encontrarQuantidadeDeTutores() {
		log.info("buscando a quantidade de tutores...");
		return manager.createQuery("select count(a) from Tutor a", Long.class).getSingleResult();
	}
}

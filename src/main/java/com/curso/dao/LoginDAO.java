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

import com.curso.modelo.Login;
import com.curso.util.NegocioException;
import com.curso.util.jpa.Transactional;

public class LoginDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	private Logger log = Logger.getLogger(FederacaoDAO.class);
	@Transactional
	public void save(Login login) throws NegocioException {
		log.info("gravando login...");
		try {
			manager.merge(login);

		} catch (ConstraintViolationException e) {
			throw new NegocioException("Violação de restrição, provavelmente e-mail já existe.");
		}
	}

	@Transactional
	public void delete(Login login) throws NegocioException {
		log.info("excluindo login...");
		login = findById(login.getId());
		try {
			manager.remove(login);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Este login não pode ser excluído.");
		}
	}

	public Login getLogin(String email, String senha) {

		try {
			log.info("Obtendo login..");
			Login login = (Login) manager.createNamedQuery("Login.getLogin", Login.class)
					.setParameter("email", email).setParameter("senha", senha).getSingleResult();

			return login;
		} catch (NoResultException e) {
			return null;
		}
	}

	public Login findById(Integer id) {
		log.info("procurando por id do login...");
		return manager.find(Login.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Login> findAll() {
		log.info("procurando todos os logins...");
		return manager.createNamedQuery("Login.findAll").getResultList();
	}

	public Login findByEmail(String email) {
		log.info("procurando o login por email...");
		return manager.createNamedQuery("Login.findByEmail", Login.class)
				.setParameter("email", email).getSingleResult();
	}

	public List<Login> findByName(String nome) {
		
		String jpql = "from Login a where a.nome LIKE :nome";
		TypedQuery<Login> query = manager.createQuery(jpql, Login.class);
		query.setParameter("nome", "%" + nome.toUpperCase() + "%");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Login> buscarComPaginacao(int first, int pageSize) {
		return manager.createNamedQuery("Login.findAll").setFirstResult(first).setMaxResults(pageSize)
				.getResultList();
	}

	public Long encontrarQuantidadeDeLogines() {
		return manager.createQuery("select count(a) from Login a", Long.class).getSingleResult();
	}
}

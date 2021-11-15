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

import com.curso.modelo.Administrador;
import com.curso.util.NegocioException;
import com.curso.util.jpa.Transactional;

public class AdministradorDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	private Logger log = Logger.getLogger(FederacaoDAO.class);
	@Transactional
	public void save(Administrador adm) throws NegocioException {
		log.info("gravando administrador...");
		try {
			manager.merge(adm);

		} catch (ConstraintViolationException e) {
			throw new NegocioException("Violação de restrição, provavelmente e-mail já existe.");
		}
	}

	@Transactional
	public void delete(Administrador adm) throws NegocioException {
		log.info("excluindo administrador...");
		adm = findById(adm.getId());
		try {
			manager.remove(adm);
			manager.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Este adm não pode ser excluído.");
		}
	}

	public Administrador getAdministrador(String email, String senha) {

		try {
			log.info("Obtendo administrador...");
			Administrador adm = (Administrador) manager.createNamedQuery("Administrador.getAdministrador", Administrador.class)
					.setParameter("email", email).setParameter("senha", senha).getSingleResult();

			return adm;
		} catch (NoResultException e) {
			return null;
		}
	}

	public Administrador findById(Integer id) {
		log.info("procurando por id do administrador...");
		return manager.find(Administrador.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Administrador> findAll() {
		log.info("procurando todos os administradores...");
		return manager.createNamedQuery("Administrador.findAll").getResultList();
	}

	public Administrador findByEmail(String email) {
		log.info("procurando o administrador por email...");
		return manager.createNamedQuery("Administrador.findByEmail", Administrador.class)
				.setParameter("email", email).getSingleResult();
	}

	public List<Administrador> findByName(String nome) {
		
		String jpql = "from Administrador a where a.nome LIKE :nome";
		TypedQuery<Administrador> query = manager.createQuery(jpql, Administrador.class);
		query.setParameter("nome", "%" + nome.toUpperCase() + "%");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Administrador> buscarComPaginacao(int first, int pageSize) {
		return manager.createNamedQuery("Administrador.findAll").setFirstResult(first).setMaxResults(pageSize)
				.getResultList();
	}

	public Long encontrarQuantidadeDeAdministradores() {
		return manager.createQuery("select count(a) from Administrador a", Long.class).getSingleResult();
	}
}

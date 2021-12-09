package com.curso.dao;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import org.hibernate.exception.ConstraintViolationException;
import com.curso.modelo.Login;
import com.curso.util.jpa.Transactional;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LoginDAO implements Serializable, GenericDAO<Login> {

  private static final long serialVersionUID = 1L;

  @Inject
  private EntityManager manager;

  @Override
  @Transactional
  public Login save(Login login) {
    try {
      log.info("gravando login...");
      manager.merge(login);

    } catch (ConstraintViolationException e) {
      e.getCause();
    }
    return login;
  }

  @Override
  @Transactional
  public void delete(Login login) {
    log.info("excluindo login...");
    login = findById(login.getId());
    try {
      manager.remove(login);
      manager.flush();
    } catch (PersistenceException e) {
      e.getCause();
    }
  }

  public Login getLogin(String email, String senha) {

    try {
      log.info("Obtendo login..");
      return manager.createNamedQuery("Login.getLogin", Login.class).setParameter("email", email)
          .setParameter("senha", senha).getSingleResult();
    } catch (NoResultException e) {
      return null;
    }
  }

  @Override
  public Login findById(Long id) {
    log.info("procurando por id do login...");
    return manager.find(Login.class, id);
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<Login> findAll() {
    log.info("procurando todos os logins...");
    return manager.createNamedQuery("Login.findAll").getResultList();
  }

  public Login findByEmail(String email) {
    log.info("procurando o login por email...");
    return manager.createNamedQuery("Login.findByEmail", Login.class).setParameter("email", email)
        .getSingleResult();
  }

  public List<Login> findByName(String nome) {

    String jpql = "from Login a where a.nome LIKE :nome";
    TypedQuery<Login> query = manager.createQuery(jpql, Login.class);
    query.setParameter("nome", "%" + nome.toUpperCase() + "%");
    return query.getResultList();
  }

  @SuppressWarnings("unchecked")
  public List<Login> findWithPagination(int first, int pageSize) {
    return manager.createNamedQuery("Login.findAll").setFirstResult(first).setMaxResults(pageSize)
        .getResultList();
  }

  public Long findNumberLogins() {
    return manager.createQuery("select count(a) from Login a", Long.class).getSingleResult();
  }

  @Override
  @Transactional
  public Login saveOrUpdate(Login t) {
    log.info("gravando login...");
    Login login = manager.merge(t);
    return login;
  }

  @Override
  public void saveOrUpdateAll(List<Login> t) {
    // TODO Auto-generated method stub

  }
}

package com.curso.dao;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import com.curso.modelo.Tutor;
import com.curso.util.jpa.Transactional;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class TutorDAO implements Serializable, GenericDAO<Tutor> {

  private static final long serialVersionUID = 1L;

  @Inject
  private EntityManager manager;


  @Transactional
  public Tutor save(Tutor tutor) {
    log.info("gravando tutor...");
    manager.merge(tutor);
    return tutor;
  }

  @Transactional
  public void delete(Tutor tutor) {
    log.info("excluindo tutor...");
    tutor = findById(tutor.getCpf());
    manager.remove(tutor);
    manager.flush();

  }

  public Tutor getTutor(String email, String senha) {

    try {
      log.info("Obtendo tutor..");
      return manager.createNamedQuery("Tutor.getTutor", Tutor.class).setParameter("email", email)
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
    log.info("procurando todos os tutores...");
    return manager.createNamedQuery("Tutor.buscarTodos").getResultList();
  }

  public Tutor findByEmail(String email) {
    log.info("procurando o tutor por email...");
    return manager.createNamedQuery("Tutor.buscarPorEmail", Tutor.class)
        .setParameter("email", email).getSingleResult();
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
    return manager.createNamedQuery("Tutor.buscarTodos").setFirstResult(first)
        .setMaxResults(pageSize).getResultList();
  }

  public Long encontrarQuantidadeDeTutores() {
    log.info("buscando a quantidade de tutores...");
    return manager.createQuery("select count(a) from Tutor a", Long.class).getSingleResult();
  }

  @Override
  public Tutor saveOrUpdate(Tutor t) {
    log.info("gravando tutor...");
    return manager.merge(t);
  }

  @Override
  public void saveOrUpdateAll(List<Tutor> t) {
    // TODO Auto-generated method stub

  }
}

package com.curso.dao;



import com.curso.modelo.BanhadorTosador;
import com.curso.util.jpa.Transactional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import lombok.extern.log4j.Log4j2;

/**
 * Classe de acesso a dados para BanhadorTosador.
 *
 */

@Log4j2
public class BanhadorTosadorDAO implements Serializable, GenericDAO<BanhadorTosador> {

  private static final long serialVersionUID = 1L;

  @Inject
  private EntityManager manager;

  @Override
  public BanhadorTosador findById(Long id) {
    log.info("procurando por id do banhador tosador...");
    return manager.find(BanhadorTosador.class, id);
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<BanhadorTosador> findAll() {
    log.info("procurando todos os tosadores...");
    return manager.createNamedQuery("BanhadorTosador.findAll").getResultList();
  }

  @Transactional
  @Override
  public BanhadorTosador save(BanhadorTosador t) {
    return manager.merge(t);
  }

  @Transactional
  @Override
  public BanhadorTosador saveOrUpdate(BanhadorTosador t) {
    return manager.merge(t);
  }

  @Override
  public void saveOrUpdateAll(List<BanhadorTosador> t) {
    // TODO Auto-generated method stub

  }

  @Transactional
  @Override
  public void delete(BanhadorTosador t) {
    log.info("excluindo login...");
    t = findById(t.getId());

    manager.remove(t);
    manager.flush();
  }

  @Transactional
  public BanhadorTosador findByEmail(String email) {
    log.info("procurando o tutor por email...");
    return manager.createNamedQuery("BanhadorTosador.findByEmail", BanhadorTosador.class)
        .setParameter("email", email).getSingleResult();
  }
}

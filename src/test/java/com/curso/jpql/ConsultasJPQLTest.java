package com.curso.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.curso.dao.FederacaoDAO;
import com.curso.modelo.Federacao;



public class ConsultasJPQLTest {
	
	private static EntityManagerFactory factory;	
	private EntityManager manager;
	private FederacaoDAO fedDAO;
	
	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("curso_PU");
	}
	
	@Before
	public void setUp() {
		this.manager = factory.createEntityManager();
		fedDAO = new FederacaoDAO();
		fedDAO.setManager(manager);
	}
	
	@After
	public void tearDown() {
		this.manager.close();
	}
	
	@Test
	public void consultaJPQL1() {
		
		Federacao fed = fedDAO.buscarPeloCodigo(1L);
		
		System.out.println("federacao =  " + fed.getNome());
		
	}
	
		
	@Test
	public void consultaJPQL() {
		
		
		Long qde = manager.createQuery("SELECT codigo, count(codigo), FROM Federacao "
				+ "WHERE codigo = :id", Long.class)
			.setParameter("id", 1)				
			.getSingleResult();

		
		System.out.println("Qde =  " + qde.intValue());
		
	}
	
	
}

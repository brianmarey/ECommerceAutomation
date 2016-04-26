package com.careydevelopment.ecommerceautomation.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.careydevelopment.ecommerceautomation.dao.CategoryDao;
import com.careydevelopment.ecommerceautomation.entity.Category;

public class EcommerceService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EcommerceService.class);
	
	EntityManager em;
	
	public EcommerceService() {
		EntityManagerFactory emf = PersistenceSingleton.getEntityManagerFactory();
        em = emf.createEntityManager();
	}
	
	
	public Category fetchCategory(String categoryName) throws EcommerceServiceException {
		em.getTransaction().begin();
		
		try {
			CategoryDao dao = new CategoryDao(em);
			Category cat = dao.fetchCategory(categoryName);
			em.getTransaction().commit();
			return cat;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new EcommerceServiceException(e);
		} finally {
			close();
		}
	}
	
	
	public void save (Object o) throws EcommerceServiceException {
		em.getTransaction().begin();
		
		try {
			em.persist(o);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new EcommerceServiceException(e);
		} finally {
			close();
		}		
	}
	
	private void close() {
		if (em.isOpen()) em.close();
		//if (emf.isOpen()) emf.close();
	}
}

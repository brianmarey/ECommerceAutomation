package com.careydevelopment.ecommerceautomation.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.careydevelopment.ecommerceautomation.entity.Attribute;
import com.careydevelopment.ecommerceautomation.entity.AttributeValue;

public class AttributeService extends AbstractJPAPersistenceService<Long, Attribute> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AttributeService.class);
	
	public AttributeService() {
		EntityManagerFactory emf = PersistenceSingleton.getEntityManagerFactory();
        em = emf.createEntityManager();
	}
	

	/*public Category fetchCategory(String categoryName) throws EcommerceServiceException {
		em.getTransaction().begin();
		
		try {
			Query query = em.createQuery("select c from Category c where c.name = :name");
			query.setParameter("name", categoryName);
			Category cat = (Category)query.getSingleResult();
			em.getTransaction().commit();
			return cat;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new EcommerceServiceException(e);
		} finally {
			close();
		}
	}*/
	
	
	public Attribute findAttribute(Attribute att) throws EcommerceServiceException {
		LOGGER.info("looking for att " + att.getName());
		
		try {
			att = fetchOrCreateAttribute(att);
			return att;
		} catch (Exception e) {
			throw new EcommerceServiceException(e);
		} finally {
			close();
		}
	}
	
	
	private Attribute fetchOrCreateAttribute(Attribute att) {
		Query query = em.createQuery("select a from Attribute a where a.name = :name");
		query.setParameter("name", att.getName());
		
		try {
			att = (Attribute)query.getSingleResult();
		} catch (NoResultException e) {
			LOGGER.info(att.getName() + "ATTRIBUTE not found in db - adding it");
			att = createAttribute(att);
		} 
		
		return att;
	}
	
	
	private Attribute createAttribute(Attribute att) {
		save(att);
		return att;
	}
	
	
	private void close() {
		if (em.isOpen()) em.close();
		//if (emf.isOpen()) emf.close();
	}
}

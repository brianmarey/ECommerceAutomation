package com.careydevelopment.ecommerceautomation.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.careydevelopment.ecommerceautomation.entity.AttributeValue;

public class AttributeValueService extends AbstractJPAPersistenceService<Long, AttributeValue> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AttributeValueService.class);
	
	public AttributeValueService() {
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
	
	
	public AttributeValue findAttributeValue(AttributeValue val) throws EcommerceServiceException {
		LOGGER.info("Looking for att " + val.getAttribute().getName() + " with val " + val.getName());

		em.getTransaction().begin();
		try {
			val = fetchOrCreateAttributeValue(val);
			em.getTransaction().commit();
			return val;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new EcommerceServiceException(e);
		} finally {
			close();
		}
	}

	
	public List<AttributeValue> fetchAllAttributeValuesByName(String name)  {
		LOGGER.info("Looking for all attributes with name " + name);
		
		Query query = em.createQuery("select av from AttributeValue av where av.attribute.name = :name");
		query.setParameter("name", name);
		
		List<AttributeValue> list = new ArrayList<AttributeValue>();
		
		try {
			list = (List<AttributeValue>)query.getResultList();
		} catch (Exception e) {
			LOGGER.error("Problem retrieving attributes for " + name, e);
		} finally {
			close();
		}
		
		return list;
	}
	
	
	private AttributeValue fetchOrCreateAttributeValue(AttributeValue val) throws EcommerceServiceException {
		LOGGER.info("Looking for att value with name " + val.getAttribute().getName() + " and val " + val.getName());
		
		Query query = em.createQuery("select av from AttributeValue av where av.attribute.name = :name and av.name = :value ");
		query.setParameter("name", val.getAttribute().getName());
		query.setParameter("value", val.getName());
		
		try {
			val = (AttributeValue)query.getSingleResult();
		} catch (NoResultException e) {
			LOGGER.info(val.getName() + " not found in db - adding it");
			val = createAttributeValue(val);
		} 
		
		return val;
	}
	
	
	private AttributeValue createAttributeValue(AttributeValue val) throws EcommerceServiceException {
		AttributeService attService = new AttributeService();
		val.setAttribute(attService.findAttribute(val.getAttribute()));
		
		save(val);
		
		return val;
	}
	
	
	private void close() {
		if (em.isOpen()) em.close();
		//if (emf.isOpen()) emf.close();
	}
}

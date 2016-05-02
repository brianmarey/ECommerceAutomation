package com.careydevelopment.ecommerceautomation.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.careydevelopment.ecommerceautomation.entity.Category;
import com.careydevelopment.ecommerceautomation.util.SlugMaker;

public class CategoryPersistenceService extends AbstractJPAPersistenceService<Long, Category> {

	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryPersistenceService.class);
	
	public CategoryPersistenceService() {
		EntityManagerFactory emf = PersistenceSingleton.getEntityManagerFactory();
        em = emf.createEntityManager();
	}
	

	public Category fetchCategory(String categoryName) throws EcommerceServiceException {
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
	}
	
	
	public Category findCategory(Category category) throws EcommerceServiceException {
		em.getTransaction().begin();
		
		try {
			Category cat = fetchOrCreateCategory(category);
			em.getTransaction().commit();
			return cat;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new EcommerceServiceException(e);
		} finally {
			close();
		}
	}
	
	
	private Category fetchOrCreateCategory(Category category) {
		LOGGER.info("Looking for category " + category.getName());
		
		Query query = em.createQuery("select c from Category c where c.name = :name");
		query.setParameter("name", category.getName());
		
		try {
			category = (Category)query.getSingleResult();
			return category;
		} catch (NoResultException e) {
			LOGGER.info(category.getName() + " not found in db - adding it");
			category = createCategory(category);
		} 
		
		return category;
	}
	
	
	private Category createCategory(Category category) {
		Category parent = category.getParent();
		category.setSlug(SlugMaker.makeSlug(category.getName()));
		
		if (parent == null) {
			category = save(category);
		} else {
			parent = fetchOrCreateCategory(parent);
			category.setParent(parent);
			category = save(category);
		}
		
		LOGGER.info("just saved " + category.getName() + " " + category.getId());
		
		
		return category;
	}
	
	
	private void close() {
		if (em.isOpen()) em.close();
		//if (emf.isOpen()) emf.close();
	}
}

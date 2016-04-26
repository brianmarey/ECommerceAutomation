package com.careydevelopment.ecommerceautomation.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.careydevelopment.ecommerceautomation.entity.Category;
import com.careydevelopment.ecommerceautomation.entity.Product;

public class ProductPersistenceService extends AbstractJPAPersistenceService<Long, Product> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductPersistenceService.class);
	
	public ProductPersistenceService() {
		EntityManagerFactory emf = PersistenceSingleton.getEntityManagerFactory();
        em = emf.createEntityManager();
	}
	
	
	public Product fetchById(long id) {
		Query query = em.createQuery("select p from Product p where p.id = :id");
		query.setParameter("id", id);
		return (Product)query.getSingleResult();
	}
	
	
	private Product fetchProductBySku(String sku) {
		Query query = em.createQuery("select p from Product p where p.sku = :sku");
		query.setParameter("sku", sku);
		Product prod = (Product)query.getSingleResult();
		return prod;
	}
	
	
	public void saveProduct(Product prod) throws EcommerceServiceException {
		em.getTransaction().begin();
		
		try {
			prod = fetchProductBySku(prod.getSku());
			update(prod);
			em.getTransaction().commit();
		} catch (NoResultException ne) {
			saveNewProduct(prod);
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new EcommerceServiceException(e);
		} finally {
			close();
		}
	}
	
	
	private void saveNewProduct (Product prod) throws EcommerceServiceException {
		CategoryPersistenceService catService = new CategoryPersistenceService();		
		prod.setAdvertiserCategory(catService.findCategory(prod.getAdvertiserCategory()));
		
		save(prod);
		
		em.getTransaction().commit();
	}
	
	
	private void close() {
		if (em.isOpen()) em.close();
		//if (emf.isOpen()) emf.close();
	}
}

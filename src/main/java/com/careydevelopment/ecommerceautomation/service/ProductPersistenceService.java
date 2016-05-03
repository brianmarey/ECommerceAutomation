package com.careydevelopment.ecommerceautomation.service;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.careydevelopment.ecommerceautomation.entity.Category;
import com.careydevelopment.ecommerceautomation.entity.Product;
import com.careydevelopment.ecommerceautomation.util.CategoryHelper;

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

	
	public List<String> fetchSkusByVendor(String vendor) {
		Query query = em.createQuery("select p.sku from Product p where p.vendor = :vendor");
		query.setParameter("vendor", vendor);
		
		List<String> skus = (List<String>)query.getResultList();
		
		return skus;
	}
	
	
	public void delete(String vendor, String sku) {
		Query query = em.createQuery("select p from Product p where p.vendor = :vendor and p.sku = :sku");
		query.setParameter("vendor", vendor);
		query.setParameter("sku", sku);
		
		try {
			Product product = (Product)query.getSingleResult();
			em.remove(product);
		} catch (Exception e) {
			LOGGER.warn("Problem deleting product with sku " + sku);
		}
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
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new EcommerceServiceException(e);
		} finally {
			close();
		}
	}
	
	
	private void saveNewProduct (Product prod) throws EcommerceServiceException {
		if (prod.getAdvertiserCategory().getId() == null || prod.getAdvertiserCategory().getId() < 1) {
			CategoryPersistenceService catService = new CategoryPersistenceService();	
			Category persistedCategory = catService.findCategory(prod.getAdvertiserCategory());				
			prod.setAdvertiserCategory(persistedCategory);
		}
			
		save(prod);
	}	
	
	
	private void close() {
		if (em.isOpen()) em.close();
		//if (emf.isOpen()) emf.close();
	}
}

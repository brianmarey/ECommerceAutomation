package com.careydevelopment.ecommerceautomation.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.careydevelopment.ecommerceautomation.entity.Category;

public class CategoryDao {
	
	private EntityManager em;
	
	public CategoryDao(EntityManager em) {
		this.em = em;
	}

	public Category fetchCategory (String categoryName) {
		Query query = em.createQuery("select c from Category c where c.name = :name");
		query.setParameter("name", categoryName);
		
		Category cat = (Category)query.getSingleResult();
		
		return cat;
	}
}

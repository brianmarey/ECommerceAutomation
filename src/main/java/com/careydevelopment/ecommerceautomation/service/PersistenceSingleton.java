package com.careydevelopment.ecommerceautomation.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceSingleton {

	private static EntityManagerFactory emf;
	
	private PersistenceSingleton(){}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("EcommerceService");			
		}
		
		return emf;
	}
}

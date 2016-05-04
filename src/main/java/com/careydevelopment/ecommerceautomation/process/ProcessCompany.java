package com.careydevelopment.ecommerceautomation.process;

import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.careydevelopment.ecommerceautomation.company.Companies;
import com.careydevelopment.ecommerceautomation.company.Company;
import com.careydevelopment.ecommerceautomation.service.PersistenceSingleton;
import com.careydevelopment.ecommerceautomation.util.AttributeHelper;

public class ProcessCompany {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessCompany.class);

	public static void main(String[] args) {
		//LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		// print logback's internal status
		//StatusPrinter.print(lc);
		
		ProcessCompany pc = new ProcessCompany();
		pc.go();
		
		
		/*
		ProductPersistenceService serv = new ProductPersistenceService();
		Product p = serv.fetchById(6l);
		LOGGER.info(p.getName());
		LOGGER.info(p.getBuyUrl());
		LOGGER.info(p.getCatalogName());
		LOGGER.info(p.getDescription());
		LOGGER.info(p.getImageUrl());
		LOGGER.info(p.getImpressionUrl());
		LOGGER.info(p.getInStock());
		LOGGER.info(p.getLowestOfferPrice());
		LOGGER.info(p.getManufacturerId());
		LOGGER.info(p.getPrice());
		LOGGER.info(p.getProgramName());
		LOGGER.info(p.getProgramUrl());
		LOGGER.info(p.getRetailPrice());
		LOGGER.info(p.getSku());
		LOGGER.info(p.getUpc());
		LOGGER.info(p.getVendor());
		LOGGER.info(p.getAdvertiserCategory().getName());
		*/
		
		/*EntityManagerFactory emf = Persistence.createEntityManagerFactory("EcommerceService");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        try {
        Category cat = new Category();
        cat.setName("MEN");
        em.persist(cat);
        em.getTransaction().commit();
        
        System.err.println("done");
        } catch (Exception e) {
        	e.printStackTrace();
        	em.getTransaction().rollback();
        }
        
        em.close();
        emf.close();*/
		
		/*
		try {
			//CategoryPersistenceService service = new CategoryPersistenceService();
			//Category cat = service.fetchCategory("Men'sxxx Shirts");
			//LOGGER.info("Cat is " + cat.getName());
			
			
			Category shirts = new Category();
			shirts.setName("Men's Polo Shirts");
			shirts.setParent(cat);
			service = new EcommerceService();
			service.save(shirts);
			
			Category men = new Category("Men");
			Category mensShirts = new Category("Men's Shirts");
			Category mensPoloShirts = new Category("Men's Polo Shirts");
			
			mensShirts.setParent(men);
			mensPoloShirts.setParent(mensShirts);
			
			CategoryPersistenceService service = new CategoryPersistenceService();
			Category cat = service.findCategory(mensPoloShirts);
			
			LOGGER.info("CAT is " + cat.getName());
		} catch (EcommerceServiceException e) {
			e.printStackTrace();
		} finally {
			EntityManagerFactory emf = PersistenceSingleton.getEntityManagerFactory();
			emf.close();
		}*/
	}

	
	private void go() {
		try {			
			populateAttributes();
			process();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			EntityManagerFactory emf = PersistenceSingleton.getEntityManagerFactory();
			if (!emf.isOpen()) emf.close();
		}
		
		LOGGER.info("Finished with everything");
		System.exit(0);
	}
	
	
	private void populateAttributes() {
		AttributeHelper helper = AttributeHelper.getInstance();
		helper.populateMap(ProductAttributes.COLOR);
		helper.populateMap(ProductAttributes.SIZE);
		helper.populateMap(ProductAttributes.INSEAM);
	}
	
	
	private void process() {
		Company company = Companies.EBAY;
		CompanyProcessor processor = ProcessorFactory.getProcessor(company);
		processor.process();
	}	
}

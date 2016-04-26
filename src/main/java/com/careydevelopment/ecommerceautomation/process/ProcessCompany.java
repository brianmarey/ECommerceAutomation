package com.careydevelopment.ecommerceautomation.process;

import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.careydevelopment.ecommerceautomation.entity.Category;
import com.careydevelopment.ecommerceautomation.service.EcommerceService;
import com.careydevelopment.ecommerceautomation.service.EcommerceServiceException;
import com.careydevelopment.ecommerceautomation.service.PersistenceSingleton;

public class ProcessCompany {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessCompany.class);

	public static void main(String[] args) {
		  //LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		  // print logback's internal status
		  //StatusPrinter.print(lc);
		
		/*Company company = Companies.AMAZON;
		CompanyProcessor processor = ProcessorFactory.getProcessor(company);
		processor.process();*/
		
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
		
		try {
			EcommerceService service = new EcommerceService();
			Category cat = service.fetchCategory("Men's Shirts");
			LOGGER.info("Cat is " + cat.getName());
			
			
			Category shirts = new Category();
			shirts.setName("Men's Polo Shirts");
			shirts.setParent(cat);
			service = new EcommerceService();
			service.save(shirts);
			
		} catch (EcommerceServiceException e) {
			e.printStackTrace();
		} finally {
			EntityManagerFactory emf = PersistenceSingleton.getEntityManagerFactory();
			emf.close();
		}
	}

}

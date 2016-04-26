package com.careydevelopment.ecommerceautomation.process;

import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.careydevelopment.ecommerceautomation.entity.Category;
import com.careydevelopment.ecommerceautomation.service.CategoryPersistenceService;
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
			//CategoryPersistenceService service = new CategoryPersistenceService();
			//Category cat = service.fetchCategory("Men'sxxx Shirts");
			//LOGGER.info("Cat is " + cat.getName());
			
			
			/*Category shirts = new Category();
			shirts.setName("Men's Polo Shirts");
			shirts.setParent(cat);
			service = new EcommerceService();
			service.save(shirts);*/
			
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
		}
	}

}

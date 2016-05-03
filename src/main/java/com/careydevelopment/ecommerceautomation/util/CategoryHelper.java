package com.careydevelopment.ecommerceautomation.util;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.careydevelopment.ecommerceautomation.entity.Category;
import com.careydevelopment.ecommerceautomation.service.CategoryPersistenceService;

public class CategoryHelper {
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryHelper.class);
	
	private static CategoryHelper INSTANCE;
	
	private List<Category> categories = new ArrayList<Category>();
	
	private CategoryHelper() {
		CategoryPersistenceService service = new CategoryPersistenceService();
		categories = service.findAllCategories();
	}
	
	public static CategoryHelper getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new CategoryHelper();
		}
		
		return INSTANCE;
	}
	
	
	public Category getCategory(String categoryName) {
		Category category = new Category();
		category.setName(categoryName);
		
		for (Category cat: categories) {
			if (cat.getName().equals(categoryName)) {
				category = cat;
				break;
			}
		}
		
		return category;
	}
	
	public Category getCategory(String categoryName, Category parent) {
		Category category = new Category();
		category.setName(categoryName);
		category.setParent(parent);
		
		for (Category cat: categories) {
			if (cat.getName().equals(categoryName)) {
				category = cat;
				break;
			}
		}
		
		return category;
	}
}

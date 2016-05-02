package com.careydevelopment.ecommerceautomation.entity;

public class Categories {

	public static final Category MEN = new Category("Men");
	public static final Category MENS_SHIRTS = new Category("Men's Shirts", MEN);
	public static final Category MENS_POLO_SHIRTS = new Category("Men's Polo Shirts", MENS_SHIRTS);
	public static final Category MENS_CASUAL_SHIRTS = new Category("Men's Casual Shirts", MENS_SHIRTS);
	public static final Category MENS_HENLEY_SHIRTS = new Category("Men's Henley Shirts", MENS_SHIRTS);
	public static final Category MENS_DRESS_SHIRTS = new Category("Men's Dress Shirts", MENS_SHIRTS);
}

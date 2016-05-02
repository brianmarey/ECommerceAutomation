package com.careydevelopment.ecommerceautomation.entity;

public class Categories {

	public static final Category MEN = new Category("Men");
	public static final Category MENS_SHIRTS = new Category("Men's Shirts", MEN);
	public static final Category MENS_POLO_SHIRTS = new Category("Men's Polo Shirts", MENS_SHIRTS);
	public static final Category MENS_CASUAL_SHIRTS = new Category("Men's Casual Shirts", MENS_SHIRTS);
	public static final Category MENS_HENLEY_SHIRTS = new Category("Men's Henley Shirts", MENS_SHIRTS);
	public static final Category MENS_DRESS_SHIRTS = new Category("Men's Dress Shirts", MENS_SHIRTS);
	
	public static final Category WOMEN = new Category("Women");
	public static final Category WOMEN_TOPS = new Category("Women's Tops",WOMEN);
	public static final Category WOMEN_TOPS_HENLEY = new Category("Women's Henleys",WOMEN_TOPS);
	public static final Category WOMEN_TOPS_POLOS = new Category("Women's Polos",WOMEN_TOPS);
	public static final Category WOMEN_TOPS_TEES = new Category("Women's Tees",WOMEN_TOPS);
	public static final Category WOMEN_TOPS_BLOUSES = new Category("Women's Henleys",WOMEN_TOPS);
	public static final Category WOMEN_JEANS = new Category("Women's Jeans",WOMEN);
	public static final Category WOMEN_JEANS_BOOTCUT = new Category("Women's Bootcut Jeans",WOMEN_JEANS);
	public static final Category WOMEN_JEANS_ANKLE = new Category("Women's Ankle Jeans",WOMEN_JEANS);
	public static final Category WOMEN_JEANS_BOYFRIEND = new Category("Women's Bofriend Jeans",WOMEN_JEANS);
	public static final Category WOMEN_JEANS_SKINNY = new Category("Women's Skinny Jeans",WOMEN_JEANS);
	public static final Category WOMEN_JEANS_STRAIGHT = new Category("Women's Straight Jeans",WOMEN_JEANS);
	public static final Category WOMEN_PANTS = new Category("Women's Pants",WOMEN);
	public static final Category WOMEN_PANTS_WORK = new Category("Women's Work Pants",WOMEN_PANTS);
	public static final Category WOMEN_PANTS_NIGHT_OUT = new Category("Women's Night Out Pants",WOMEN_PANTS);
	public static final Category WOMEN_PANTS_CASUAL = new Category("Women's Casual Pants",WOMEN_PANTS);
}

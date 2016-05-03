package com.careydevelopment.ecommerceautomation.entity;

import com.careydevelopment.ecommerceautomation.util.CategoryHelper;

public class Categories {

	public static final Category MEN = CategoryHelper.getInstance().getCategory("Men");
	public static final Category MENS_SHIRTS = CategoryHelper.getInstance().getCategory("Men's Shirts",MEN);
	public static final Category MENS_POLO_SHIRTS = CategoryHelper.getInstance().getCategory("Men's Polo Shirts", MENS_SHIRTS);
	public static final Category MENS_CASUAL_SHIRTS = CategoryHelper.getInstance().getCategory("Men's Casual Shirts", MENS_SHIRTS);
	public static final Category MENS_HENLEY_SHIRTS = CategoryHelper.getInstance().getCategory("Men's Henley Shirts", MENS_SHIRTS);
	public static final Category MENS_DRESS_SHIRTS = CategoryHelper.getInstance().getCategory("Men's Dress Shirts", MENS_SHIRTS);
	
	public static final Category WOMEN = CategoryHelper.getInstance().getCategory("Women");
	public static final Category WOMEN_TOPS = CategoryHelper.getInstance().getCategory("Women's Tops",WOMEN);
	public static final Category WOMEN_TOPS_HENLEY = CategoryHelper.getInstance().getCategory("Women's Henleys",WOMEN_TOPS);
	public static final Category WOMEN_TOPS_POLOS = CategoryHelper.getInstance().getCategory("Women's Polos",WOMEN_TOPS);
	public static final Category WOMEN_TOPS_TEES = CategoryHelper.getInstance().getCategory("Women's Tees",WOMEN_TOPS);
	public static final Category WOMEN_TOPS_BLOUSES = CategoryHelper.getInstance().getCategory("Women's Henleys",WOMEN_TOPS);
	public static final Category WOMEN_JEANS = CategoryHelper.getInstance().getCategory("Women's Jeans",WOMEN);
	public static final Category WOMEN_JEANS_BOOTCUT = CategoryHelper.getInstance().getCategory("Women's Bootcut Jeans",WOMEN_JEANS);
	public static final Category WOMEN_JEANS_ANKLE = CategoryHelper.getInstance().getCategory("Women's Ankle Jeans",WOMEN_JEANS);
	public static final Category WOMEN_JEANS_BOYFRIEND = CategoryHelper.getInstance().getCategory("Women's Bofriend Jeans",WOMEN_JEANS);
	public static final Category WOMEN_JEANS_SKINNY = CategoryHelper.getInstance().getCategory("Women's Skinny Jeans",WOMEN_JEANS);
	public static final Category WOMEN_JEANS_STRAIGHT = CategoryHelper.getInstance().getCategory("Women's Straight Jeans",WOMEN_JEANS);
	public static final Category WOMEN_PANTS = CategoryHelper.getInstance().getCategory("Women's Pants",WOMEN);
	public static final Category WOMEN_PANTS_WORK = CategoryHelper.getInstance().getCategory("Women's Work Pants",WOMEN_PANTS);
	public static final Category WOMEN_PANTS_NIGHT_OUT = CategoryHelper.getInstance().getCategory("Women's Night Out Pants",WOMEN_PANTS);
	public static final Category WOMEN_PANTS_CASUAL = CategoryHelper.getInstance().getCategory("Women's Casual Pants",WOMEN_PANTS);
}

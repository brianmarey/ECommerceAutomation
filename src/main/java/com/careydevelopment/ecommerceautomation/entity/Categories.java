package com.careydevelopment.ecommerceautomation.entity;

import com.careydevelopment.ecommerceautomation.util.CategoryHelper;

public class Categories {

	public static final Category MEN = CategoryHelper.getInstance().getCategory("Men");
	public static final Category MENS_SHIRTS = CategoryHelper.getInstance().getCategory("Men's Shirts",MEN);
	public static final Category MENS_POLO_SHIRTS = CategoryHelper.getInstance().getCategory("Men's Polo Shirts", MENS_SHIRTS);
	public static final Category MENS_CASUAL_SHIRTS = CategoryHelper.getInstance().getCategory("Men's Casual Shirts", MENS_SHIRTS);
	public static final Category MENS_HENLEY_SHIRTS = CategoryHelper.getInstance().getCategory("Men's Henley Shirts", MENS_SHIRTS);
	public static final Category MENS_DRESS_SHIRTS = CategoryHelper.getInstance().getCategory("Men's Dress Shirts", MENS_SHIRTS);
	public static final Category MENS_JEANS = CategoryHelper.getInstance().getCategory("Men's Jeans", MEN);
	public static final Category MENS_RELAXED_JEANS = CategoryHelper.getInstance().getCategory("Men's Relaxed Jeans", MENS_JEANS);
	public static final Category MENS_STRAIGHT_JEANS = CategoryHelper.getInstance().getCategory("Men's Straight Jeans", MENS_JEANS);
	public static final Category MENS_SKINNY_JEANS = CategoryHelper.getInstance().getCategory("Men's Skinny Jeans", MENS_JEANS);
	public static final Category MENS_SLIM_JEANS = CategoryHelper.getInstance().getCategory("Men's Slim Jeans", MENS_JEANS);
	public static final Category MENS_PANTS = CategoryHelper.getInstance().getCategory("Men's Pants", MEN);
	public static final Category MENS_CASUAL_PANTS = CategoryHelper.getInstance().getCategory("Men's Casual Pants", MENS_PANTS);
	public static final Category MENS_DRESS_PANTS = CategoryHelper.getInstance().getCategory("Men's Dress Pants", MENS_PANTS);
	public static final Category MENS_SHORTS = CategoryHelper.getInstance().getCategory("Men's Shorts", MEN);
	public static final Category MENS_CARGO_SHORTS = CategoryHelper.getInstance().getCategory("Men's Cargo Shorts", MENS_SHORTS);
	public static final Category MENS_DENIM_SHORTS = CategoryHelper.getInstance().getCategory("Men's Denim Shorts", MENS_SHORTS);
	public static final Category MENS_PLEATED_SHORTS = CategoryHelper.getInstance().getCategory("Men's Pleated Shorts", MENS_SHORTS);
	public static final Category MENS_FLAT_FRONT_SHORTS = CategoryHelper.getInstance().getCategory("Men's Flat Front Shorts", MENS_SHORTS);

	
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
	public static final Category WOMEN_PANTS_CAPRIS = CategoryHelper.getInstance().getCategory("Women's Capris",WOMEN_PANTS);
	public static final Category WOMEN_PANTS_NIGHT_OUT = CategoryHelper.getInstance().getCategory("Women's Night Out Pants",WOMEN_PANTS);
	public static final Category WOMEN_PANTS_CASUAL = CategoryHelper.getInstance().getCategory("Women's Casual Pants",WOMEN_PANTS);
	public static final Category WOMENS_DRESSES = CategoryHelper.getInstance().getCategory("Women's Dresses",WOMEN);
	public static final Category WOMENS_CASUAL_DRESSES = CategoryHelper.getInstance().getCategory("Women's Casual Dresses",WOMENS_DRESSES);
	public static final Category WOMENS_NIGHT_OUT_DRESSES = CategoryHelper.getInstance().getCategory("Women's Night Out Dresses",WOMENS_DRESSES);
	public static final Category WOMENS_WEAR_TO_WORK_DRESSES = CategoryHelper.getInstance().getCategory("Women's Wear to Work Dresses",WOMENS_DRESSES);
	public static final Category WOMENS_SHORTS = CategoryHelper.getInstance().getCategory("Women's Shorts",WOMEN);
	public static final Category WOMENS_CASUAL_SHORTS = CategoryHelper.getInstance().getCategory("Women's Casual Shorts",WOMENS_SHORTS);
	public static final Category WOMENS_DRESS_SHORTS = CategoryHelper.getInstance().getCategory("Women's Dress Shorts",WOMENS_SHORTS);
	public static final Category WOMENS_DENIM_SHORTS = CategoryHelper.getInstance().getCategory("Women's Denim Shorts",WOMENS_SHORTS);

}

package com.careydevelopment.ecommerceautomation.category;

import com.careydevelopment.ecommerceautomation.util.Node;

public class Categories {

	public static final Node<String> MEN = new Node<String>("Men");
	public static final Node<String> MENS_SHIRTS = new Node<String>("Men's Shirts",MEN);
	public static final Node<String> MENS_POLO_SHIRTS = new Node<String>("Men's Polo Shirts",MENS_SHIRTS);

}

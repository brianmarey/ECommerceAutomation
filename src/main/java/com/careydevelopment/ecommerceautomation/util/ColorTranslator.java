package com.careydevelopment.ecommerceautomation.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ColorTranslator {

	private static final Logger LOGGER = LoggerFactory.getLogger(ColorTranslator.class);
	
	public static final String getColor(String color) {
		String returnValue = null;
		String originalColor = color;
		
		//System.err.println("translationg color " + color);
		
		if (color != null) {
			color = color.trim();
			color = color.toLowerCase();
			color = Character.toUpperCase(color.charAt(0)) + color.substring(1);
			
			if (color.equals("Black") || color.equals("White") || color.equals("Pink") || color.equals("Brown") || color.equals("Beige") || color.equals("Blue")
				 || color.equals("Red") || color.equals("Green") || color.equals("Yellow")  || color.equals("Purple") || color.equals("Gray") 
				 || color.equals("Orange") || color.equals("Gold") || color.equals("Multi")) {
				
				return color;
					 
			}
			
			if (color.equals("Ivory")) {
				return "White";
			}
			
			if (color.equals("Indigo")) {
				return "Purple";
			}
			
			if (color.equals("Wheat")) {
				return "Beige";
			}
			
			if (color.equals("Charcoal")) {
				return "Gray";
			}
			
			if (color.equals("Violet")) {
				return "Purple";
			}
			
			if (color.equals("Tan")) {
				return "Beige";
			}
			
			if (color.equals("Champagne")) {
				return "Beige";
			}
			
			if (color.equals("Anthracite")) {
				return "Gray";
			}
			
			if (color.equals("Turqoise")) {
				return "Blue";
			}
			
			if (color.equals("Copper")) {
				return "Orange";
			}
			
			if (color.equals("Cabernet")) {
				return "Red";
			}
			
			if (color.equals("Pecan")) {
				return "Brown";
			}
			
			if (color.equals("Royal")) {
				return "Blue";
			}
			
			if (color.equals("Fern")) {
				return "Green";
			}
			
			if (color.equals("Blush")) {
				return "Pink";
			}
			
			if (color.equals("Sapphire")) {
				return "Red";
			}
			
			if (color.equals("Coral")) {
				return "Orange";
			}
			
			if (color.equals("Brick")) {
				return "Red";
			}
			
			if (color.equals("Nectar")) {
				return "Pink";
			}
			
			if (color.equals("Alabaster")) {
				return "Pink";
			}
			
			if (color.equals("Merlot")) {
				return "Red";
			}
			
			if (color.equals("Onyx")) {
				return "Black";
			}
			
			if (color.equals("Toffee")) {
				return "Brown";
			}
			
			if (color.equals("Dahlia")) {
				return "Red";
			}
			
			if (color.equals("Tangerine")) {
				return "Orange";
			}
			
			if (color.equals("Espresso")) {
				return "Brown";
			}
			
			if (color.equals("Dove")) {
				return "Gray";
			}
			
			if (color.equals("Camellia")) {
				return "Pink";
			}
			
			if (color.equals("Eggshell")) {
				return "White";
			}
			
			if (color.equals("Cayenne")) {
				return "Red";
			}
			
			if (color.equals("Chartreuse")) {
				return "Yellow";
			}
			
			if (color.equals("Twilight")) {
				return "Blue";
			}
			
			if (color.equals("Juniper")) {
				return "Blue";
			}
			
			if (color.equals("Vanilla")) {
				return "Beige";
			}
			
			if (color.equals("Steel")) {
				return "Gray";
			}
			
			if (color.equals("Sky")) {
				return "Blue";
			}
			
			if (color.equals("Jade")) {
				return "Green";
			}
			
			if (color.equals("Salmon")) {
				return "Orange";
			}
			
			if (color.equals("Rust")) {
				return "Orange";
			}
			
			if (color.equals("Khaki") || color.equals("Kahki")) {
				return "Beige";
			}
			
			if (color.equals("Prairie")) {
				return "Beige";
			}
			
			if (color.equals("Coffee")) {
				return "Brown";
			}
			
			if (color.equals("Sedona sage")) {
				return "Gray";
			}
			
			if (color.equals("Eggplant")) {
				return "Purple";
			}
			
			if (color.equals("Azalea")) {
				return "Pink";
			}
			
			if (color.equals("Slate")) {
				return "Gray";
			}
			
			if (color.equals("Cashew")) {
				return "Beige";
			}
			
			if (color.equals("Aqua")) {
				return "Blue";
			}
			
			if (color.equals("Azure")) {
				return "Blue";
			}
			
			if (color.equals("Clear Sky")) {
				return "Blue";
			}
			
			if (color.equals("Maroon")) {
				return "Red";
			}
			
			if (color.equals("Avocado")) {
				return "Green";
			}
			
			if (color.equals("Grape")) {
				return "Purple";
			}
			
			if (color.equals("Wine")) {
				return "Red";
			}
			
			if (color.equals("Stone")) {
				return "Gray";
			}
			
			if (color.equals("Marmalade")) {
				return "Orange";
			}
			
			if (color.equals("Chianti")) {
				return "Red";
			}
			
			if (color.equals("Cocoa")) {
				return "Brown";
			}
			
			if (color.equals("Birch")) {
				return "Beige";
			}
			
			if (color.equals("Daisy")) {
				return "Yellow";
			}
			
			if (color.equals("Cherry")) {
				return "Red";
			}
			
			if (color.equals("Winter")) {
				return "White";
			}
			
			if (color.equals("Sand")) {
				return "Beige";
			}
			
			if (color.equals("Camel")) {
				return "Beige";
			}
			
			if (color.equals("Teal")) {
				return "Blue";
			}
			
			if (color.equals("Taupe")) {
				return "Beige";
			}
			
			if (color.equals("Chambray")) {
				return "Blue";
			}
			
			if (color.equals("Rhubarb")) {
				return "Red";
			}
			
			if (color.equals("Terra Cotta")) {
				return "Brown";
			}
			
			if (color.equals("Linen")) {
				return "White";
			}
			
			if (color.equals("Celery")) {
				return "Green";
			}
			
			if (color.equals("Denim")) {
				return "Blue";
			}
			
			if (color.equals("Peach")) {
				return "Orange";
			}
			
			if (color.equals("Brass")) {
				return "Yellow";
			}
			
			if (color.equals("Blonde")) {
				return "Beige";
			}
			
			if (color.equals("Rose")) {
				return "Red";
			}
			
			if (color.equals("Navy")) {
				return "Blue";
			}
			
			if (color.equals("Suntan")) {
				return "Beige";
			}
			
			if (color.equals("Oyster")) {
				return "Gray";
			}
			
			if (color.equals("Chestnut")) {
				return "Brown";
			}
			
			if (color.equals("Berry")) {
				return "Purple";
			}
			
			if (color.equals("Burgundy")) {
				return "Red";
			}
			
			if (color.equals("Sundown")) {
				return "Orange";
			}
			
			if (color.equals("Beet")) {
				return "Purple";
			}
			
			if (color.equals("Cardinal")) {
				return "Red";
			}
			
			if (color.equals("Deep Sea")) {
				return "Blue";
			}
			
			if (color.equals("Snowflake")) {
				return "White";
			}
			
			if (color.equals("Ash")) {
				return "Gray";
			}
			
			if (color.equals("Pearl")) {
				return "Gray";
			}
			
			if (color.equals("Snow")) {
				return "White";
			}
			
			if (color.equals("Marshmallow")) {
				return "White";
			}
			
			if (color.equals("Egret")) {
				return "White";
			}
			
			if (color.equals("Fuchsia")) {
				return "Pink";
			}
			
			if (color.equals("Raspberry")) {
				return "Red";
			}
			
			if (color.equals("Mustard")) {
				return "Yellow";
			}
			
			if (color.equals("Heliotrope")) {
				return "Purple";
			}
			
			if (color.equals("Pumice")) {
				return "Gray";
			}
			
			if (color.equals("Chantrelle")) {
				return "Beige";
			}
			
			if (color.equals("Fuschia")) {
				return "Pink";
			}
			
			if (color.equals("Lagoon")) {
				return "Blue";
			}
			
			if (color.equals("Cinder")) {
				return "Gray";
			}
			
			if (color.equals("Iron")) {
				return "Black";
			}
			
			if (color.equals("Mocha")) {
				return "Brown";
			}
			
			if (color.equals("Mushroom")) {
				return "White";
			}
			
			if (color.equals("Magenta")) {
				return "Pink";
			}
			
			if (color.equals("Emerald")) {
				return "Green";
			}
			
			if (color.equals("Fawn")) {
				return "Beige";
			}
			
			if (color.equals("Raisin")) {
				return "Brown";
			}
			
			if (color.equals("Sage")) {
				return "Green";
			}
			
			if (color.equals("Thundercloud")) {
				return "Gray";
			}
			
			if (color.equals("Tomato")) {
				return "Red";
			}
			
			if (color.equals("Plum")) {
				return "Purple";
			}
			
			if (color.toLowerCase().indexOf("olive")>-1) {
				return "Green";
			}
			
			if (color.toLowerCase().indexOf("olive")>-1) {
				return "Green";
			}
			
			if (color.equals("Grey")) {
				return "Gray";
			}
			
			if (color.equals("Lilac")) {
				return "Purple";
			}
			
			if (color.indexOf("Gray") > -1) {
				return "Gray";
			}
			
			if (color.indexOf("Purple") > -1) {
				return "Purple";
			}
			
			if (color.indexOf("Roayl") > -1) {
				return "Blue";
			}
			
			if (color.indexOf("Orange") > -1) {
				return "Orange";
			}
			
			if (color.indexOf("Yellow") > -1) {
				return "Yellow";
			}
			
			if (color.indexOf("Green") > -1) {
				return "Green";
			}
			
			if (color.indexOf("Red") > -1) {
				return "Red";
			}
			
			if (color.indexOf("Moss") > -1) {
				return "Green";
			}
			
			if (color.indexOf("blue") > -1) {
				return "Blue";
			}
			
			if (color.indexOf("Blue") > -1) {
				return "Blue";
			}
			
			if (color.indexOf("Beige") > -1) {
				return "Beige";
			}
			
			if (color.indexOf("Brown") > -1) {
				return "Brown";
			}
			
			if (color.indexOf("Black") > -1) {
				return "Black";
			}
			
			if (color.indexOf("White") > -1) {
				return "White";
			}
			
			if (color.indexOf("Pink") > -1) {
				return "Pink";
			}
			
			if (color.equals("Gravel")) {
				return "Purple";
			}
			
			if (color.toLowerCase().indexOf("white") > -1) {
				return "White";
			}
			
			if (color.toLowerCase().indexOf("pink") > -1) {
				return "Pink";
			}
			
			if (color.toLowerCase().indexOf("blue") > -1) {
				return "Blue";
			}
			
			if (color.toLowerCase().indexOf("green") > -1) {
				return "Green";
			}
			
			if (color.toLowerCase().indexOf("black") > -1) {
				return "Black";
			}
			
			if (color.toLowerCase().indexOf("purple") > -1) {
				return "Purple";
			}
			
			if (color.toLowerCase().indexOf("grey") > -1) {
				return "Gray";
			}
			
			if (color.toLowerCase().indexOf("gray") > -1) {
				return "Gray";
			}
			
			if (color.toLowerCase().indexOf("coral") > -1) {
				return "Blue";
			}
			
			if (color.toLowerCase().indexOf("lemon") > -1) {
				return "Yellow";
			}
			
			if (color.toLowerCase().indexOf("chalk") > -1) {
				return "Gray";
			}
			
			if (color.toLowerCase().indexOf("silver") > -1) {
				return "Gray";
			}
			
			if (color.toLowerCase().indexOf("lavendar") >-1) {
				return "Purple";
			}
			
			if (color.toLowerCase().indexOf("navy") >-1) {
				return "Blue";
			}
			
			if (color.toLowerCase().indexOf("desert") >-1) {
				return "Beige";
			}
			
			if (color.toLowerCase().indexOf("gardenia") >-1) {
				return "Beige";
			}
			
			if (color.toLowerCase().indexOf("canary") >-1) {
				return "Yellow";
			}
			
			if (color.toLowerCase().indexOf("carbon") >-1) {
				return "Black";
			}
			
			if (color.toLowerCase().indexOf("poppy") >-1) {
				return "Red";
			}
			
			if (color.toLowerCase().indexOf("begonia") >-1) {
				return "Purple";
			}
			
			if (color.toLowerCase().indexOf("cream") >-1) {
				return "Beige";
			}
			
			if (color.toLowerCase().indexOf("creme") >-1) {
				return "Beige";
			}
			
			if (color.toLowerCase().indexOf("midnight") >-1) {
				return "Black";
			}
			
			if (color.toLowerCase().indexOf("gold") >-1) {
				return "Gold";
			}
			
			if (color.toLowerCase().endsWith(" red")) {
				return "Red";
			}
			
			if (color.toLowerCase().indexOf("orange") >-1) {
				return "Orange";
			}
			
			if (color.toLowerCase().indexOf("saffron") >-1) {
				return "Saffron";
			}
			
			if (color.toLowerCase().indexOf("marine") >-1) {
				return "Blue";
			}
			
			if (color.toLowerCase().indexOf("charcoal") >-1) {
				return "Gray";
			}
			
			if (color.toLowerCase().indexOf("marine") >-1) {
				return "Blue";
			}
			
			if (color.toLowerCase().indexOf("turquoise") >-1) {
				return "Blue";
			}
			
			if (color.toLowerCase().indexOf("flamingo") >-1) {
				return "Pink";
			}
			
			if (color.toLowerCase().indexOf("ivory") >-1) {
				return "White";
			}
			
			if (color.toLowerCase().indexOf("brown") >-1) {
				return "Brown";
			}
			
			if (color.toLowerCase().indexOf("multi") >-1) {
				return "Multi";
			}
			
			if (color.toLowerCase().indexOf("magenta") >-1) {
				return "Pink";
			}
			
			if (color.toLowerCase().indexOf("yellow") >-1) {
				return "Yellow";
			}
			
			if (color.toLowerCase().indexOf("mint") >-1) {
				return "Green";
			}
			
			if (color.toLowerCase().indexOf("crimson") >-1) {
				return "Red";
			}
			
			if (color.toLowerCase().indexOf("plum") >-1) {
				return "Purple";
			}
			
			if (color.toLowerCase().indexOf("rhododendren") >-1) {
				return "Purple";
			}
			
			if (color.toLowerCase().indexOf("rhododendron") >-1) {
				return "Purple";
			}
			
			if (color.toLowerCase().indexOf("bark") >-1) {
				return "Brown";
			}
			
			if (color.toLowerCase().indexOf(" rose") >-1) {
				return "Red";
			}
			
			if (color.toLowerCase().indexOf("atlantic") >-1) {
				return "Blue";
			}
			
			if (color.toLowerCase().indexOf("sangria") >-1) {
				return "Purple";
			}
			
			if (color.toLowerCase().indexOf("camel") >-1) {
				return "Beige";
			}
			
			if (color.toLowerCase().indexOf("ruby") >-1) {
				return "Red";
			}
			
			if (color.toLowerCase().indexOf("oatmeal") >-1) {
				return "Beige";
			}
			
			if (color.toLowerCase().indexOf("chocolate") >-1) {
				return "Brown";
			}
			
			if (color.toLowerCase().indexOf("caramel") >-1) {
				return "Beige";
			}
			
			if (color.toLowerCase().indexOf("violet") >-1) {
				return "Purple";
			}
			
			if (color.toLowerCase().indexOf("lavender") >-1) {
				return "Purple";
			}
			
			if (color.toLowerCase().indexOf("pimento") >-1) {
				return "Red";
			}
			
			if (color.toLowerCase().indexOf("almond") >-1) {
				return "Beige";
			}
			
			if (color.toLowerCase().startsWith("slate")) {
				return "Gray";
			}
			
			if (color.toLowerCase().indexOf("periwinkle") >-1) {
				return "Blue";
			}
			
			if (color.toLowerCase().indexOf("cobalt") >-1) {
				return "Blue";
			}
			
			if (color.toLowerCase().indexOf(" wine") >-1) {
				return "Red";
			}
			
			if (color.toLowerCase().indexOf("scarlet") >-1) {
				return "Red";
			}
			
			if (color.toLowerCase().endsWith(" tan")) {
				return "Beige";
			}
			
			if (color.toLowerCase().indexOf("mauve") >-1) {
				return "Purple";
			}
			
			if (color.toLowerCase().indexOf("olive") >-1) {
				return "Green";
			}
			
			if (color.toLowerCase().indexOf("teal") >-1) {
				return "Blue";
			}
			
			if (color.toLowerCase().indexOf("gun metal") >-1) {
				return "Gray";
			}
			
			if (color.toLowerCase().indexOf("beige") >-1) {
				return "Beige";
			}
			
			if (color.toLowerCase().indexOf("mulberry") >-1) {
				return "Pink";
			}
			
			if (color.toLowerCase().indexOf("ebony") >-1) {
				return "Black";
			}
			
			if (color.toLowerCase().indexOf("lilac") >-1) {
				return "Purple";
			}
			

			
			if (color.toLowerCase().indexOf("amethyst") >-1) {
				return "Purple";
			}
		
			
			if (color.toLowerCase().indexOf("taupe") >-1) {
				return "Beige";
			}
			
			if (color.toLowerCase().indexOf("almond") >-1) {
				return "Beige";
			}
			
			if (color.toLowerCase().indexOf("fuchsia") >-1) {
				return "Pink";
			}
			
			if (color.toLowerCase().indexOf("peony") >-1) {
				return "Pink";
			}
			
			if (color.toLowerCase().indexOf("aqua ") >-1) {
				return "Blue";
			}
			
			if (color.toLowerCase().indexOf("mahogany") >-1) {
				return "Brown";
			}
			
			if (color.toLowerCase().indexOf("pumpkin") >-1) {
				return "Orange";
			}
			
			if (color.toLowerCase().indexOf("driftwood") >-1) {
				return "Brown";
			}
			
			if (color.toLowerCase().indexOf("shale") >-1) {
				return "Blue";
			}
			
			if (color.toLowerCase().indexOf("grape") >-1) {
				return "Purple";
			}
			
			if (color.toLowerCase().indexOf("night") >-1) {
				return "Black";
			}
			
			if (color.toLowerCase().indexOf(" beet") >-1) {
				return "Purple";
			}
			
			if (color.toLowerCase().indexOf("cranberry") >-1) {
				return "Red";
			}
			
			if (color.toLowerCase().indexOf("caviar") >-1) {
				return "Red";
			}
			
			if (color.toLowerCase().indexOf("smoke") >-1) {
				return "Gray";
			}
			
			if (color.toLowerCase().indexOf("aubergine") >-1) {
				return "Purple";
			}
			
			if (color.toLowerCase().indexOf(" orchid") >-1) {
				return "Purple";
			}
			
			if (color.toLowerCase().indexOf("bordeaux") >-1) {
				return "Red";
			}
			
			if (color.toLowerCase().indexOf("indigo") >-1) {
				return "Purple";
			}
			
			if (color.toLowerCase().indexOf("cognac") >-1) {
				return "Beige";
			}
			
			if (color.toLowerCase().indexOf("mushroom") >-1) {
				return "White";
			}
			
			if (color.toLowerCase().indexOf("coffee") >-1) {
				return "Brown";
			}
		
			
			if (color.toLowerCase().indexOf("claret") >-1) {
				return "Purple";
			}
			
			if (color.toLowerCase().indexOf("truffle") >-1) {
				return "Brown";
			}
			
			if (color.toLowerCase().indexOf("pomegranate") >-1) {
				return "Red";
			}
			
			if (color.toLowerCase().indexOf("bronze") >-1) {
				return "Brown";
			}
			
			if (color.toLowerCase().indexOf("milk") >-1) {
				return "White";
			}
			
			if (color.toLowerCase().indexOf("mocha") >-1) {
				return "Brown";
			}
			
			if (color.toLowerCase().indexOf("nutmeg") >-1) {
				return "Brown";
			}
			
			if (color.toLowerCase().indexOf("cocoa") >-1) {
				return "Brown";
			}
		
			if (color.toLowerCase().indexOf("wheat") >-1) {
				return "Beige";
			}
			
			if (color.toLowerCase().indexOf("walnut") >-1) {
				return "Brown";
			}
			
			if (color.toLowerCase().indexOf("aluminum") >-1) {
				return "Gray";
			}
			
			if (color.toLowerCase().indexOf("granite") >-1) {
				return "Gray";
			}
			
			if (color.toLowerCase().indexOf("fig") >-1) {
				return "Purple";
			}
			
			if (color.toLowerCase().indexOf("eggplant") >-1) {
				return "Purple";
			}
			
			if (color.toLowerCase().indexOf("aqua") >-1) {
				return "Blue";
			}
			
			if (color.toLowerCase().indexOf("orchid") >-1) {
				return "Purple";
			}
			
			if (color.toLowerCase().indexOf("tan ") >-1) {
				return "Beige";
			}
			
			if (color.toLowerCase().startsWith("tan")) {
				return "Beige";
			}
			
			if (color.toLowerCase().indexOf("khaki") >-1) {
				return "Beige";
			}
			
			if (color.toLowerCase().indexOf("turquiose") >-1) {
				return "Blue";
			}
			
			if (color.toLowerCase().indexOf("jade") >-1) {
				return "Green";
			}
			
			if (color.toLowerCase().indexOf("emerald") >-1) {
				return "Green";
			}
			
			if (color.toLowerCase().indexOf("berry") >-1) {
				return "Red";
			}
			
			if (color.toLowerCase().indexOf("latte") >-1) {
				return "Beige";
			}
			
			if (color.toLowerCase().indexOf("red") >-1) {
				return "Red";
			}
			
			if (color.toLowerCase().indexOf("merlot") >-1) {
				return "Red";
			}
			
			if (color.toLowerCase().indexOf("sand") >-1) {
				return "Beige";
			}
			
			if (color.toLowerCase().indexOf("lime") >-1) {
				return "Green";
			}
		}
		
		if (returnValue == null) LOGGER.warn("Couldn't translate " + originalColor + " to color");
		return returnValue;
	}
}

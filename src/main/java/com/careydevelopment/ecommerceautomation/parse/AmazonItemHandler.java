package com.careydevelopment.ecommerceautomation.parse;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import com.careydevelopment.ecommerceautomation.entity.Product;
import com.careydevelopment.ecommerceautomation.process.ProductAttributes;
import com.careydevelopment.ecommerceautomation.util.ColorTranslator;
import com.careydevelopment.ecommerceautomation.util.InseamTranslator;
import com.careydevelopment.ecommerceautomation.util.SizeTranslator;


public class AmazonItemHandler extends BaseHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AmazonItemHandler.class);

	private String price = "";
	
	private String content;
	
	private boolean inImageSets = false;
	private boolean inPrimarySet = false;
	private boolean inPrimaryLargeImage = false;
	private boolean inItem = false;
	private boolean inVariantLargeImage = false;
	private boolean inVariantSet = false;
	private boolean inSwatchImage = false;
	private boolean inVariationSummary = false;
	private boolean inLowestPrice = false;
	
	private List<String> variantFrontUrls = new ArrayList<String>();
	private List<String> variantBackUrls = new ArrayList<String>();
	private List<String> swatchUrls = new ArrayList<String>();
	
	private String listPrice = "";
	private String newPrice = "";
	
	private boolean inListPrice = false;
	private boolean inOfferListing = false;
	private boolean inNewPrice = false;
	
	private String primaryImageUrl = null;
	
	private List<String> sizes = new ArrayList<String>();
	private List<String> colors = new ArrayList<String>();
	private List<String> inseams = new ArrayList<String>();
	
	public AmazonItemHandler(Product product, List<String> sizes, List<String> colors) {
		this.product = product;
		this.sizes = sizes;
		this.colors = colors;
	}
	
	public void startElement(String uri, String localName, String qName, 
			Attributes attributes) throws SAXException {
		
		if (qName.equals("ImageSets")) {
			//System.err.println("In ImageSetsxxx");
			if (inItem) {
				//System.err.println("In ImageSets");
				inImageSets = true;
				inItem = false;
			}
		} else if (qName.equals("ImageSet")) {
			//System.err.println("In ImageSetxxx");
			if (inImageSets) {
				//System.err.println("In ImageSet");
				String category = attributes.getValue("Category");
				if (category != null && category.equals("primary")) {
					inPrimarySet = true;
				} else if (category != null && category.equals("variant")) {
					inVariantSet = true;
					inImageSets = false;
				}
			}
		} else if (qName.equals("LargeImage")) {
			//System.err.println("In LargeImagexxx");
			if (inPrimarySet) {
				//System.err.println("In LargeImagePrimary");
				inPrimaryLargeImage = true;
				inPrimarySet = false;
			} else if (inVariantSet) {
				//System.err.println("In LargeImagevariant");
				inVariantLargeImage = true;
				inVariantSet = false;
			}
		} else if (qName.equals("Item")) {
			//System.err.println("In Item");
			inItem = true;
		} else if (qName.equals("SwatchImage")) {
			if (inPrimarySet) {
				inSwatchImage = true;
			}
		} else if (qName.equals("VariationSummary")) {
			inVariationSummary = true;
		} else if (qName.equals("LowestPrice")) {
			if (inVariationSummary) inLowestPrice = true;
		} else if (qName.equals("ListPrice")) {
			inListPrice = true;
		} else if (qName.equals("OfferListing")) {
			inOfferListing = true;
			//LOGGER.debug("In offer listing");
		} else if (qName.equals("Price")) {
			if (inOfferListing) {
				inNewPrice = true;
			}
		} 
	}
		
	public void endElement(String uri, String localName, String qName) 
				throws SAXException {
		
		//System.err.println(qName);
		if (qName.equals("Color")) {
			String theColor = content;
			
			if (theColor != null) {
				List<String> theseColors = new ArrayList<String>();
				if (theColor.startsWith("2pack") || theColor.startsWith("3pack")) {
					theColor = theColor.substring(6);
					String[] allColors = theColor.split("/");
					for (String col : allColors) {
						theseColors.add(col);
					}
				} else if (theColor.indexOf("/") > -1) {
					String[] allColors = theColor.split("/");
					for (String col : allColors) {
						theseColors.add(col);
					}
				} else {
					theseColors.add(theColor);
				}
				
				for (String col : theseColors) {
					String newColor = ColorTranslator.getColor(col);
					if (newColor != null) {
						if (!colors.contains(newColor)) {
							//color+=newColor + ",";
							//System.err.println("now color is "+color);		
							colors.add(newColor);
							addAttribute(ProductAttributes.COLOR,newColor);
						}
					}
				}
			}
		} else if (qName.equals("Size")) {
			String theSize = SizeTranslator.getSize(content);
			if (theSize != null) {
				String inseam = InseamTranslator.getInseamFromSize(content);
				if (inseam != null && !inseams.contains(inseam)) {
					inseams.addAll(inseams);
					addAttribute(ProductAttributes.INSEAM, inseam);
				}
			}
			//System.err.println("got back size " + theSize);
			if (theSize != null && !sizes.contains(theSize)) {		
				sizes.add(theSize);
				addAttribute(ProductAttributes.SIZE,theSize);
			}
		} else if (qName.equals("FormattedPrice")) {
			//System.err.println("in formatted price " + inListPrice + " " + inNewPrice );
			//System.err.println("conent is " + content);
			if (inLowestPrice) {
				if ("".equals(price)) {
					price = content.substring(1,content.length());				
					//LOGGER.debug("Setting price to " + price);
					inLowestPrice = false;
				}
			} else if (inListPrice) {
				if ("".equals(listPrice)) {
					if (!content.equals("$0.01")) {
						listPrice = content.substring(1,content.length());				
						//LOGGER.debug("Setting list price to " + content);
					}
				}
			} else if (inNewPrice) {
				if ("".equals(newPrice)) {
					newPrice = content.substring(1,content.length());				
					//LOGGER.debug("Setting new price to " + content);
				}
			}
		} else if (qName.equals("URL")) {
			if (inPrimaryLargeImage) {
				if (primaryImageUrl == null) primaryImageUrl = content;
				if (!variantFrontUrls.contains(content)) {
					variantFrontUrls.add(content);
					//System.err.println("\n\n\nADDING " + content + " to front");
				}
				
				inPrimaryLargeImage = false;
			} else if (inVariantLargeImage) {
				if (!variantBackUrls.contains(content)) {
					variantBackUrls.add(content);
					//System.err.println("\n\n\nADDING " + content + " to back");
				}
				
				inVariantLargeImage = false;
			} else if (inSwatchImage) {
				if (!swatchUrls.contains(content)) {
					//System.err.println("\n\n\n adding swatch " + content);
					swatchUrls.add(content);
					inSwatchImage = false;
				}
			}
		} else if (qName.equals("ImageSets")) {
			inImageSets = false;
		} else if (qName.equals("SwatchImage")) {
			inSwatchImage = false;
		} else if (qName.equals("VariationSummary")) {
			inVariationSummary = false;
		} else if (qName.equals("LowestPrice")) {
			inLowestPrice = false;
		} else if (qName.equals("ListPrice")) {
			inListPrice = false;
		} else if (qName.equals("OfferListing")) {
			inOfferListing = false;
		} else if (qName.equals("Price")) {
			inNewPrice = false;
		} else if (qName.equals("ASIN")) {
			//System.err.println("ASIN isn " + content);
		} else if (qName.equals("ClothingSize")) {
			LOGGER.info("In ClothingSize " + content);
			if (content != null && content.indexOf("x") > -1) {
				String[] parts = content.split("x");
				LOGGER.info("Waist is " + parts[0]);
				LOGGER.info("Inseam is " + parts[1]);
				
				String size = SizeTranslator.getSize(parts[0]);
				if (size != null && !sizes.contains(size)) {
					sizes.add(size);
					addAttribute(ProductAttributes.SIZE,size);
				}
				
				String inseam = InseamTranslator.translateInseam(parts[1]);
				if (inseam != null && !inseams.contains(inseam)) {
					inseams.add(inseam);
					addAttribute(ProductAttributes.INSEAM,inseam);
				}
			}
		}
		
		content = null;
	}
	
	public String getNewPrice() {
		return newPrice;
	}
	
	public String getListPrice() {
		return listPrice;
	}
	
	public String getPrice() {
		return price;
	}
	
	public String getPrimaryImageUrl() {
		return primaryImageUrl;
	}
	
	public List<String> getVariantFrontUrls() {
		return variantFrontUrls;
	}
	
	public List<String> getVariantBackUrls() {
		return variantBackUrls;
	}
	
	public List<String> getSwatchUrls() {
		return swatchUrls;
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (content == null) content = String.copyValueOf(ch, start, length).trim();
		else content +=  String.copyValueOf(ch, start, length).trim();
	}
}
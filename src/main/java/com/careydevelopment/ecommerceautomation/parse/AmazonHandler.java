package com.careydevelopment.ecommerceautomation.parse;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.careydevelopment.ecommerceautomation.clean.ProductExportFile;
import com.careydevelopment.ecommerceautomation.entity.Category;
import com.careydevelopment.ecommerceautomation.entity.Product;
import com.careydevelopment.ecommerceautomation.process.ProductAttributes;
import com.careydevelopment.ecommerceautomation.service.ProductPersistenceService;
import com.careydevelopment.ecommerceautomation.util.AmazonUrlHelper;
import com.careydevelopment.ecommerceautomation.util.ColorTranslator;
import com.careydevelopment.ecommerceautomation.util.SizeTranslator;
import com.careydevelopment.ecommerceautomation.util.UrlHelper;

public class AmazonHandler extends BaseHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AmazonHandler.class);

	private static final String VENDOR_NAME = "Amazon";
	
	protected int counter = 0;
	
	private String outputFile = "";
	private boolean inLargeImage = false;
	private boolean hasSku = false;
	private boolean hasTitle = false;
	private boolean inListPrice = false;
	private boolean inPrice = false;
	private boolean inVariations = false;
	
	private int totalPages = 0;
	
	private String brand = "";
	private Category category;
	private String keyword = "";
	
	private String content;
	
	
	private String color = "";
	private String size = "";
	private String price = "";
	
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
	
	private List<String> usedColors = new ArrayList<String>();
	private List<String> usedSizes = new ArrayList<String>();
	
	private String listPrice = "";
	private String newPrice = "";
	
	private boolean inOfferListing = false;
	private boolean inNewPrice = false;
	
	private String primaryImageUrl = null;
	
	
	private String titleMustInclude = null;
	
	private float minimumPrice = -1f;
	
	private boolean outOfStock = false;
	
	private boolean inItemDimensions =false;
	
	private ProductExportFile pef;
	
	
	public AmazonHandler(String brand, Category category, String keyword, String outputFile) {
		//super(db);
		
		//this.db = db;
		this.outputFile = outputFile;
		this.brand = brand;
		this.category = category;
		this.keyword = keyword;
		
		pef = new ProductExportFile(outputFile, false);						
	}
	
	public AmazonHandler(String brand, Category category, String keyword, String titleMustInclude, String outputFile) {
		//super(db);
		
		//this.db = db;
		this.outputFile = outputFile;
		this.brand = brand;
		this.category = category;
		this.keyword = keyword;
		this.titleMustInclude = titleMustInclude;
		
		pef = new ProductExportFile(outputFile, false);						
	}
	
	public void startElement(String uri, String localName, String qName, 
			Attributes attributes) throws SAXException {
	
		//System.err.println(qName);
		if (qName.equals("Item") && !inVariations) {
			//System.err.println("creating new product");
			product = new Product();
			product.setProgramName(VENDOR_NAME);
			product.setVendor(VENDOR_NAME);
			product.setCatalogName(VENDOR_NAME);
			product.setInStock("instock");
			//product.setCondition("new");
			product.setAdvertiserCategory(category);
			product.setManufacturerId(brand);
			inItem = true;
			
			color = "";
			size = "";
			price = "";
			
			inImageSets = false;
			inPrimarySet = false;
			inPrimaryLargeImage = false;
			inVariantLargeImage = false;
			inVariantSet = false;
			inSwatchImage = false;
			inVariationSummary = false;
			inLowestPrice = false;
			
			variantFrontUrls = new ArrayList<String>();
			variantBackUrls = new ArrayList<String>();
			swatchUrls = new ArrayList<String>();
			
			usedColors = new ArrayList<String>();
			usedSizes = new ArrayList<String>();
			
			listPrice = "";
			newPrice = "";
			
			inOfferListing = false;
			inNewPrice = false;
			
			primaryImageUrl = null;
			
			outOfStock = false;
			inItemDimensions=false;
			
		} else if (qName.equals("ListPrice")) {
			inListPrice = true;
		} else if (qName.equals("Price")) {
			inPrice = true;
		} else if (qName.equals("ImageSets")) {
			//System.err.println("In ImageSetsxxx");
			if (inVariations) {
				//System.err.println("In ImageSets");
				inImageSets = true;
				inItem = false;
			}
		} else if (qName.equals("ImageSet")) {
			//System.err.println("In ImageSetxxx " + inImageSets);
			if (inImageSets) {
				//System.err.println("In ImageSet");
				String category = attributes.getValue("Category");
				//System.err.println("cjgorey of " + category);
				if(category != null && category.equals("primary")) {
					inPrimarySet = true;
				} else if (category != null && category.equals("variant")) {
					//System.err.println("in variant");
					inVariantSet = true;
					//inImageSets = false;
				}
			} else {
				//System.err.println("\n\n\n***********8not in image sets");
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
		} else if (qName.equals("SwatchImage")) {
			if (inPrimarySet) {
				inSwatchImage = true;
			}
		} else if (qName.equals("VariationSummary")) {
			//System.err.println("in variationsummary");
			inVariationSummary = true;
		} else if (qName.equals("LowestPrice")) {
			if (inVariationSummary) {
				//System.err.println("in lowest price");
				inLowestPrice = true;
			}
		} else if (qName.equals("LowestNewPrice")) {
			inLowestPrice = true;
		} else if (qName.equals("ListPrice")) {
			inListPrice = true;
		} else if (qName.equals("OfferListing")) {
			inOfferListing = true;
			//LOGGER.debug("In offer listing");
		} else if (qName.equals("Variations")) {
			inVariations = true;
			//System.err.println("\n\n\nin varioations");
		} else if (qName.equals("ItemDimensions") && !inVariations) {
			inItemDimensions = true;
		}
	}
		
	public void endElement(String uri, String localName, String qName) 
				throws SAXException {
		
		if (qName.equals("DetailPageURL") && !inVariations) {
			product.setBuyUrl(content);
		} /*else if (qName.equals("URL")) {
			if (inLargeImage && product.getImageUrl().equals("")) {
				//System.err.println("setting image " + content);
				product.setImageUrl(content);
			}
		}*/ else if (qName.equals("Brand") && !inVariations) {
			product.setManufacturerId(content);
		} else if (qName.equals("ASIN") && !inVariations) {
			if (!hasSku) {
				product.setSku(content);
				//System.err.println("ASIN is " + content);
				hasSku = true;
			}
		} else if (qName.equals("FormattedPrice")) {
			//System.err.println("informatted price content is " + content + " " + inLowestPrice + " " + inListPrice + " " + inPrice);
			
			if (inListPrice) {
				if (product.getPrice() != null && product.getPrice().trim().length() > 0) {
					//do nothing for now
				} else {
					product.setRetailPrice(content.substring(1,content.length()));
				}
			} else if (inPrice) {
				if (product.getPrice() != null && product.getPrice().trim().length() > 0) {
					//System.err.println("here " + product.getPrice());
					
					//for video games, the first variation price always wins
					try {
						Float f1 = null;
						try {
							f1 = new Float(stripOutComma(product.getPrice()));
						} catch (NumberFormatException ne) {
							f1=9999999f;
						}
						
						Float f2 = new Float(stripOutComma(content.substring(1, content.length())));
						if (f2 < f1) {
							//System.err.println("setting price to " + content);
							product.setPrice(content.substring(1, content.length()));
						}
					} catch (NumberFormatException e) {
						//e.printStackTrace();
						//non-numeric value - just ignore
						//System.err.println("not setting non-numeric value");
					}
					} else {
					//System.err.println("setting price to " + content);
					product.setPrice(content.substring(1,content.length()));
				}
			} else if (inLowestPrice) {
				//if (category.indexOf("Video Game") == -1) {
					product.setLowestOfferPrice(content.substring(1,content.length()));
				//}
			}
		} else if (qName.equals("Title") && !inVariations) {
			//System.err.println("in title");
			if (!hasTitle) {
				//System.err.println("Setting title to " + content);
				product.setName(content);
				hasTitle = true;
			}
		} else if (qName.equals("Content") && !inVariations) {
			product.setDescription(content);
		} else if (qName.equals("TotalPages")) {
			totalPages = new Integer(content);
		} else if (qName.equals("Item") && !inVariations) {
			hasSku = false;
			inLargeImage = false;
			hasTitle = false;
			//if (counter < 3) {
			//System.err.println("evaluating " + product.getName());
				//if (keyword == null || keyword.equals("") || product.getName().indexOf(keyword) > -1) {
				//System.err.println("outofsock check " + outOfStock);

				if (!outOfStock && product.getName() != null && product.getName().length() > 3 && product.getName().indexOf("Plus") == -1 && product.getName().indexOf("Petite") == -1 && product.getName().indexOf("Junior")== -1) {
					//System.err.println(titleMustInclude);
					if (titleMustInclude == null || (titleMustInclude != null && product.getName().toLowerCase().indexOf(titleMustInclude.toLowerCase()) > -1)) {
						//System.err.println(product.getBuyUrl());
						getAdditionalInfo(product.getSku());

						if (product.getImageUrl()==null || product.getImageUrl().equals("")) {
							if (product.getVariantFrontUrls().size() > 0) {
								product.setImageUrl(product.getVariantFrontUrls().get(0));
							} else {
								System.err.println("Skipping " + product.getName() + " because I have no image");
								product.setPrice(null);
							}
						}
						
						//System.err.println(counter);
						counter++;
						//System.err.println("final prices are " + product.getPrice() + " " + product.getRetailPrice());
						if (product.getPrice()!=null && !product.getPrice().trim().equals("")&& product.getPrice().indexOf("oo low")==-1) {	
							Float priceCheck = new Float(product.getPrice());
							if (priceCheck > this.minimumPrice) {
								if (checkUrl()) {
									handleMoreOffers();
									LOGGER.info("Writing " + product.getName() + " " + product.getAdvertiserCategory()+"\n\n\n");
									LOGGER.info(product.getSizes());
									LOGGER.info(product.getColors());
									/*List<String> fronts = product.getVariantFrontUrls();
									List<String> backs = product.getVariantBackUrls();
									
									if (fronts.size()>1) {
									
									System.err.println("fronts");
									for (String fr : fronts) {
										System.err.println(fr);
									}
									
									System.err.println("backs");
									for (String ba : backs) {
										System.err.println(ba);
									}
									}*/
									
									//System.err.println("price " + product.getPrice() + " " + product.getBuyUrl());
									//System.err.println("lowest price " + product.getLowestOfferPrice() + " " + product.getOffersUrl());
									//System.err.println("image is " + product.getImageUrl() + " for " + product.getName());
									//if (product.getVariantBackUrls() != null && product.getVariantBackUrls().size() > 0) System.err.println("\n\n\nback is " + product.getVariantBackUrls().get(0));
									
									pef = new ProductExportFile(outputFile, false);						
									pef.writeProduct(product);
									pef.close();
									
									try {
										ProductPersistenceService service = new ProductPersistenceService();
										service.saveProduct(product);
									} catch (Exception e) {
										e.printStackTrace();
									}
								} else {
									System.err.println("not writing 5");
								}
							} else {
								System.err.println("not writing 4");
							}
						} else {
							System.err.println("not writing 3");
						}
					} else {
						System.err.println("not writing 2");
					}
				} else {
					System.err.println("not writing 1");
				}
			//}
		} else if (qName.equals("ItemSearchResponse")) {
			pef.close(false);
			//this.closeEverything();
		} else if (qName.equals("ListPrice")) {
			inListPrice = false;
		} else if (qName.equals("Price")) {
			inPrice = false;
		} else if (qName.equals("Artist")) {
			product.setArtist(content);
		} else if (qName.equals("Author")) {
			product.setArtist(content);
		} else if (qName.equals("Color")) {
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
						if (!usedColors.contains(newColor)) {
							color+=newColor + ",";
							//System.err.println("now color is "+color);		
							usedColors.add(newColor);
							addAttribute(ProductAttributes.COLOR,newColor);
						}
					}
				}
			}
		} else if (qName.equals("Size")) {
			String theSize = SizeTranslator.getSize(content);
			//System.err.println("got back size " + theSize);
			if (theSize != null && !usedSizes.contains(theSize)) {
				size+=theSize+",";
				//System.err.println("now size is "+size);			
				usedSizes.add(theSize);
				addAttribute(ProductAttributes.SIZE, theSize);
			}
		} else if (qName.equals("URL")) {
			//System.err.println("in url " + inPrimaryLargeImage + " "+ inVariations);
			//System.err.println(inPrimaryLargeImage + " " + inVariantLargeImage);
			if (inVariations && inPrimaryLargeImage) {
				if (primaryImageUrl == null) primaryImageUrl = content;
				if (!variantFrontUrls.contains(content)) {
					variantFrontUrls.add(content);
					//System.err.println("\n\n\nADDING " + content + " to front");
				}
				
				inPrimaryLargeImage = false;
			} else if (inVariations && inVariantLargeImage) {
				if (!variantBackUrls.contains(content)) {
					variantBackUrls.add(content);
					//System.err.println("\n\n\nADDING " + content + " to back");
				}
				
				inVariantLargeImage = false;
			} else if (inVariations && inSwatchImage) {
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
		} else if (qName.equals("ASIN") && !inVariations) {
			//System.err.println("ASIN isn " + content);
		} else if (qName.equals("LowestNewPrice")) {
			inLowestPrice = false;
		} else if (qName.equals("Variations")) {
			inVariations = false;
		} else if (qName.equals("MoreOffersUrl")) {
			/*if (category.indexOf("Books") > -1 || category.indexOf("Music") > -1 
			 || category.indexOf("Movies") > -1 || category.indexOf("Appliances")>-1
			 || category.indexOf("Kitchen")>-1 || category.indexOf("Kitchen")>-1
			 || category.indexOf("Laptop")>-1
			 || category.indexOf("Tablet")>-1 || category.indexOf("Desktop")>-1
			 || category.indexOf("Computers")>-1 || category.indexOf("HDTVs")>-1
			 || category.indexOf("Projectors")>-1 || category.indexOf("Players")>-1
			 || category.indexOf("Bedroom")>-1 || category.indexOf("Dining Room")>-1
			 || category.indexOf("Living Room")>-1) {
				if (!content.equals("0")) {
					String moreOffersUrl = content + "&condition=new";
					product.setOffersUrl(moreOffersUrl);
				} else {
					
				}
			}*/
		} else if (qName.equals("Availability") && !inVariations) {
			//System.err.println("Looking at " + content);
			if (content != null && content.toLowerCase().indexOf("out of stock") >-1) {
				outOfStock = true;
				//System.err.println("outofstock " + outOfStock);
			}
		} else if (qName.equals("Height") && inItemDimensions) {
			try{
			content = content.substring(0, content.length()-2) + "." + content.substring(content.length() -2, content.length());
			product.setHeight(content);
			//System.err.println("height is " + product.getHeight());
			} catch (Exception e) {
				
			}
		} else if (qName.equals("Width") && inItemDimensions) {
			try{
			content = content.substring(0, content.length()-2) + "." + content.substring(content.length() -2, content.length());
			product.setWidth(content);
			//System.err.println("height is " + product.getHeight());
			} catch (Exception e) {
				
			}
		} else if (qName.equals("Length") && inItemDimensions) {
			try{
			content = content.substring(0, content.length()-2) + "." + content.substring(content.length() -2, content.length());
			product.setLength(content);
			//System.err.println("height is " + product.getHeight());
			} catch (Exception e) {
				
			}
		} else if (qName.equals("Weight") && inItemDimensions) {
			try {
			content = content.substring(0, content.length()-2) + "." + content.substring(content.length() -2, content.length());
			product.setWeight(content);
			//System.err.println("height is " + product.getHeight());
			} catch (Exception e) {
				
			}
		} else if (qName.equals("ItemDimensions")) {
			inItemDimensions = false;
		} else if (qName.equals("LargeImage")) {
			inVariantLargeImage=false;
			inPrimaryLargeImage=false;
		}
		
		content = null;
	}	

	
	private void handleMoreOffers() {
		String price = product.getPrice();
		String lowestPrice = product.getLowestOfferPrice();
		
		try {
			Float f1 = new Float(lowestPrice);
			Float f2 = new Float(price);
			
			if (f2 <= f1) {
				product.setOffersUrl("");
				product.setLowestOfferPrice("");				
			}
		} catch (Exception e) {
			product.setOffersUrl("");
			product.setLowestOfferPrice("");
		}
		
		if (product.getOffersUrl().equals("")) {
			product.setLowestOfferPrice("");
		}
	}
	
	private boolean checkUrl() {
		boolean goodUrl = true;
		
		/*if ((product.getAdvertiserCategory().indexOf("Kitchen") > -1
				|| product.getAdvertiserCategory().indexOf("Appliances") > -1
				 || product.getAdvertiserCategory().indexOf("Laptop")>-1
				 || product.getAdvertiserCategory().indexOf("Tablet")>-1 
				 || product.getAdvertiserCategory().indexOf("Desktop")>-1
				 || product.getAdvertiserCategory().indexOf("Computers")>-1 
				 || product.getAdvertiserCategory().indexOf("HDTVs")>-1
				 || product.getAdvertiserCategory().indexOf("Projectors")>-1 
				 || product.getAdvertiserCategory().indexOf("Players")>-1
				 || product.getAdvertiserCategory().indexOf("Bedroom")>-1
				 || product.getAdvertiserCategory().indexOf("Dining Room")>-1
				 || product.getAdvertiserCategory().indexOf("Living Room")>-1)
				&& !product.getBuyUrl().endsWith("=new")) {
			goodUrl = false;
		}*/
		
		return goodUrl;
	}
	
	
	public void getAdditionalInfo(String sku) {
		try {
			if (product.getImageUrl() == null || product.getImageUrl().equals("")) {
				//System.err.println("going for image");
				AmazonUrlHelper helper = new AmazonUrlHelper();
				String url = helper.getSpecificItemUrl(sku);
				
				LOGGER.info("URL for specific item is " + url);
				
				SAXParserFactory parserFactor = SAXParserFactory.newInstance();
				SAXParser parser = parserFactor.newSAXParser();
				AmazonItemHandler handler = new AmazonItemHandler();
				
				InputSource ins = UrlHelper.getInputSource(url);
			    ins.setEncoding("US-ASCII");
				
				parser.parse(ins, handler); 
				//System.err.println("image is " + handler.getPrimaryImageUrl());
				product.setImageUrl(handler.getPrimaryImageUrl());
				Thread.sleep(1000);
			}
			
			String sizes = size;
			String colors = color;
			//List<String> variantFrontUrls = variantFrontUrls;
			//List<String> variantBackUrls = variantBackUrls;
			//List<String> swatchUrls = swatchUrls;
			
			//System.err.println("initial prices are " + price + " " + listPrice + " " + newPrice);
			
			product.setSizes(sizes);
			product.setColors(colors);
			//product.setPrice(price);
			
			if (product.getPrice() == null || product.getPrice().equals("")) {
				//System.err.println("going with list price");
				
				if (newPrice != null && !newPrice.equals("")) {
					product.setPrice(newPrice);
				}
				
				if (listPrice != null && !listPrice.equals("")) {
					product.setRetailPrice(listPrice);
				}
			}
			
			if (product.getPrice() == null || product.getPrice().equals("") || product.getPrice().indexOf("oo low") > -1) {
				if (product.getRetailPrice() != null && !product.getRetailPrice().equals("")) product.setPrice(product.getRetailPrice());
			}
			
			if (product.getRetailPrice() == null || product.getRetailPrice().equals("")) {
				if (product.getPrice() != null && !product.getPrice().equals("")) product.setRetailPrice(product.getPrice());
			}
			
			if (product.getRetailPrice() != null && !product.getRetailPrice().equals("")) {
				if (product.getPrice() != null && !product.getPrice().equals("")) {
					try {
					Float f1 = new Float(stripOutComma(product.getPrice()));
					Float f2 = new Float(stripOutComma(product.getRetailPrice()));
					
					if (f2<f1) {
						product.setRetailPrice(product.getPrice());
					} else {
						if (f2 - f1 < .11f) {
							//we do this because we don't want the "SALE"
							//badge when the price difference is only 3 cents
							product.setPrice(product.getRetailPrice());
						}
					}
					} catch (NumberFormatException n) {
						//verbal price - disregard
					}
				}
			}
			
			product.setVariantBackUrls(variantBackUrls);
			product.setVariantFrontUrls(variantFrontUrls);
			product.setSwatchUrls(swatchUrls);
			
			if (primaryImageUrl != null) {
				product.setImageUrl(primaryImageUrl);
			}
			
			product.setRetailPrice(stripOutComma(product.getRetailPrice()));
			product.setPrice(stripOutComma(product.getPrice()));
			//System.err.println("colors are " + colors);
			//System.err.println("sizes are " + sizes);
			
			//System.err.println("Final prices are " + product.getRetailPrice() + " " + product.getPrice());
			//Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public int getTotalPages() {
		return totalPages;
	}

	public String getTitleMustInclude() {
		return titleMustInclude;
	}

	public void setTitleMustInclude(String titleMustInclude) {
		this.titleMustInclude = titleMustInclude;
	}

	public float getMinimumPrice() {
		return minimumPrice;
	}

	public void setMinimumPrice(float minimumPrice) {
		this.minimumPrice = minimumPrice;
	}
	
	protected String stripOutComma(String s) {
		String ret = s;
		
		while (ret.indexOf(",") > -1) {
			int comloc = s.indexOf(",");
			ret = ret.substring(0, comloc) + ret.substring(comloc+1, ret.length());
		}
		
		return ret;
	}
	
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (content == null) content = String.copyValueOf(ch, start, length).trim();
		else content +=  String.copyValueOf(ch, start, length).trim();
	}

}

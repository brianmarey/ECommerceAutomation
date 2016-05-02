package com.careydevelopment.ecommerceautomation.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.careydevelopment.ecommerceautomation.company.Company;
import com.careydevelopment.ecommerceautomation.entity.Categories;
import com.careydevelopment.ecommerceautomation.entity.Category;
import com.careydevelopment.ecommerceautomation.parse.AmazonParseProcessor;

public class AmazonProcessor extends BaseProcessor {
	private static final Logger LOGGER = LoggerFactory.getLogger(AmazonProcessor.class);
	
	//private static Database db = DatabaseHelper.getDatabase(DatabaseHelper.BRIANMCAREY);
	
	public AmazonProcessor(Company company) {
		super(company);
	}
	
	public static void main(String args[]) {
		//AmazonProcessor pa = new AmazonProcessor();
		//pa.process();
	}

	
	protected void iterateProducts() {
		iterateWomensClothing(Categories.WOMEN_TOPS_HENLEY,"henley","5418124011");
		iterateWomensClothing(Categories.WOMEN_TOPS_POLOS,"polo","1044548");
		iterateWomensClothing(Categories.WOMEN_TOPS_TEES,"tee","1044544");
		iterateWomensClothing(Categories.WOMEN_JEANS_BOOTCUT,"bootcut","1048188");
		iterateWomensClothing(Categories.WOMEN_JEANS_ANKLE,"ankle","1048188");
		iterateWomensClothing(Categories.WOMEN_JEANS_BOYFRIEND,"boyfriend","1048188");
		iterateWomensClothing(Categories.WOMEN_JEANS_SKINNY,"skinny","1048188");
		iterateWomensClothing(Categories.WOMEN_JEANS_STRAIGHT,"straight","1048188");
		iterateWomensClothing(Categories.WOMEN_TOPS_BLOUSES,null,"2368365011");
		iterateWomensClothing(Categories.WOMEN_PANTS_WORK,"pant","2528696011");
		iterateWomensClothing(Categories.WOMEN_PANTS_NIGHT_OUT,"pant","2528697011");
		iterateWomensClothing(Categories.WOMEN_PANTS_CASUAL,"pant","2348576011");
	
		iterateMensClothing(Categories.MENS_POLO_SHIRTS,"polo","1045640");
		iterateMensClothing(Categories.MENS_CASUAL_SHIRTS,"shirt","1045630");
		iterateMensClothing(Categories.MENS_HENLEY_SHIRTS,"henley","1045642");
		iterateMensClothing(Categories.MENS_DRESS_SHIRTS,"shirt","1045626");
		
		/*		
		//iterateCologne(CareyCategories.COLOGNE,null,"11059721");
		//iterateCologne(CareyCategories.PERFUME	,null,"11057051");		
	
		attMap = new HashMap<String,String>();
		//attMap.put(CareyAttributes.LABEL_MENS_JEAN_TYPE, CareyAttributes.MENS_RELAXED_JEANS);
		iterateMensClothing(CareyCategories.MEN_RELAXED_JEANS,"relaxed","1045564",attMap);

		attMap = new HashMap<String,String>();
		//attMap.put(CareyAttributes.LABEL_MENS_JEAN_TYPE, CareyAttributes.MENS_STRAIGHT_JEANS);
		iterateMensClothing(CareyCategories.MEN_STRAIGHT_JEANS,"straight","1045564",attMap);
		
		attMap = new HashMap<String,String>();
		//attMap.put(CareyAttributes.LABEL_MENS_JEAN_TYPE, CareyAttributes.MENS_SLIM_JEANS);
		iterateMensClothing(CareyCategories.MEN_SLIM_JEANS,"slim","1045564",attMap);
		
		attMap = new HashMap<String,String>();
		//attMap.put(CareyAttributes.LABEL_MENS_JEAN_TYPE, CareyAttributes.MENS_SKINNY_JEANS);
		iterateMensClothing(CareyCategories.MEN_SKINNY_JEANS,"skinny","1045564",attMap);
	

		attMap = new HashMap<String,String>();
		//attMap.put(CareyAttributes.LABEL_MENS_PANTS_TYPE, CareyAttributes.DRESS_PANTS);
		iterateMensClothing(CareyCategories.MEN_DRESS_PANTS,"pant","2476497011",attMap);

		attMap = new HashMap<String,String>();
		//attMap.put(CareyAttributes.LABEL_MENS_PANTS_TYPE, CareyAttributes.CASUAL_PANTS);
		iterateMensClothing(CareyCategories.MEN_CASUAL_PANTS,"pant","2476498011",attMap)
		                                                                 
		iterateDishwashers(CareyCategories.DISHWASHERS,"dishwasher","3741281");

		iterateMicrowaves(CareyCategories.MICROWAVES,"microwave","3741631");

		attMap = new HashMap<String,String>();
		//attMap.put(CareyAttributes.LABEL_RANGE_FUEL_TYPE, CareyAttributes.RANGE_FUEL_ELECTRIC);
		iterateRanges(CareyCategories.RANGES_ELECTRIC,"electric","3741431",attMap);

		attMap = new HashMap<String,String>();	
		//attMap.put(CareyAttributes.LABEL_RANGE_FUEL_TYPE, CareyAttributes.RANGE_FUEL_GAS);
		iterateRanges(CareyCategories.RANGES_GAS,"gas","3741431",attMap);

		attMap = new HashMap<String,String>();
		//attMap.put(CareyAttributes.LABEL_REFRIGERATOR_CONFIG_TYPE, CareyAttributes.REFRIG_FREEZER_ON_BOT);
		iterateRefrigerators(CareyCategories.REFRIGERATORS_FREEZER_ON_BOT,"bottom","3741361",attMap);

		attMap = new HashMap<String,String>();
		//attMap.put(CareyAttributes.LABEL_REFRIGERATOR_CONFIG_TYPE, CareyAttributes.REFRIG_FREEZER_ON_TOP);
		iterateRefrigerators(CareyCategories.REFRIGERATORS_FREEZER_ON_TOP,"top","3741361",attMap);
		
		attMap = new HashMap<String,String>();
		//attMap.put(CareyAttributes.LABEL_REFRIGERATOR_CONFIG_TYPE, CareyAttributes.REFRIG_FRENCH_DOOR);
		iterateRefrigerators(CareyCategories.REFRIGERATORS_FRENCH,"french","3741361",attMap);

		attMap = new HashMap<String,String>();
		//attMap.put(CareyAttributes.LABEL_REFRIGERATOR_CONFIG_TYPE, CareyAttributes.REFRIG_SIDE_BY_SIDE);
		iterateRefrigerators(CareyCategories.REFRIGERATORS_SIDE,"side","3741361",attMap);

		iterateDryers(CareyCategories.DRYERS,"electric","13397481");
		
		iterateWashers(CareyCategories.WASHERS,"electric","13397491");
		
		iterateWineCellars(CareyCategories.WINE_CELLARS,"wine","3741541");
		iterateWineCellars(CareyCategories.WINE_CELLARS,"wine","3741531");
		
		iterateBeerKegRefrigerators(CareyCategories.BEER_KEG_REFRIGERATORS,"beer","2686378011");
				
		iterateArmoires(CareyCategories.ARMOIRES,"armoire","3733271");
		iterateDressers(CareyCategories.DRESSERS,"dresser","3733261");
		
		iterateNightstands(CareyCategories.NIGHTSTANDS,"nightstand","3733251");
		iterateNightstands(CareyCategories.NIGHTSTANDS,"night stand","3733251");		
		
		iterateDiningRoomSets(CareyCategories.DINING_ROOM_SETS,"dining","8566630011");	

		iterateLivingRoomChairs(CareyCategories.LIVING_ROOM_CHAIRS,"chair","3733491");
		iterateLivingRoomSofaSets(CareyCategories.LIVING_ROOM_SOFA_SETS,"sofa","3733551");
		iterateLivingRoomLoveSeats(CareyCategories.LIVING_ROOM_LOVE_SEATS,"love seat","3733551");
		
		iterateCoffeeTables(CareyCategories.COFFEE_TABLES,"coffee","3733631");
		iterateEndTables(CareyCategories.END_TABLES,"end table","3733641");
				
		iterateEntertainmentCenters(CareyCategories.ENTERTAINMENT_CENTERS,"entertainment center","14109851");
		
		*/
		
		
		
		
		
		/*
		 * 
				attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_MATTRESS_SIZE, CareyAttributes.MATTRESS_SIZE_QUEEN);
		iterateComforters(CareyCategories.COMFORTER,"queen","14053321",attMap);
		
		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_MATTRESS_SIZE, CareyAttributes.MATTRESS_SIZE_TWIN);		
		iterateComforters(CareyCategories.COMFORTER,"twin","14053321",attMap);
		
		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_MATTRESS_SIZE, CareyAttributes.MATTRESS_SIZE_KING);
		iterateComforters(CareyCategories.COMFORTER,"king","14053321",attMap);
		
		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_MATTRESS_SIZE, CareyAttributes.MATTRESS_SIZE_FULL);
		iterateComforters(CareyCategories.COMFORTER,"full","14053321",attMap);		

		
		iterateCellPhones(CareyCategories.CELL_PHONES_WITH_PLANS,null,"2407747011");
		iterateCellPhones(CareyCategories.CELL_PHONES_NO_CONTRACT,null,"2407748011");
		iterateCellPhones(CareyCategories.CELL_PHONES_UNLOCKED,null,"2407749011");
*/
		
		

				/*iterateGraphicNovels(CareyCategories.GRAPHIC_NOVELS,null,"3825111");
		iterateGraphicNovels(CareyCategories.GRAPHIC_NOVELS,null,"4394");
		iterateGraphicNovels(CareyCategories.GRAPHIC_NOVELS,null,"3825121");
		iterateGraphicNovels(CareyCategories.GRAPHIC_NOVELS,null,"7421473011");
	
		
		iterateBooks(CareyCategories.BOOKS_BEST_SELLERS,null,"390919011");
		
		iterateBooks(CareyCategories.BOOKS_HUMOR,null,"86");
		iterateBooks(CareyCategories.BOOKS_MYSTERY,null,"18");
		iterateBooks(CareyCategories.BOOKS_SCIFI,null,"25");
		iterateBooks(CareyCategories.BOOKS_TECH,null,"5");
		iterateBooks(CareyCategories.BOOKS_BUSINESS,null,"3");
		iterateBooks(CareyCategories.BOOKS_POLITICAL,null,"5571255011");
		iterateBooks(CareyCategories.BOOKS_SELFHELP,null,"4736");
		iterateBooks(CareyCategories.BOOKS_BIOGRAPHIES,null,"2");
		iterateBooks(CareyCategories.BOOKS_HISTORIES,null,"9");
		iterateBooks(CareyCategories.BOOKS_HEALTH,null,"10");
		
		iterateCDs(CareyCategories.MUSIC_COUNTRY,null,"16");
		iterateCDs(CareyCategories.MUSIC_BLUES,null,"31");
		iterateCDs(CareyCategories.MUSIC_METAL,null,"67207");
		iterateCDs(CareyCategories.MUSIC_POP,null,"37");
		iterateCDs(CareyCategories.MUSIC_CLASSIC_ROCK,null,"67204");
		iterateCDs(CareyCategories.MUSIC_DANCE,null,"7");
		iterateCDs(CareyCategories.MUSIC_SOUNDTRACKS,null,"42");
		iterateCDs(CareyCategories.MUSIC_JAZZ,null,"34");
		iterateCDs(CareyCategories.MUSIC_ALTERNATIVE,null,"30");
		
		iterateMovies(CareyCategories.MOVIES_ACTION,null,"2650363011");
		iterateMovies(CareyCategories.MOVIES_ANIMATION,null,"712256");
		iterateMovies(CareyCategories.MOVIES_ANIME,null,"2650364011");
		iterateMovies(CareyCategories.MOVIES_CLASSICS,null,"163345");
		iterateMovies(CareyCategories.MOVIES_COMEDY,null,"2650366011");
		iterateMovies(CareyCategories.MOVIES_DRAMA,null,"2650368011");
		iterateMovies(CareyCategories.MOVIES_HORROR,null,"2650371011");
		
		iterateMovies(CareyCategories.MOVIES_SCIFI,null,"2650376011");
		iterateMovies(CareyCategories.MOVIES_DRWHO,null,"7356240011");
		iterateMovies(CareyCategories.MOVIES_GOT,null,"10453070011");
		iterateMovies(CareyCategories.MOVIES_DC,null,"284360011");
		iterateMovies(CareyCategories.MOVIES_XMEN,null,"10125976011");
		
		iterateVideoGames(CareyCategories.VIDEO_GAMES_PS4,null,"6427831011");
		iterateVideoGames(CareyCategories.VIDEO_GAMES_PS3,null,"4924897011");
		iterateVideoGames(CareyCategories.VIDEO_GAMES_XBOX_ONE,null,"6469296011");
		iterateVideoGames(CareyCategories.VIDEO_GAMES_XBOX_360,null,"4924903011");
		iterateVideoGames(CareyCategories.VIDEO_GAMES_WII,null,"4924902011");
		iterateVideoGames(CareyCategories.VIDEO_GAMES_WII_U,null,"4924901011");
		iterateVideoGames(CareyCategories.VIDEO_GAMES_PC,null,"4924894011");
		iterateVideoGames(CareyCategories.VIDEO_GAMES_MAC,null,"4924889011");
		iterateVideoGames(CareyCategories.VIDEO_GAMES_NINTENDO_DS,null,"4924893011");
		iterateVideoGames(CareyCategories.VIDEO_GAMES_NINTENDO_3DS,null,"4924892011");
		iterateVideoGames(CareyCategories.VIDEO_GAMES_PLAYSTATION_VITA,null,"4924899011");
		iterateVideoGames(CareyCategories.VIDEO_GAMES_SONY_PSP,null,"4924900011");
		
		
				
		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_MENS_SHIRT_TYPE, CareyAttributes.TSHIRT);
		iterateMensClothing(CareyCategories.MEN_SHIRTS,"tee","1045624",attMap);
	
		
		
		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_MENS_SHORTS_TYPE, CareyAttributes.CARGO_SHORTS);
		iterateMensClothing(CareyCategories.MEN_SHORTS,"short","2476500011",attMap);
		
		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_MENS_SHORTS_TYPE, CareyAttributes.DENIM_SHORTS);
		iterateMensClothing(CareyCategories.MEN_SHORTS,"short","2476501011",attMap);
		
		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_MENS_SHORTS_TYPE, CareyAttributes.PLEATED_SHORTS);
		iterateMensClothing(CareyCategories.MEN_SHORTS,"short","2528725011",attMap);
		
		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_MENS_SHORTS_TYPE, CareyAttributes.FLAT_FRONT_SHORTS);
		iterateMensClothing(CareyCategories.MEN_SHORTS,"short","2528724011",attMap);
		

		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_WOMENS_DRESS_TYPE, CareyAttributes.CASUAL_DRESSES);
		iterateWomensClothing(CareyCategories.WOMEN_DRESSES,"dress","2346727011",attMap);
		
		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_WOMENS_DRESS_TYPE, CareyAttributes.WEAR_TO_WORK_DRESSES);
		iterateWomensClothing(CareyCategories.WOMEN_DRESSES,"dress","2346728011",attMap);

		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_WOMENS_DRESS_TYPE, CareyAttributes.NIGHT_OUT_DRESSES);
		iterateWomensClothing(CareyCategories.WOMEN_DRESSES,"dress","2346729011",attMap);

		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_WOMENS_SHORTS_TYPE, CareyAttributes.WOMEN_CASUAL_SHORTS);
		iterateWomensClothing(CareyCategories.WOMEN_SHORTS,"short","2348585011",attMap);

		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_WOMENS_SHORTS_TYPE, CareyAttributes.WOMEN_DENIM_SHORTS);
		iterateWomensClothing(CareyCategories.WOMEN_SHORTS,"short","2348586011",attMap);
		
		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_WOMENS_SHORTS_TYPE, CareyAttributes.WOMEN_DRESS_SHORTS);
		iterateWomensClothing(CareyCategories.WOMEN_SHORTS,"short","2348584011",attMap);

		iterateBlenders(CareyCategories.BLENDERS,"blender","289915");
		iterateBreadMachines(CareyCategories.BREAD_MACHINES,"bread","289917");
		iterateCoffeeMachines(CareyCategories.COFFEE_MACHINES,"coffeemaker","289745");
		iterateCoffeeMachines(CareyCategories.COFFEE_MACHINES,"coffee maker","289745");
		
		iterateCoffeeMachines(CareyCategories.ESPRESSO_MACHINES,"espresso","289748");

		iterateDeepFryers(CareyCategories.DEEP_FRYERS,"fryer","289918");
		
		iterateFoodProcessors(CareyCategories.FOOD_PROCESSORS,"processor","289920");
		
		iterateToasterOvens(CareyCategories.TOASTER_OVENS,"oven","289937");
		
		iterateCrockpots(CareyCategories.CROCKPOTS,"slow cooker","289940");
		iterateCrockpots(CareyCategories.CROCKPOTS,"crock-pot","289940");
		
		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_MATTRESS_SIZE, CareyAttributes.MATTRESS_SIZE_QUEEN);
		iterateMattresses(CareyCategories.MATTRESSES,"queen","3732981",attMap);
		
		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_MATTRESS_SIZE, CareyAttributes.MATTRESS_SIZE_TWIN);		
		iterateMattresses(CareyCategories.MATTRESSES,"twin","3732981",attMap);
		
		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_MATTRESS_SIZE, CareyAttributes.MATTRESS_SIZE_KING);
		iterateMattresses(CareyCategories.MATTRESSES,"king","3732981",attMap);
		
		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_MATTRESS_SIZE, CareyAttributes.MATTRESS_SIZE_FULL);
		iterateMattresses(CareyCategories.MATTRESSES,"full","3732981",attMap);
		
		
		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_MATTRESS_SIZE, CareyAttributes.MATTRESS_SIZE_QUEEN);
		iterateMattresses(CareyCategories.MATTRESS_SETS,"queen","3732971",attMap);
		
		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_MATTRESS_SIZE, CareyAttributes.MATTRESS_SIZE_TWIN);		
		iterateMattresses(CareyCategories.MATTRESS_SETS,"twin","3732971",attMap);
		
		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_MATTRESS_SIZE, CareyAttributes.MATTRESS_SIZE_KING);
		iterateMattresses(CareyCategories.MATTRESS_SETS,"king","3732971",attMap);
		
		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_MATTRESS_SIZE, CareyAttributes.MATTRESS_SIZE_FULL);
		iterateMattresses(CareyCategories.MATTRESS_SETS,"full","3732971",attMap);
		
		iterateDinnerware(CareyCategories.DINNERWARE,"dinner","367146011");
		
		iterateGlassware(CareyCategories.GLASSWARE,"glassware","13218751");

		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_WINE_GLASS_TYPE, CareyAttributes.WINE_GLASS_RED);
		iterateWineGlasses(CareyCategories.WINE_GLASSES,"red","13218541",attMap);

		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_WINE_GLASS_TYPE, CareyAttributes.WINE_GLASS_WHITE);
		iterateWineGlasses(CareyCategories.WINE_GLASSES,"white","13218541",attMap);

		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_WINE_GLASS_TYPE, CareyAttributes.WINE_GLASS_DESSERT);
		iterateWineGlasses(CareyCategories.WINE_GLASSES,"dessert","13218541",attMap);

		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_WINE_GLASS_TYPE, CareyAttributes.WINE_GLASS_STEMLESS);
		iterateWineGlasses(CareyCategories.WINE_GLASSES,"stemless","13218541",attMap);

		attMap = new HashMap<String,String>();
		attMap.put(CareyAttributes.LABEL_WINE_GLASS_TYPE, CareyAttributes.WINE_GLASS_CHAMPAGNE);
		iterateWineGlasses(CareyCategories.WINE_GLASSES,"champagne","13218541",attMap);
		iterateFlatware(CareyCategories.FLATWARE,"flatware","367232011");

	*/
		
		//too many all-in-one printers
		//iterateDesktops(CareyCategories.ALL_IN_ONE_COMPUTERS,"all-in-one desktop","541966","desktop");
		
		LOGGER.info("all done!");
	}
	
	/*private void iterateEntertainmentCentersByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMustInclude("entertainment center");
		parse.setMaxPages(5);
		parse.setMinimumPrice(29f);
		parse.iterateAmazon();		
	}

	
	private void iterateEntertainmentCenters(String category, String keyword, String node) {
		iterateEntertainmentCentersByBrand(category, keyword, node, "247SHOPATHOME");
		iterateEntertainmentCentersByBrand(category, keyword, node, "Coaster Home Furnishings");
		iterateEntertainmentCentersByBrand(category, keyword, node, "Convenience Concepts");
		iterateEntertainmentCentersByBrand(category, keyword, node, "Crimson AV");
		iterateEntertainmentCentersByBrand(category, keyword, node, "Eagle Furniture");
		iterateEntertainmentCentersByBrand(category, keyword, node, "Hooker Furniture");
		iterateEntertainmentCentersByBrand(category, keyword, node, "L&L Merchandise");
		iterateEntertainmentCentersByBrand(category, keyword, node, "Legends Furniture");
		iterateEntertainmentCentersByBrand(category, keyword, node, "Michael Anthony Furniture");
		iterateEntertainmentCentersByBrand(category, keyword, node, "Milestones");
		iterateEntertainmentCentersByBrand(category, keyword, node, "Nexera");
		iterateEntertainmentCentersByBrand(category, keyword, node, "Peerless");
		iterateEntertainmentCentersByBrand(category, keyword, node, "Premier Mounts");
		iterateEntertainmentCentersByBrand(category, keyword, node, "Riverside Furniture");
		iterateEntertainmentCentersByBrand(category, keyword, node, "Sauder");
		iterateEntertainmentCentersByBrand(category, keyword, node, "Techlink");
		iterateEntertainmentCentersByBrand(category, keyword, node, null);
	}
	
	
	private void iterateOttomansByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMustInclude("ottoman");
		parse.setMaxPages(5);
		parse.setMinimumPrice(26.8f);
		parse.iterateAmazon();		
	}

	
	private void iterateOttomans(String category, String keyword, String node) {
		iterateOttomansByBrand(category, keyword, node, "Coaster Home Furnishings");
		iterateOttomansByBrand(category, keyword, node, "Home Decorators Collection");
		iterateOttomansByBrand(category, keyword, node, "Homelegance");
		iterateOttomansByBrand(category, keyword, node, "Lalhaveli");
		iterateOttomansByBrand(category, keyword, node, "RajRang");
		iterateOttomansByBrand(category, keyword, node, "Warehouse of Tiffany");
		iterateOttomansByBrand(category, keyword, node, null);
	}
	
	
	private void iterateEndTablesByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMinimumPrice(10f);
		parse.iterateAmazon();		
	}

	
	private void iterateEndTables(String category, String keyword, String node) {
		iterateEndTablesByBrand(category, keyword, node, "247SHOPATHOME");
		iterateEndTablesByBrand(category, keyword, node, "Coaster Home Furnishings");
		iterateEndTablesByBrand(category, keyword, node, "Famous Brand Furniture");
		iterateEndTablesByBrand(category, keyword, node, "Furniture of America");
		iterateEndTablesByBrand(category, keyword, node, "Home Decorators Collection");
		iterateEndTablesByBrand(category, keyword, node, "Riverside Furniture");
		iterateEndTablesByBrand(category, keyword, node, "Southern Enterprises");
		iterateEndTablesByBrand(category, keyword, node, "Steve Silver");
		iterateEndTablesByBrand(category, keyword, node, "The Furniture Cove");
		iterateEndTablesByBrand(category, keyword, node, "Winsome");
		iterateEndTablesByBrand(category, keyword, node, "Sauder");
		iterateEndTablesByBrand(category, keyword, node, "Ashley");
		iterateEndTablesByBrand(category, keyword, node, null);
	}
	
	
	private void iterateCoffeeTablesByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMustInclude("coffee");
		parse.setMinimumPrice(20f);
		parse.iterateAmazon();		
	}

	
	private void iterateCoffeeTables(String category, String keyword, String node) {
		iterateCoffeeTablesByBrand(category, keyword, node, "247SHOPATHOME");
		iterateCoffeeTablesByBrand(category, keyword, node, "Coaster Home Furnishings");
		iterateCoffeeTablesByBrand(category, keyword, node, "Famous Brand Furniture");
		iterateCoffeeTablesByBrand(category, keyword, node, "Furniture of America");
		iterateCoffeeTablesByBrand(category, keyword, node, "Home Decorators Collection");
		iterateCoffeeTablesByBrand(category, keyword, node, "Riverside Furniture");
		iterateCoffeeTablesByBrand(category, keyword, node, "Southern Enterprises");
		iterateCoffeeTablesByBrand(category, keyword, node, "Steve Silver");
		iterateCoffeeTablesByBrand(category, keyword, node, "The Furniture Cove");
		iterateCoffeeTablesByBrand(category, keyword, node, "Winsome");
		iterateCoffeeTablesByBrand(category, keyword, node, "Sauder");
		iterateCoffeeTablesByBrand(category, keyword, node, "Ashley");
		iterateCoffeeTablesByBrand(category, keyword, node, null);
	}
	
	
	private void iterateLivingRoomLoveSeatsByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMinimumPrice(30f);
		parse.iterateAmazon();		
	}

	
	private void iterateLivingRoomLoveSeats(String category, String keyword, String node) {
		iterateLivingRoomLoveSeatsByBrand(category, keyword, node, "AC Pacific");
		iterateLivingRoomLoveSeatsByBrand(category, keyword, node, "ACME");
		iterateLivingRoomLoveSeatsByBrand(category, keyword, node, "Ashley");
		iterateLivingRoomLoveSeatsByBrand(category, keyword, node, "Baxton Studio");
		iterateLivingRoomLoveSeatsByBrand(category, keyword, node, "Chelsea Home Furniture");
		iterateLivingRoomLoveSeatsByBrand(category, keyword, node, "Coaster Home Furnishings");
		iterateLivingRoomLoveSeatsByBrand(category, keyword, node, "Famous Brand Furniture");
		iterateLivingRoomLoveSeatsByBrand(category, keyword, node, "Flash Furniture");
		iterateLivingRoomLoveSeatsByBrand(category, keyword, node, "Furniture Of America");
		iterateLivingRoomLoveSeatsByBrand(category, keyword, node, "J and M Furniture");
		iterateLivingRoomLoveSeatsByBrand(category, keyword, node, "Homelegance");
		iterateLivingRoomLoveSeatsByBrand(category, keyword, node, "LexMod");
		iterateLivingRoomLoveSeatsByBrand(category, keyword, node, "Office Star");
		iterateLivingRoomLoveSeatsByBrand(category, keyword, node, "Poundex");
		iterateLivingRoomLoveSeatsByBrand(category, keyword, node, "Simmons Upholstery");
		iterateLivingRoomLoveSeatsByBrand(category, keyword, node, null);
	}
	
	
	private void iterateLivingRoomSofaSetsByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		//parse.setMustInclude("set");
		parse.setMinimumPrice(50f);
		parse.iterateAmazon();		
	}

	
	private void iterateLivingRoomSofaSets(String category, String keyword, String node) {
		iterateLivingRoomSofaSetsByBrand(category, keyword, node, "AC Pacific");
		iterateLivingRoomSofaSetsByBrand(category, keyword, node, "ACME");
		iterateLivingRoomSofaSetsByBrand(category, keyword, node, "Ashley");
		iterateLivingRoomSofaSetsByBrand(category, keyword, node, "Baxton Studio");
		iterateLivingRoomSofaSetsByBrand(category, keyword, node, "Chelsea Home Furniture");
		iterateLivingRoomSofaSetsByBrand(category, keyword, node, "Coaster Home Furnishings");
		iterateLivingRoomSofaSetsByBrand(category, keyword, node, "Famous Brand Furniture");
		iterateLivingRoomSofaSetsByBrand(category, keyword, node, "Flash Furniture");
		iterateLivingRoomSofaSetsByBrand(category, keyword, node, "Furniture Of America");
		iterateLivingRoomSofaSetsByBrand(category, keyword, node, "J and M Furniture");
		iterateLivingRoomSofaSetsByBrand(category, keyword, node, "Homelegance");
		iterateLivingRoomSofaSetsByBrand(category, keyword, node, "LexMod");
		iterateLivingRoomSofaSetsByBrand(category, keyword, node, "Office Star");
		iterateLivingRoomSofaSetsByBrand(category, keyword, node, "Poundex");
		iterateLivingRoomSofaSetsByBrand(category, keyword, node, "Simmons Upholstery");
		iterateLivingRoomSofaSetsByBrand(category, keyword, node, null);
	}
	
	
	private void iterateLivingRoomChairsByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMinimumPrice(20f);
		parse.iterateAmazon();		
	}

	
	private void iterateLivingRoomChairs(String category, String keyword, String node) {
		iterateLivingRoomChairsByBrand(category, keyword, node, "ACME");
		iterateLivingRoomChairsByBrand(category, keyword, node, "Baxton Studio");
		iterateLivingRoomChairsByBrand(category, keyword, node, "Coaster Home Furnishings");
		iterateLivingRoomChairsByBrand(category, keyword, node, "Flash Furniture");
		iterateLivingRoomChairsByBrand(category, keyword, node, "Great Deal Furniture");
		iterateLivingRoomChairsByBrand(category, keyword, node, "Lane Furniture");
		iterateLivingRoomChairsByBrand(category, keyword, node, "LexMod");
		iterateLivingRoomChairsByBrand(category, keyword, node, "Madison Park");
		iterateLivingRoomChairsByBrand(category, keyword, node, "ModHaus");
		iterateLivingRoomChairsByBrand(category, keyword, node, null);
	}

	
	private void iterateWineGlassesByBrand(String category, String keyword, String node,String brand,Map<String,String> attMap) {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setFixedAttributes(attMap);
		parse.setAmazonOnly(false);
		parse.setMustInclude("set");
		parse.setMinimumPrice(10f);
		parse.iterateAmazon();		
	}

	
	private void iterateWineGlasses(String category, String keyword, String node,Map<String,String> attMap) {
		iterateWineGlassesByBrand(category, keyword, node, "Arc International",attMap);
		iterateWineGlassesByBrand(category, keyword, node, "Bormioli Rocco",attMap);
		iterateWineGlassesByBrand(category, keyword, node, "Burton & Burton",attMap);
		iterateWineGlassesByBrand(category, keyword, node, "Home Essentials",attMap);
		iterateWineGlassesByBrand(category, keyword, node, "Marquis By Waterford",attMap);
		iterateWineGlassesByBrand(category, keyword, node, "Santa Barbara Design Studio",attMap);
		iterateWineGlassesByBrand(category, keyword, node, "The Wine Enthusiast",attMap);
		iterateWineGlassesByBrand(category, keyword, node, "Top Shelf",attMap);
		iterateWineGlassesByBrand(category, keyword, node, null,attMap);
	}
	
	private void iterateGlasswareByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMustInclude("set");
		parse.setMinimumPrice(15f);
		parse.iterateAmazon();		
	}

	
	private void iterateGlassware(String category, String keyword, String node) {
		iterateGlasswareByBrand(category, keyword, node, "Libbey");
		iterateGlasswareByBrand(category, keyword, node, "Home Essentials");
		iterateGlasswareByBrand(category, keyword, node, "Certified International");
		iterateGlasswareByBrand(category, keyword, node, null);
	}
	
	
	private void iterateFlatwareByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMustInclude("service for");
		parse.setMinimumPrice(15f);
		parse.iterateAmazon();		
	}

	
	private void iterateFlatware(String category, String keyword, String node) {
		iterateFlatwareByBrand(category, keyword, node, "Cambridge Silversmiths");
		iterateFlatwareByBrand(category, keyword, node, "Cuisinart");
		iterateFlatwareByBrand(category, keyword, node, "Farberware");
		iterateFlatwareByBrand(category, keyword, node, "Gibson");
		iterateFlatwareByBrand(category, keyword, node, "Ginkgo International");
		iterateFlatwareByBrand(category, keyword, node, "International Silver");
		iterateFlatwareByBrand(category, keyword, node, "Lenox");
		iterateFlatwareByBrand(category, keyword, node, "Oneida");
		iterateFlatwareByBrand(category, keyword, node, "Pfaltzgraff");
		iterateFlatwareByBrand(category, keyword, node, "Reed & Barton");
		iterateFlatwareByBrand(category, keyword, node, "Towle Living");
		iterateFlatwareByBrand(category, keyword, node, "Wallace");
		iterateFlatwareByBrand(category, keyword, node, "Winco");
		iterateFlatwareByBrand(category, keyword, node, "WMF");
		iterateFlatwareByBrand(category, keyword, node, null);
	}
	
	
	private void iterateDinnerwareByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMustInclude("16");
		parse.setMinimumPrice(15f);
		parse.iterateAmazon();		
	}
	
	private void iterateDinnerware(String category, String keyword, String node) {
		iterateDinnerwareByBrand(category, keyword, node, "ACK");
		iterateDinnerwareByBrand(category, keyword, node, "American Atelier");
		iterateDinnerwareByBrand(category, keyword, node, "Corelle Coordinates");
		iterateDinnerwareByBrand(category, keyword, node, "Franmara");
		iterateDinnerwareByBrand(category, keyword, node, "Gibson");
		iterateDinnerwareByBrand(category, keyword, node, "kate spade new york");
		iterateDinnerwareByBrand(category, keyword, node, "Mikasa");
		iterateDinnerwareByBrand(category, keyword, node, "Oneida");
		iterateDinnerwareByBrand(category, keyword, node, "Royal Doulton");
		iterateDinnerwareByBrand(category, keyword, node, "Sango");
		iterateDinnerwareByBrand(category, keyword, node, "Cuisinart");
		iterateDinnerwareByBrand(category, keyword, node, "Dansk");
		iterateDinnerwareByBrand(category, keyword, node, "Gibson Elite");
		iterateDinnerwareByBrand(category, keyword, node, "Gibson Home");
		iterateDinnerwareByBrand(category, keyword, node, "Home Laughlin");
		iterateDinnerwareByBrand(category, keyword, node, "Johnson Brothers");
		iterateDinnerwareByBrand(category, keyword, node, null);
	}
	
	
	private void iterateDiningRoomSetsByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMustInclude("dining");
		parse.setMinimumPrice(149f);
		parse.iterateAmazon();		
	}

	private void iterateDiningRoomSets(String category, String keyword, String node) {
		iterateDiningRoomSetsByBrand(category, keyword, node, "247SHOPATHOME");
		iterateDiningRoomSetsByBrand(category, keyword, node, "ACM");
		iterateDiningRoomSetsByBrand(category, keyword, node, "ACME");
		iterateDiningRoomSetsByBrand(category, keyword, node, "Acme Furniture");
		iterateDiningRoomSetsByBrand(category, keyword, node, "Coaster Home Furnishings");
		iterateDiningRoomSetsByBrand(category, keyword, node, "East West Furniture");
		iterateDiningRoomSetsByBrand(category, keyword, node, "Furniture Of America");
		iterateDiningRoomSetsByBrand(category, keyword, node, "Hillsdale Furniture");
		iterateDiningRoomSetsByBrand(category, keyword, node, "L&L Merchandise");
		iterateDiningRoomSetsByBrand(category, keyword, node, "Pastel Furniture");
		iterateDiningRoomSetsByBrand(category, keyword, node, "Sierra Living Concepts");
		iterateDiningRoomSetsByBrand(category, keyword, node, "Standard Furniture");
		iterateDiningRoomSetsByBrand(category, keyword, node, "Stanley Furniture");
		iterateDiningRoomSetsByBrand(category, keyword, node, "StarSun Depot");
		iterateDiningRoomSetsByBrand(category, keyword, node, "Steve Silver Furniture");
		iterateDiningRoomSetsByBrand(category, keyword, node, "Steve Silver");
		iterateDiningRoomSetsByBrand(category, keyword, node, "Vertigo Interiors USA");
		iterateDiningRoomSetsByBrand(category, keyword, node, null);
	}
	
	private void iterateComfortersByBrand(String category, String keyword, String node,String brand,Map<String,String> attMap) {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setFixedAttributes(attMap);
		parse.setAmazonOnly(false);
		parse.setMustInclude(keyword);
		parse.setMinimumPrice(20f);
		parse.iterateAmazon();		
	}

	private void iterateComforters(String category, String keyword, String node,Map<String,String> attMap) {
		iterateComfortersByBrand(category, keyword, node, "Chezmoi Collection",attMap);
		iterateComfortersByBrand(category, keyword, node, "Cozy Beddings",attMap);
		iterateComfortersByBrand(category, keyword, node, "Geneva Home Fashion",attMap);
		iterateComfortersByBrand(category, keyword, node, "Intelligent Design",attMap);
		iterateComfortersByBrand(category, keyword, node, "JD Home",attMap);
		iterateComfortersByBrand(category, keyword, node, "KingLinen",attMap);
		iterateComfortersByBrand(category, keyword, node, "Lavish Home",attMap);
		iterateComfortersByBrand(category, keyword, node, "Legacy Decor",attMap);
		iterateComfortersByBrand(category, keyword, node, "Madison Park",attMap);
		iterateComfortersByBrand(category, keyword, node, "Mi-Zone",attMap);
		iterateComfortersByBrand(category, keyword, node, "Nanshing",attMap);
		iterateComfortersByBrand(category, keyword, node, "Northwest",attMap);
		iterateComfortersByBrand(category, keyword, node, "Perfect Home",attMap);
		iterateComfortersByBrand(category, keyword, node, "sheetsnthings",attMap);
		iterateComfortersByBrand(category, keyword, node, "Victoria Classics",attMap);
		iterateComfortersByBrand(category, keyword, node, null,attMap);
	}
	
	private void iterateNightstandsByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMinimumPrice(20f);
		parse.iterateAmazon();		
	}

	private void iterateNightstands(String category, String keyword, String node) {
		iterateNightstandsByBrand(category, keyword, node, "247SHOPATHOME");
		iterateNightstandsByBrand(category, keyword, node, "ACME");
		iterateNightstandsByBrand(category, keyword, node, "Coaster Home Furnishings");
		iterateNightstandsByBrand(category, keyword, node, "Famous Brand Furniture");
		iterateNightstandsByBrand(category, keyword, node, "Furniture Of America");
		iterateNightstandsByBrand(category, keyword, node, "Homelegance");
		iterateNightstandsByBrand(category, keyword, node, "Montana Woodworks");
		iterateNightstandsByBrand(category, keyword, node, "Prepac");
		iterateNightstandsByBrand(category, keyword, node, "South Shore");
		iterateNightstandsByBrand(category, keyword, node, "Standard Furniture");
		iterateNightstandsByBrand(category, keyword, node, "The Furniture Cove");
		iterateNightstandsByBrand(category, keyword, node, "Winsome");
		iterateNightstandsByBrand(category, keyword, node, null);
	}
	
	
	private void iterateMattressesByBrand(String category, String keyword, String node,String brand,Map<String,String> attMap) {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setFixedAttributes(attMap);
		parse.setAmazonOnly(false);
		parse.setMustInclude(keyword);
		parse.setMaxPages(5);
		parse.setMinimumPrice(50f);
		parse.iterateAmazon();		
	}

	private void iterateMattresses(String category, String keyword, String node,Map<String,String> attMap) {
		iterateMattressesByBrand(category, keyword, node, "Best Price Mattress",attMap);
		iterateMattressesByBrand(category, keyword, node, "Beautyrest",attMap);
		iterateMattressesByBrand(category, keyword, node, "Classic Brands",attMap);
		iterateMattressesByBrand(category, keyword, node, "DynastyMattress",attMap);
		iterateMattressesByBrand(category, keyword, node, "Night Therapy",attMap);
		iterateMattressesByBrand(category, keyword, node, "Best Price Mattress",attMap);
		iterateMattressesByBrand(category, keyword, node, "Simmons",attMap);
		iterateMattressesByBrand(category, keyword, node, "Sleep Master",attMap);
		iterateMattressesByBrand(category, keyword, node, null,attMap);
	}
	
	private void iterateDressersByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMustInclude("dresser");
		parse.setMinimumPrice(50f);
		parse.iterateAmazon();		
	}

	private void iterateDressers(String category, String keyword, String node) {
		iterateDressersByBrand(category, keyword, node, "American Drew");
		iterateDressersByBrand(category, keyword, node, "Bassett Mirror Company");
		iterateDressersByBrand(category, keyword, node, "Coaster Home Furnishings");
		iterateDressersByBrand(category, keyword, node, "Famous Brand Furniture");
		iterateDressersByBrand(category, keyword, node, "Furniture Of America");
		iterateDressersByBrand(category, keyword, node, "Homelegance");
		iterateDressersByBrand(category, keyword, node, "Hooker Furniture");
		iterateDressersByBrand(category, keyword, node, "Improvements");
		iterateDressersByBrand(category, keyword, node, "Liberty");
		iterateDressersByBrand(category, keyword, node, "Magnussen");
		iterateDressersByBrand(category, keyword, node, "MegaDeal");
		iterateDressersByBrand(category, keyword, node, "South Shore");
		iterateDressersByBrand(category, keyword, node, "Tommy Bahama");
		iterateDressersByBrand(category, keyword, node, null);
	}
	
	private void iterateArmoiresByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMustInclude("armoire");
		parse.setMinimumPrice(50f);
		parse.iterateAmazon();		
	}

	private void iterateArmoires(String category, String keyword, String node) {
		iterateArmoiresByBrand(category, keyword, node, "Ballard Designs");
		iterateArmoiresByBrand(category, keyword, node, "Coaster Home Furnishings");
		iterateArmoiresByBrand(category, keyword, node, "Homelegance");
		iterateArmoiresByBrand(category, keyword, node, "IKEA");
		iterateArmoiresByBrand(category, keyword, node, "eHomeProducts");
		iterateArmoiresByBrand(category, keyword, node, "Sauder");
		iterateArmoiresByBrand(category, keyword, node, "South Shore");
		iterateArmoiresByBrand(category, keyword, node, "Palace Imports");
		iterateArmoiresByBrand(category, keyword, node,  null);
	}
	
	private void iterateCrockpotsByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMaxPages(5);
		parse.setMinimumPrice(10f);
		parse.iterateAmazon();		
	}

	private void iterateCrockpots(String category, String keyword, String node) {
		iterateCrockpotsByBrand(category, keyword, node, "Crock-Pot");
		iterateCrockpotsByBrand(category, keyword, node, "Proctor Silex");
		iterateCrockpotsByBrand(category, keyword, node, "Hamilton Beach");
		iterateCrockpotsByBrand(category, keyword, node, "West Bend");
		iterateCrockpotsByBrand(category, keyword, node,  null);
	}

	private void iterateToasterOvensByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMaxPages(5);
		parse.setMinimumPrice(10f);
		parse.iterateAmazon();		
	}

	private void iterateToasterOvens(String category, String keyword, String node) {
		iterateToasterOvensByBrand(category, keyword, node, "Black & Decker");
		iterateToasterOvensByBrand(category, keyword, node, "AytraHome");
		iterateToasterOvensByBrand(category, keyword, node, "Better Chef");
		iterateToasterOvensByBrand(category, keyword, node, "Cuisinart");
		iterateToasterOvensByBrand(category, keyword, node, "Hamilton Beach");
		iterateToasterOvensByBrand(category, keyword, node, "Panasonic");
		iterateToasterOvensByBrand(category, keyword, node, "Proctor Silex");
		iterateToasterOvensByBrand(category, keyword, node, "Toastmaster");
		iterateToasterOvensByBrand(category, keyword, node, "Aavnti");
		iterateToasterOvensByBrand(category, keyword, node, "Applica");
		iterateToasterOvensByBrand(category, keyword, node,  null);
	}
	
	
	private void iterateFoodProcessorsByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMaxPages(5);
		parse.setMinimumPrice(24.5f);
		parse.iterateAmazon();		
	}

	private void iterateFoodProcessors(String category, String keyword, String node) {
		iterateFoodProcessorsByBrand(category, keyword, node, "Black & Decker");
		iterateFoodProcessorsByBrand(category, keyword, node, "Cuisinart");
		iterateFoodProcessorsByBrand(category, keyword, node, "Hamilton Beach");
		iterateFoodProcessorsByBrand(category, keyword, node, "Kenwood");
		iterateFoodProcessorsByBrand(category, keyword, node, "Oster");
		iterateFoodProcessorsByBrand(category, keyword, node, "Waring");
		iterateFoodProcessorsByBrand(category, keyword, node,  null);
	}
	
	
	private void iterateDeepFryersByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMaxPages(5);
		parse.setMinimumPrice(10f);
		parse.iterateAmazon();		
	}

	private void iterateDeepFryers(String category, String keyword, String node) {
		iterateDeepFryersByBrand(category, keyword, node, "DeLonghi");
		iterateDeepFryersByBrand(category, keyword, node, "Hamilton Beach");
		iterateDeepFryersByBrand(category, keyword, node, "Presto");
		iterateDeepFryersByBrand(category, keyword, node, "Waring");
		iterateDeepFryersByBrand(category, keyword, node, null);
	}
	
	
	private void iterateCoffeeMachinesByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMaxPages(3);
		parse.setMinimumPrice(10f);
		parse.iterateAmazon();		
	}

	private void iterateCoffeeMachines(String category, String keyword, String node) {
		iterateCoffeeMachinesByBrand(category, keyword, node, "Better Chef");
		iterateCoffeeMachinesByBrand(category, keyword, node, "Black & Decker");
		iterateCoffeeMachinesByBrand(category, keyword, node, "Bodum");
		iterateCoffeeMachinesByBrand(category, keyword, node, "Capresso");
		iterateCoffeeMachinesByBrand(category, keyword, node, "Cuisinart");
		iterateCoffeeMachinesByBrand(category, keyword, node, "DeLonghi");
		iterateCoffeeMachinesByBrand(category, keyword, node, "Hamilton Beach");
		iterateCoffeeMachinesByBrand(category, keyword, node, "Hario");
		iterateCoffeeMachinesByBrand(category, keyword, node, "Keurig");
		iterateCoffeeMachinesByBrand(category, keyword, node, "KitchenAid");
		iterateCoffeeMachinesByBrand(category, keyword, node, "Mr. Coffee");
		iterateCoffeeMachinesByBrand(category, keyword, node, "Proctor Silex");
		iterateCoffeeMachinesByBrand(category, keyword, node, "Gaggia");
		iterateCoffeeMachinesByBrand(category, keyword, node, "KitchenAid");
		iterateCoffeeMachinesByBrand(category, keyword, node, null);
	}
	
	
	private void iterateBreadMachinesByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMaxPages(5);
		parse.setMinimumPrice(28.5f);
		parse.iterateAmazon();		
	}

	private void iterateBreadMachines(String category, String keyword, String node) {
		iterateBreadMachinesByBrand(category, keyword, node, "Breadman");
		iterateBreadMachinesByBrand(category, keyword, node, "Hamilton Beach");
		iterateBreadMachinesByBrand(category, keyword, node, "Panasonic");
		iterateBreadMachinesByBrand(category, keyword, node, null);
	}
	
	
	private void iterateBlendersByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		//parse.setAmazonOnly(false);
		parse.setMaxPages(5);
		parse.setMinimumPrice(16f);
		parse.iterateAmazon();		
	}

	private void iterateBlenders(String category, String keyword, String node) {
		iterateBlendersByBrand(category, keyword, node, "Back To Basics");
		iterateBlendersByBrand(category, keyword, node, "Black & Decker");
		iterateBlendersByBrand(category, keyword, node, "Blendtec");
		iterateBlendersByBrand(category, keyword, node, "Brentwood");
		iterateBlendersByBrand(category, keyword, node, "Hamilton Beach");
		iterateBlendersByBrand(category, keyword, node, "KitchenAid");
		iterateBlendersByBrand(category, keyword, node, "Omega");
		iterateBlendersByBrand(category, keyword, node, "Vitamix");
		iterateBlendersByBrand(category, keyword, node, "Waring");
		iterateBlendersByBrand(category, keyword, node, null);
	}
	
	
	private void iterateBeerKegRefrigeratorsByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMaxPages(5);
		parse.setMinimumPrice(99f);
		parse.iterateAmazon();		
	}

	private void iterateBeerKegRefrigerators(String category, String keyword, String node) {
		iterateBeerKegRefrigeratorsByBrand(category, keyword, node, "Beverage Air");
		iterateBeerKegRefrigeratorsByBrand(category, keyword, node, "EdgeStar");
		iterateBeerKegRefrigeratorsByBrand(category, keyword, node, "Marvel");
		iterateBeerKegRefrigeratorsByBrand(category, keyword, node, "Summit");
		iterateBeerKegRefrigeratorsByBrand(category, keyword, node, "Turbo Air");
		iterateBeerKegRefrigeratorsByBrand(category, keyword, node, "wallthat");
		iterateBeerKegRefrigeratorsByBrand(category, keyword, node, null);
	}
	
	
	private void iterateWineCellarsByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMaxPages(5);
		parse.setMinimumPrice(24f);
		parse.iterateAmazon();		
	}

	private void iterateWineCellars(String category, String keyword, String node) {
		iterateWineCellarsByBrand(category, keyword, node, "Allavino");
		iterateWineCellarsByBrand(category, keyword, node, "Avanti");
		iterateWineCellarsByBrand(category, keyword, node, "HOMEIMAGE");
		iterateWineCellarsByBrand(category, keyword, node, "NewAir");
		iterateWineCellarsByBrand(category, keyword, node, "Summit");
		iterateWineCellarsByBrand(category, keyword, node, "Summit Appliance");
		iterateWineCellarsByBrand(category, keyword, node, "The Wine Enthusiast");
		iterateWineCellarsByBrand(category, keyword, node, "Whynter");
		iterateWineCellarsByBrand(category, keyword, node, null);
	}
	
	private void iterateWashersByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMustInclude("washer");
		parse.setMinimumPrice(99f);
		parse.iterateAmazon();		
	}

	private void iterateWashers(String category, String keyword, String node) {
		iterateWashersByBrand(category, keyword, node, "Whirlpool");
		iterateWashersByBrand(category, keyword, node, "LG");
		iterateWashersByBrand(category, keyword, node, "Maytag");
		iterateWashersByBrand(category, keyword, node, "Electrolux");
		iterateWashersByBrand(category, keyword, node, "Frigidaire");
		iterateWashersByBrand(category, keyword, node, null);
	}

	private void iterateDryersByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMustInclude("dryer");
		parse.setMinimumPrice(99f);
		parse.iterateAmazon();		
	}

	private void iterateDryers(String category, String keyword, String node) {
		iterateDryersByBrand(category, keyword, node, "Whirlpool");
		iterateDryersByBrand(category, keyword, node, "LG");
		iterateDryersByBrand(category, keyword, node, "Maytag");
		iterateDryersByBrand(category, keyword, node, null);
	}
	
	private void iterateRefrigeratorsByBrand(String category, String keyword, String node,Map<String,String> attMap, String brand) {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setFixedAttributes(attMap);
		parse.setMinimumPrice(99f);
		parse.setAmazonOnly(false);
		parse.iterateAmazon();		
	}
	
	
	private void iterateRefrigerators(String category, String keyword, String node,Map<String,String> attMap) {
		iterateRefrigeratorsByBrand(category, keyword, node, attMap, "Frigidaire");
		iterateRefrigeratorsByBrand(category, keyword, node, attMap, "General Electric");
		iterateRefrigeratorsByBrand(category, keyword, node, attMap, "Whirlpool");
		iterateRefrigeratorsByBrand(category, keyword, node, attMap, "Amana");
		iterateRefrigeratorsByBrand(category, keyword, node, attMap, "Blomberg");
		iterateRefrigeratorsByBrand(category, keyword, node, attMap, "Fisher & Paykel");
		iterateRefrigeratorsByBrand(category, keyword, node, attMap, "GE");
		iterateRefrigeratorsByBrand(category, keyword, node, attMap, "LG");
		iterateRefrigeratorsByBrand(category, keyword, node, attMap, "Liebherr");
		iterateRefrigeratorsByBrand(category, keyword, node, attMap, "Maytag");
		iterateRefrigeratorsByBrand(category, keyword, node, attMap, null);
	}
	

	private void iterateRangesByBrand(String category, String keyword, String node,Map<String,String> attMap, String brand) {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setFixedAttributes(attMap);
		parse.setMustInclude("range");
		parse.setMinimumPrice(199f);
		parse.setAmazonOnly(false);
		parse.iterateAmazon();		
	}
	
	
	private void iterateRanges(String category, String keyword, String node,Map<String,String> attMap) {
		iterateRangesByBrand(category, keyword, node, attMap, "Frigidaire");
		iterateRangesByBrand(category, keyword, node, attMap, "General Electric");
		iterateRangesByBrand(category, keyword, node, attMap, "Whirlpool");
		iterateRangesByBrand(category, keyword, node, attMap, null);
	}
	
	
	private void iterateMicrowavesByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMustInclude("microwave");
		parse.setMaxPages(5);
		parse.setMinimumPrice(24f);
		parse.iterateAmazon();		
	}

	private void iterateMicrowaves(String category, String keyword, String node) {
		iterateMicrowavesByBrand(category, keyword, node, "Avanti");
		iterateMicrowavesByBrand(category, keyword, node, "Amana");
		iterateMicrowavesByBrand(category, keyword, node, "Frigidaire");
		iterateMicrowavesByBrand(category, keyword, node, "General Electric");
		iterateMicrowavesByBrand(category, keyword, node, "Magic Chef");
		iterateMicrowavesByBrand(category, keyword, node, "Oster");
		iterateMicrowavesByBrand(category, keyword, node, "Panasonic");
		iterateMicrowavesByBrand(category, keyword, node, "Sharp");
		iterateMicrowavesByBrand(category, keyword, node, null);
	}
	
	private void iterateDishwashersByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMustInclude("dishwasher");
		parse.setMinimumPrice(99f);
		parse.iterateAmazon();		
	}

	private void iterateDishwashers(String category, String keyword, String node) {
		iterateDishwashersByBrand(category, keyword, node, "Aftermarket");
		iterateDishwashersByBrand(category, keyword, node, "Blomberg");
		iterateDishwashersByBrand(category, keyword, node, "Fisher & Paykel");
		iterateDishwashersByBrand(category, keyword, node, "Frigidaire");
		iterateDishwashersByBrand(category, keyword, node, "GE");
		iterateDishwashersByBrand(category, keyword, node, "General Electric");
		iterateDishwashersByBrand(category, keyword, node, "Kit. Aid Replacement");
		iterateDishwashersByBrand(category, keyword, node, "Maytag");
		iterateDishwashersByBrand(category, keyword, node, "Miele");
		iterateDishwashersByBrand(category, keyword, node, "Samsung");
		iterateDishwashersByBrand(category, keyword, node, null);
	}

	
	private void iterateFreezers(String category, String keyword, String node,Map<String,String> attMap) {
		AmazonParseProcessor parse = new AmazonParseProcessor(null,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setFixedAttributes(attMap);
		parse.setMustInclude("freezer");
		parse.setMinimumPrice(99f);
		parse.iterateAmazon();			
	}
	*/
	
	private void iterateWomenByBrand(Category category, String keyword, String node,String brand, int maxPages) {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,outputFile);
		parse.setMaxPages(maxPages);
		parse.iterateAmazon();		
	}
	
	private void iterateWomensClothing(Category category, String keyword, String node) {
		int maxPages = 5;
		
		iterateWomenByBrand(category, keyword, node, "Adrianna Papell",maxPages);
		iterateWomenByBrand(category, keyword, node, "BCBGeneration",maxPages);
		iterateWomenByBrand(category, keyword, node, "BCBGMAXAZRIA",maxPages);
		iterateWomenByBrand(category, keyword, node, "French Connection",maxPages);
		iterateWomenByBrand(category, keyword, node, "Halston Heritage",maxPages);
		iterateWomenByBrand(category, keyword, node, "Jessica Simpson",maxPages);
		iterateWomenByBrand(category, keyword, node, "7 For All Mankind",maxPages);
		iterateWomenByBrand(category, keyword, node, "DKNY Jeans",maxPages);
		iterateWomenByBrand(category, keyword, node, "Hudson Jeans",maxPages);
		iterateWomenByBrand(category, keyword, node, "Silver Jeans Co.",maxPages);
		iterateWomenByBrand(category, keyword, node, "True Religion",maxPages);
		iterateWomenByBrand(category, keyword, node, "Lee",maxPages);
		iterateWomenByBrand(category, keyword, node, "Wrangler",maxPages);
		iterateWomenByBrand(category, keyword, node, "Calvin Klein",maxPages);
		iterateWomenByBrand(category, keyword, node, "2LUV",maxPages);
		iterateWomenByBrand(category, keyword, node,"Levi's",maxPages);
		iterateWomenByBrand(category, keyword, node,"Hudson Jeans",maxPages);
		iterateWomenByBrand(category, keyword, node,"Lucky Brand",maxPages);
		iterateWomenByBrand(category, keyword, node,"Aeropostale",maxPages);
		iterateWomenByBrand(category, keyword, node,"Miss Me",maxPages);
		iterateWomenByBrand(category, keyword, node,"NYDJ",maxPages);
		iterateWomenByBrand(category, keyword, node,"PAIGE",maxPages);
		iterateWomenByBrand(category, keyword, node,"WallFlower Jeans",maxPages);
		iterateWomenByBrand(category, keyword, node, null,10);
	}

	private void iterateMenByBrand(Category category, String keyword, String node, String brand,int maxPages)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,outputFile);
		//parse.setDb(db);
		//parse.setFixedAttributes(attMap);
		parse.setMaxPages(maxPages);
		parse.iterateAmazon();		
	}

	private void iterateMensClothing(Category category, String keyword, String node) {
		int maxPages = 2;
		
		iterateMenByBrand(category, keyword, node,"Calvin Klein",maxPages);
		iterateMenByBrand(category, keyword, node, "adidas",maxPages);
		iterateMenByBrand(category, keyword, node, "Dockers",maxPages);
		iterateMenByBrand(category, keyword, node, "Fred Perry",maxPages);
		iterateMenByBrand(category, keyword, node, "G-Star Raw",maxPages);
		iterateMenByBrand(category, keyword, node, "Geoffrey Beene",maxPages);
		iterateMenByBrand(category, keyword, node, "Hanes",maxPages);
		iterateMenByBrand(category, keyword, node, "IZOD",maxPages);
		iterateMenByBrand(category, keyword, node, "Lacoste",maxPages);
		iterateMenByBrand(category, keyword, node, "Nautica",maxPages);
		iterateMenByBrand(category, keyword, node, "Perry Ellis",maxPages);
		iterateMenByBrand(category, keyword, node, "Tommy Hilfiger",maxPages);
		iterateMenByBrand(category, keyword, node, "Lee",maxPages);
		iterateMenByBrand(category, keyword, node, "Levi's",maxPages);
		iterateMenByBrand(category, keyword, node, "Wrangler",maxPages);
		iterateMenByBrand(category, keyword, node, "Diesel",maxPages);
		iterateMenByBrand(category, keyword, node, "7 For All Mankind",maxPages);
		iterateMenByBrand(category, keyword, node, "Aeropostale",maxPages);
		iterateMenByBrand(category, keyword, node, "Buffalo David Bitton",maxPages);
		iterateMenByBrand(category, keyword, node, "Ecko Unltd.",maxPages);
		iterateMenByBrand(category, keyword, node, "G-Star Raw",maxPages);
		iterateMenByBrand(category, keyword, node, "Joe's Jeans",maxPages);
		iterateMenByBrand(category, keyword, node, "True Religion",maxPages);
		iterateMenByBrand(category, keyword, node, null,maxPages);
	}
	/*
	private void iterateCologne(String category, String keyword, String node) {
		iterateAmazon("addidas",node,category,keyword);
		iterateAmazon("Alfred Dunhill",node,category,keyword);
		iterateAmazon("AMERICAN CREW",node,category,keyword);
		iterateAmazon("Antonion Puig",node,category,keyword);
		iterateAmazon("Aramis",node,category,keyword);
		iterateAmazon("Beckham",node,category,keyword);
		iterateAmazon("Boucheron",node,category,keyword);
		iterateAmazon("BVLGARI",node,category,keyword);
		iterateAmazon("Caroliona Herrera",node,category,keyword);
		iterateAmazon("Clinique",node,category,keyword);
		iterateAmazon("Coty",node,category,keyword);
		iterateAmazon("Dana",node,category,keyword);
		iterateAmazon("Davidoff",node,category,keyword);
		iterateAmazon("Geoffrey Beene",node,category,keyword);
		iterateAmazon("Giorgio Beverly Hills",node,category,keyword);
		iterateAmazon("Givenchy",node,category,keyword);
		iterateAmazon("GUESS",node,category,keyword);
		iterateAmazon("Halston",node,category,keyword);
		iterateAmazon("Jovan",node,category,keyword);
		iterateAmazon("Liz Claiborne",node,category,keyword);
		iterateAmazon("Michael Jordan",node,category,keyword);
		iterateAmazon("Muelhens",node,category,keyword);
		iterateAmazon("Nautica",node,category,keyword);
		iterateAmazon("Paul Sebastian",node,category,keyword);
		iterateAmazon("Pierre Cardin",node,category,keyword);
		iterateAmazon("Royall Fragrances",node,category,keyword);
		iterateAmazon("Tommy Hilfiger",node,category,keyword);
		iterateAmazon("Yves Saint Laurent",node,category,keyword);
	}
	
	private void iteratePerfume(String category, String keyword, String node) {
		iterateAmazon("Alfred Sung",node,category,keyword);
		iterateAmazon("Avon",node,category,keyword);
		iterateAmazon("BVLGARI",node,category,keyword);
		iterateAmazon("Cartier",node,category,keyword);
		iterateAmazon("Clean",node,category,keyword);
		iterateAmazon("Clinique",node,category,keyword);
		iterateAmazon("Coty",node,category,keyword);
		iterateAmazon("Dana",node,category,keyword);
		iterateAmazon("Donna Karan",node,category,keyword);
		iterateAmazon("Estee Lauder",node,category,keyword);
		iterateAmazon("Evyan",node,category,keyword);
		iterateAmazon("Halston",node,category,keyword);
		iterateAmazon("Jessica McClintock",node,category,keyword);
		iterateAmazon("Jessica Simpson",node,category,keyword);
		iterateAmazon("Jo Malone",node,category,keyword);
		iterateAmazon("Jovan",node,category,keyword);
		iterateAmazon("Michael Kors",node,category,keyword);
		iterateAmazon("Muelhens",node,category,keyword);
		iterateAmazon("Paris Hilton",node,category,keyword);
		iterateAmazon("Prada",node,category,keyword);
		iterateAmazon("Revlon",node,category,keyword);
		iterateAmazon("Thierry Mugler",node,category,keyword);
		iterateAmazon("Tommy Hilfiger",node,category,keyword);
		iterateAmazon("Valentino",node,category,keyword);
	}

	private void iterateHomeTheatersByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMinimumPrice(20f);
		parse.iterateAmazon();		
	}

	private void iterateHomeTheaters(String category, String keyword, String node) {
		iterateHomeTheatersByBrand(category,keyword,node,"Onkyo");
		iterateHomeTheatersByBrand(category,keyword,node,"Sony");
		iterateHomeTheatersByBrand(category,keyword,node,"Samsung");
		iterateHomeTheatersByBrand(category,keyword,node,"RCA");
		iterateHomeTheatersByBrand(category,keyword,node,"Acoustic Audio");
		iterateHomeTheatersByBrand(category,keyword,node,"Polk Audio");
		iterateHomeTheatersByBrand(category,keyword,node,"Pansonic");
		iterateHomeTheatersByBrand(category,keyword,node,null);
	}
	
	private void iterateProjectorsByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMinimumPrice(20f);
		parse.setMustInclude("projector");
		parse.iterateAmazon();		
	}
	
	private void iterateProjectors(String category, String keyword, String node) {
		iterateProjectorsByBrand(category,keyword,node,"ViewSonic");
		iterateProjectorsByBrand(category,keyword,node,"UNIC");
		iterateProjectorsByBrand(category,keyword,node,"Taotaole");
		iterateProjectorsByBrand(category,keyword,node,"Optoma");
		iterateProjectorsByBrand(category,keyword,node,"BenQ");
		iterateProjectorsByBrand(category,keyword,node,"Epson");
		iterateProjectorsByBrand(category,keyword,node,"Panasonic");
		iterateProjectorsByBrand(category,keyword,node,null);
	}
	
	private void iterateTVsByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMinimumPrice(20f);
		parse.iterateAmazon();		
	}
	
	private void iterateTVs(String category, String keyword, String node) {
		iterateTVsByBrand(category,keyword,node,"Samsung");
		iterateTVsByBrand(category,keyword,node,"LG");
		iterateTVsByBrand(category,keyword,node,"VIZIO");
		iterateTVsByBrand(category,keyword,node,"TCL");
		iterateTVsByBrand(category,keyword,node,"Upstar");
		iterateTVsByBrand(category,keyword,node,"Sony");
		iterateTVsByBrand(category,keyword,node,"Philips");
		iterateTVsByBrand(category,keyword,node,"Panasonic");
		iterateTVsByBrand(category,keyword,node,"Toshiba");
		iterateTVsByBrand(category,keyword,node,"Sharp");
		iterateTVsByBrand(category,keyword,node,null);
	}
	
	private void iterateVideoGames(String category, String keyword, String node) {
		iterateAmazon(null,node,category,keyword,AmazonUrlHelper.SORT_BOOKS_BESTSELLERS);
	}
	
	private void iterateCellPhones(String category, String keyword, String node) {
		iterateAmazon("Samsung",node,category,keyword);
		iterateAmazon("LG",node,category,keyword);
		iterateAmazon("HTC",node,category,keyword);
		iterateAmazon("Motorola",node,category,keyword);
		iterateAmazon("BlackBerry",node,category,keyword);
		iterateAmazon("Nokia",node,category,keyword);
		iterateAmazon("Kyocera",node,category,keyword);
		iterateAmazon("Apple",node,category,keyword);
		iterateAmazon("BLU",node,category,keyword);
	}
	
	private void iterateMovies(String category, String keyword, String node) {
		iterateAmazon(null,node,category,keyword,AmazonUrlHelper.SORT_BOOKS_BESTSELLERS);
	}
	
	private void iterateCDs(String category, String keyword, String node) {
		iterateAmazon(null,node,category,keyword,AmazonUrlHelper.SORT_BOOKS_BESTSELLERS);
	}
	
	private void iterateBooks(String category, String keyword, String node) {
		iterateAmazon(null,node,category,keyword,AmazonUrlHelper.SORT_BOOKS_BESTSELLERS);
	}
	
	private void iterateGraphicNovels(String category, String keyword, String node) {
		iterateAmazon("Marvel Books",node,category,keyword,AmazonUrlHelper.SORT_BOOKS_BESTSELLERS);
		iterateAmazon("DC Comics",node,category,keyword,AmazonUrlHelper.SORT_BOOKS_BESTSELLERS);
		iterateAmazon("Dark Horse Comics",node,category,keyword,AmazonUrlHelper.SORT_BOOKS_BESTSELLERS);
		iterateAmazon("Image Comics",node,category,keyword,AmazonUrlHelper.SORT_BOOKS_BESTSELLERS);
		iterateAmazon("IDW Publishing",node,category,keyword,AmazonUrlHelper.SORT_BOOKS_BESTSELLERS);
		iterateAmazon(null,node,category,keyword,AmazonUrlHelper.SORT_BOOKS_BESTSELLERS);
	}
	
	private void iterateComputersByBrand(String category, String keyword, String node,String brand)  {
		AmazonParseProcessor parse = new AmazonParseProcessor(brand,node,category,keyword,OUTPUT_FILE);
		//parse.setDb(db);
		parse.setAmazonOnly(false);
		parse.setMinimumPrice(30f);
		parse.iterateAmazon();		
	}
	
	private void iterateLaptops(String category, String keyword, String node) {
		iterateComputersByBrand(category,keyword,node,"HP");
		iterateComputersByBrand(category,keyword,node,"Asus");
		iterateComputersByBrand(category,keyword,node,"Acer");
		iterateComputersByBrand(category,keyword,node,"Toshiba");
		iterateComputersByBrand(category,keyword,node,"Dell");
		iterateComputersByBrand(category,keyword,node,"Lenovo");
		iterateComputersByBrand(category,keyword,node,"Panasonic");
		iterateComputersByBrand(category,keyword,node,null);
	}
	
	
	private void iterateTablets(String category, String keyword, String node) {
		iterateComputersByBrand(category,keyword,node,"HP");
		iterateComputersByBrand(category,keyword,node,"Asus");
		iterateComputersByBrand(category,keyword,node,"Acer");
		iterateComputersByBrand(category,keyword,node,"Toshiba");
		iterateComputersByBrand(category,keyword,node,"Dell");
		iterateComputersByBrand(category,keyword,node,"Lenovo");
		iterateComputersByBrand(category,keyword,node,"Panasonic");
		iterateComputersByBrand(category,keyword,node,"Samsung");
		iterateComputersByBrand(category,keyword,node,"Ematic");
		iterateComputersByBrand(category,keyword,node,"Apple");
		iterateComputersByBrand(category,keyword,node,"Supersonic");
		iterateComputersByBrand(category,keyword,node,null);		
	}
	
	
	private void iterateNotebooks(String category, String keyword, String node) {
		iterateAmazon("Apple",node,category,keyword);
	}

	
	private void iterateDesktops(String category, String keyword, String node, String mustInclude) {
		iterateComputersByBrand(category,keyword,node,"HP");
		iterateComputersByBrand(category,keyword,node,"Acer");
		iterateComputersByBrand(category,keyword,node,"Dell");
		iterateComputersByBrand(category,keyword,node,"Lenovo");
		iterateComputersByBrand(category,keyword,node,null);	
	}

	private void iterateMacs(String category, String keyword, String node) {
		iterateAmazon("Apple",node,category,keyword);
	}
	*/
}

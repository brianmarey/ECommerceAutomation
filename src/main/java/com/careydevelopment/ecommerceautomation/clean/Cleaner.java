package com.careydevelopment.ecommerceautomation.clean;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cleaner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Cleaner.class);

	private String seller = "";
	//private Database db;
	private String file = "";
	
	private Cleaner() {
		
	}
	
	public static void main(String[] args) {
		//Cleaner cleaner = new Cleaner("Amazon",DatabaseHelper.getDatabase(DatabaseHelper.TRELEDONIS),"./output/treledonis/Amazon.xml");
		//Cleaner cleaner = new Cleaner("Romwe",DatabaseHelper.getDatabase(DatabaseHelper.TRELEDONIS),"./output/treledonis/romwe.xml");
		//Cleaner cleaner = new Cleaner("Amazon",DatabaseHelper.getDatabase(DatabaseHelper.BRIANMCAREY),"./output/brianmcarey/Amazon.xml");
		//Cleaner cleaner = new Cleaner("eBay",DatabaseHelper.getDatabase(DatabaseHelper.BRIANMCAREY),"./output/brianmcarey/eBay.xml");
		//Cleaner cleaner = new Cleaner("eBay",DatabaseHelper.getDatabase(DatabaseHelper.TRELEDONIS),"./output/treledonis/eBay.xml");
		//Cleaner cleaner = new Cleaner("eBay",DatabaseHelper.getDatabase(DatabaseHelper.TRELEDONIS),"./output/treledonis/eBay.xml");
		Cleaner cleaner = new Cleaner("sears","./output/brianmcarey/sears.xml");
		// 
		cleaner.removeItemsNoLongerAvailable();
	}
	
	public Cleaner(String seller,String xmlFile) {
		this.seller = seller;
		//this.db = db;
		this.file = xmlFile;
	}
	
	private String getFile() {
		String text = "";
		try {
		    BufferedReader br = new BufferedReader(new FileReader(file));
		    try {
		        StringBuilder sb = new StringBuilder();
		        String line = br.readLine();
	
		        while (line != null) {
		            sb.append(line);
		            //sb.append("\n");
		            line = br.readLine();
		        }
		        text= sb.toString();
		    } finally {
		        br.close();
		    }
		} catch (Exception e) {
			System.err.println("Couldn't read " + file);
			e.printStackTrace();
			
		}
		
		return text;
	}
	
	public void removeItemsNoLongerAvailable() {
		/*PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		
		String allSkus = getFile();
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql:" );
			
			ps = con.prepareStatement("select * from " + db.getPrefix() + "posts where post_name like ?");
			ps.setString(1, seller + "-%");
			rs = ps.executeQuery();
			System.err.println("Starting");
			while (rs.next()) {
				//System.err.println(rs.getString("post_title"));
				String productName = rs.getString("post_title");
				String guid = rs.getString("post_name");
				int dashLoc = guid.indexOf("-");
				if (dashLoc > -1) {
					String sku = guid.substring(dashLoc + 1,guid.length());
					String searchString="<sku>" + sku + "</sku>";
					int skuLoc = allSkus.indexOf(searchString);
					if (skuLoc > -1) {
						System.err.println("Sku " + sku + " was found in file");
					} else {
						System.err.println("Sku " + sku + " was not found in file (" + productName +")");
						int postId = rs.getInt("ID");
						eliminateProduct(postId);
					}
				} else {
					System.err.println("GUID is bad " + guid);
				}
			}
			
			cleanup();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (Exception e) {
				
			}
			
			try {
				con.close();
			} catch (Exception e) {
				
			}
			
			try {
				rs.close();
			} catch (Exception e) {
				
			}
		}*/
	}
	
	private void cleanup() {
		/*PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
			
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://");
			
			ps = con.prepareStatement("DELETE pm FROM " + db.getPrefix() + "postmeta pm LEFT JOIN " + db.getPrefix() + "posts wp ON wp.ID = pm.post_id WHERE wp.ID IS NULL");
			ps.executeUpdate();
			
			ps = con.prepareStatement("DELETE tr FROM " + db.getPrefix() + "term_relationships tr INNER JOIN " + db.getPrefix() + "term_taxonomy tt ON (tr.term_taxonomy_id = tt.term_taxonomy_id) WHERE tt.taxonomy != 'link_category' AND tr.object_id NOT IN ( SELECT ID FROM " + db.getPrefix() + "posts )");
			ps.executeUpdate();
			
		} catch (Exception e) {
			System.err.println("Problem cleaning up");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (Exception e) {
				
			}
			
			try {
				con.close();
			} catch (Exception e) {
				
			}
			
			try {
				rs.close();
			} catch (Exception e) {
				
			}
		}*/		
	}
	
	private void eliminateProduct(int postId) {
		/*PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
			
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://");
			
			ps = con.prepareStatement("delete from " + db.getPrefix() + "posts where id=?");
			ps.setInt(1, postId);
			ps.executeUpdate();
			
			ps = con.prepareStatement("delete from " + db.getPrefix() + "posts where post_parent=?");
			ps.setInt(1, postId);
			ps.executeUpdate();
			
		} catch (Exception e) {
			System.err.println("problem eliminating product id " + postId);
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (Exception e) {
				
			}
			
			try {
				con.close();
			} catch (Exception e) {
				
			}
		}*/		
	}
}

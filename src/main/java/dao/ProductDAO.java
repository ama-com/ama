package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Product;

<<<<<<< HEAD
public class ProductDAO implements DAO {
	public List<Product> searchAll() {
		List<Product> productList = new ArrayList<>();
	
       try {
           Class.forName("org.mariadb.jdbc.Driver");
       } catch (ClassNotFoundException e) {
           throw new IllegalStateException(
           "JDBCドライバを読み込めませんでした");
       }
       
       try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
           String sql = "SERECT `productId`, `name`, `explanation`, `price`, `stock`, `mainImage` FROM `Product`";
           PreparedStatement pStmt = conn.prepareStatement(sql);
           
           ResultSet rs = pStmt.executeQuery();
           
           while (rs.next()) {
        	   int productId = rs.getInt("ID");
        	   String name = rs.getString("name");
        	   String explanation = rs.getString("explanation");
        	   int price = rs.getInt("price");
        	   int stock = rs.getInt("stock");
        	   String mainImagePass = rs.getString("mainImagePass");
        	   
        	   Product product = new Product();
        	   product.setId(productId);
        	   product.setName(name);
        	   product.setExplanation(explanation);
        	   product.setPrice(price);
        	   product.setStock(stock);
        	   product.setImagePass(mainImagePass);
        	   
        	   productList.add(product);
           }
       } catch (SQLException e) {
    	   e.printStackTrace();
    	   return null;
       }
       return productList;
=======
public class ProductDAO implements DAO<Product> {
	public List<Product> searchAll() {
		List<Product> productList = new ArrayList<>();
	
       try {
           Class.forName("org.mariadb.jdbc.Driver");
       } catch (ClassNotFoundException e) {
           throw new IllegalStateException(
           "JDBCドライバを読み込めませんでした");
       }
       
       try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
           String sql = "SELECT `id`, `name`, `exeplanation`, `price`, `stock`, `mainImage` FROM `Product`";
           PreparedStatement pStmt = conn.prepareStatement(sql);
           
           ResultSet rs = pStmt.executeQuery();
           
           while (rs.next()) {
        	   int productId = rs.getInt("ID");
        	   String name = rs.getString("name");
        	   String explanation = rs.getString("explanation");
        	   int price = rs.getInt("price");
        	   int stock = rs.getInt("stock");
        	   String mainImagePass = rs.getString("mainImagePass");
        	   
        	   Product product = new Product();
        	   product.setId(productId);
        	   product.setName(name);
        	   product.setExplanation(explanation);
        	   product.setPrice(price);
        	   product.setStock(stock);
        	   product.setImagePass(mainImagePass);
        	   
        	   productList.add(product);
           }
       } catch (SQLException e) {
    	   e.printStackTrace();
    	   return null;
       }
       return productList;
	}
	
	public List<Product> search(Product product) {
		List<Product> productList = new ArrayList<>();
		
	       try {
	           Class.forName("org.mariadb.jdbc.Driver");
	       } catch (ClassNotFoundException e) {
	           throw new IllegalStateException(
	           "JDBCドライバを読み込めませんでした");
	       }
	       
	       try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	           String sql = "SELECT `id`, `name`, `exeplanation`, `price`, `stock`, `mainImage` FROM `Product`";
	           PreparedStatement pStmt = conn.prepareStatement(sql);
	           
	           ResultSet rs = pStmt.executeQuery();
	           
	           while (rs.next()) {
	        	   int productId = rs.getInt("ID");
	        	   String name = rs.getString("name");
	        	   String explanation = rs.getString("explanation");
	        	   int price = rs.getInt("price");
	        	   int stock = rs.getInt("stock");
	        	   String mainImagePass = rs.getString("mainImagePass");
	        	   
	        	   Product product1 = new Product();
	        	   product1.setId(productId);
	        	   product1.setName(name);
	        	   product1.setExplanation(explanation);
	        	   product1.setPrice(price);
	        	   product1.setStock(stock);
	        	   product1.setImagePass(mainImagePass);
	        	   
	        	   productList.add(product);
	           }
	       } catch (SQLException e) {
	    	   e.printStackTrace();
	    	   return null;
	       }
		return productList;
	}

	@Override
	public boolean create(Product obj) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean remove(Product obj) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean update(Product obj) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
>>>>>>> branch 'main' of git@github.com:ama-com/ama.git
	}
}

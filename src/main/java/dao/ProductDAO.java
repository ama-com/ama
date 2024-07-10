package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ProductData;

public class ProductDAO implements DAO<ProductData> {
	public List<ProductData> searchAll() {
		List<ProductData> productList = new ArrayList<>();
	
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
        	   
        	   ProductData product = new ProductData();
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
	
	public List<ProductData> search(ProductData product) {
		List<ProductData> productList = new ArrayList<>();
		

		return productList;
	}

	@Override
	public boolean create(ProductData obj) {
		// TODO 自動生成されたメソッド・スタブ
	       try {
	           Class.forName("org.mariadb.jdbc.Driver");
	       } catch (ClassNotFoundException e) {
	           throw new IllegalStateException(
	           "JDBCドライバを読み込めませんでした");
	       }
	       
	       try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	    	   String sql = "INSERT INTO `product`(`name`, `explanation`, `price`, `stock`, `mainImage`) VALUES (?,?,?,?,?)";
	    	   PreparedStatement pStmt = conn.prepareStatement(sql);
	    	   
	    	   pStmt.setString(1, obj.getName());
	    	   pStmt.setString(2, obj.getExplanation());
	    	   pStmt.setInt(3, obj.getPrice());
	    	   pStmt.setInt(4, obj.getStock());
	    	   pStmt.setString(5, obj.getImagePass()); 
	    	   
	    	   int createRow = pStmt.executeUpdate();
	    	   
	    	   if (createRow > 0) {
	    		   return true;
	    	   }
	    	   
	    	   
	       } catch (SQLException e) {
	    	   e.printStackTrace();
	       }
	       
	       return false;
	}

	@Override
	public boolean remove(ProductData obj) {
		// TODO 自動生成されたメソッド・スタブ
	       try {
	           Class.forName("org.mariadb.jdbc.Driver");
	       } catch (ClassNotFoundException e) {
	           throw new IllegalStateException(
	           "JDBCドライバを読み込めませんでした");
	       }
	       
	       try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	    	   String sql = "DELETE FROM `product` WHERE ?";
	    	   PreparedStatement pStmt = conn.prepareStatement(sql);
	    	   
	    	   pStmt.setInt(1, obj.getId());
	    	   
	    	   pStmt.executeUpdate();
	    	   
	    	   return true;
	    	   
	       } catch (SQLException e) {
	    	   e.printStackTrace();
	    	   return false;
	       }
	}

	@Override
	public boolean update(ProductData obj) {
		// TODO 自動生成されたメソッド・スタブ
	       try {
	           Class.forName("org.mariadb.jdbc.Driver");
	       } catch (ClassNotFoundException e) {
	           throw new IllegalStateException(
	           "JDBCドライバを読み込めませんでした");
	       }
	       
	       try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	    	   String sql = "UPDATE `product` SET `name`=?,`explanation`=?,`price`=?,`stock`=?,`mainImage`=? WHERE `id`=?";
	    	   PreparedStatement pStmt = conn.prepareStatement(sql);
	    	   

	    	   pStmt.setString(1, obj.getName());
	    	   pStmt.setString(2, obj.getExplanation());
	    	   pStmt.setInt(3, obj.getPrice());
	    	   pStmt.setInt(4, obj.getStock());
	    	   pStmt.setString(5, obj.getImagePass());
	    	   pStmt.setInt(6, obj.getId());
	    	   
	    	   int createRow = pStmt.executeUpdate();
	    	   
	    	   if (createRow > 0) {
	    		   return true;
	    	   }
	    	   
	       } catch (SQLException e) {
	    	   e.printStackTrace();
	       }
		return false;
	}
}

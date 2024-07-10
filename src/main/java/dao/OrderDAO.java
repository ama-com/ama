package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Order;

public class OrderDAO implements DAO<OrderData>{
	public List<OrderData> searchAll() {
		List<OrderData> OrderList = new ArrayList<>();
	
       try {
           Class.forName("org.mariadb.jdbc.Driver");
   } catch (ClassNotFoundException e) {
       throw new IllegalStateException(
       "JDBCドライバを読み込めませんでした");
   }
   
   try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
       String sql = "SELECT `id`, accountId, productId, pieces FROM `Order` ORDER BY id DESC";
       PreparedStatement pStmt = conn.prepareStatement(sql);
       
       ResultSet rs = pStmt.executeQuery();
       
       while (rs.next()) {
    	   int OrderId = rs.getInt("id");
    	   int accountId = rs.getInt("accountId");
    	   int productId = rs.getInt("productId");
    	   int pieces = rs.getInt("pieces");
    	   
    	   Order order = new Order();
    	   order.setId(OrderId);
    	   order.setAccountId(accountId);
    	   order.setProductid(productId);
    	   order.setPieces(pieces);
    	   
    	   OrderList.add(order);
       }
   } catch (SQLException e) {
	   e.printStackTrace();
	   return null;
   }
   return OrderList;
}

public List<OrderData> search(OrderData Order) {
	List<OrderData> OrderList = new ArrayList<>();
	
       try {
           Class.forName("org.mariadb.jdbc.Driver");
       } catch (ClassNotFoundException e) {
           throw new IllegalStateException(
           "JDBCドライバを読み込めませんでした");
	   }
	       
	       try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	    	   StringBuilder sqlBuilder = new StringBuilder();
	    	   sqlBuilder.append("SELECT `id`, accountId, productId, pieces FROM `Order`");
	    	   sqlBuilder.append("WHERE");
	    	   sqlBuilder.append(" ");
	    	   sqlBuilder.append("accountId");
	    	   
	    	   String sql = sqlBuilder.toString();
	    	   
	           PreparedStatement pStmt = conn.prepareStatement(sql);
	           
	           ResultSet rs = pStmt.executeQuery();
	           
	           while(rs.next()) {
	               while (rs.next()) {
	            	   int OrderId = rs.getInt("id");
	            	   int accountId = rs.getInt("accountId");
	            	   int productId = rs.getInt("productId");
	            	   int pieces = rs.getInt("pieces");
	            	   
	            	   Order order = new Order();
	            	   order.setId(OrderId);
	            	   order.setAccountId(accountId);
	            	   order.setProductid(productId);
	            	   order.setPieces(pieces);
	            	   
	            	   OrderList.add(order);
	               }
	           }
	       } catch (SQLException e) {
	    	   e.printStackTrace();
	    	   return null;
	       }
		return OrderList;
	}
	public boolean create(Order order) {
	       try {
	           Class.forName("org.mariadb.jdbc.Driver");
	       } catch (ClassNotFoundException e) {
	           throw new IllegalStateException(
	           "JDBCドライバを読み込めませんでした");
		   }
	       
	       try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	    	   String sql = " insert"
	    	   		+ " into"
	    	   		+ " order"
	    	   		+ " (accountId, productId, pieces)"
	    	   		+ " values"
	    	   		+ " (?, ?, ?)";
	    	   PreparedStatement pStmt = conn.prepareStatement(sql);
	    	   pStmt.setInt(1, order.getAccountId());
	    	   pStmt.setInt(2, order.getProductid());
	    	   pStmt.setInt(3, order.getPieces());
	    	   
	           int affectedRows = pStmt.executeUpdate();
	           
	           if (affectedRows > 0) {
	        	   return true;
	           }
	    	   
	       } catch (SQLException e) {
	    	   e.printStackTrace();
	    	   return false;
	       }
	      return false;
	}

	@Override
	public boolean remove(Order obj) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

	@Override
	public boolean update(Order obj) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}
	
}



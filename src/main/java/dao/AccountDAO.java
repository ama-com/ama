/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AccountData;
import model.LoginData;
/**
 *
 * @author yuuya
 */
public class AccountDAO implements DAO<AccountData> {
   public List<AccountData> searchAll() {
       List<AccountData> AccountDataList = new ArrayList<>();
       
       try {
           Class.forName("org.mariadb.jdbc.Driver");
       } catch (ClassNotFoundException e) {
           throw new IllegalStateException(
           "JDBCドライバを読み込めませんでした");
       }
       
       try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
           String sql = "SELECT ID, NAME, PASSWORD, IMAGE, ISADMIN FROM AccountData GROUP BY DESK";
           PreparedStatement pStmt = conn.prepareStatement(sql);
           
           ResultSet rs = pStmt.executeQuery();
           
           while (rs.next()) {
               int id = rs.getInt("id");
               String name = rs.getString("NAME");
               String password = rs.getString("PASSWORD");
               String image = rs.getString("IMAGE");
               boolean isAdmin = rs.getBoolean("ISADMIN");
               
               AccountData AccountData = new AccountData();
               AccountData.setId(id);
               AccountData.setName(name);
               AccountData.setPassword(password);
               AccountData.setImagePass(image);
               AccountData.setIsAdmin(isAdmin);
               
               AccountDataList.add(AccountData);
           }
       } catch (SQLException e) {
           
       }
       return AccountDataList;
   }

@Override
public List<AccountData> search(AccountData obj) {
	// TODO 自動生成されたメソッド・スタブ
    List<AccountData> AccountDataList = new ArrayList<>();
    
    try {
        Class.forName("org.mariadb.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new IllegalStateException(
        "JDBCドライバを読み込めませんでした");
    }
    
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
        String sql = "SELECT ID, NAME, PASSWORD, IMAGE, ISADMIN FROM AccountData WHERE NAME=?, PASSWORD=?";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        
        pStmt.setString(1, obj.getName());
        pStmt.setString(2, obj.getPassword());
        
        ResultSet rs = pStmt.executeQuery();
        
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("NAME");
            String password = rs.getString("PASSWORD");
            String image = rs.getString("IMAGE");
            boolean isAdmin = rs.getBoolean("ISADMIN");
            
            AccountData AccountData = new AccountData();
            AccountData.setId(id);
            AccountData.setName(name);
            AccountData.setPassword(password);
            AccountData.setImagePass(image);
            AccountData.setIsAdmin(isAdmin);
            
            AccountDataList.add(AccountData);
        }
    } catch (SQLException e) {
        
    }
    return AccountDataList;
}


public boolean login(LoginData obj) {
    List<AccountData> AccountDataList = new ArrayList<>();
    
    try {
        Class.forName("org.mariadb.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new IllegalStateException(
        "JDBCドライバを読み込めませんでした");
    }
    
    try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
        String sql = "SELECT NAME, PASSWORD, FROM AccountData WHERE NAME=?, PASSWORD=?";
        PreparedStatement pStmt = conn.prepareStatement(sql);
        
        pStmt.setString(1, obj.getUserId());
        pStmt.setString(2, obj.getPass());
        
        ResultSet rs = pStmt.executeQuery();
        if (rs.next()) {
        	return true;
        }
    } catch (SQLException e) {
        return false;
    }
    return false;
}
@Override
public boolean create(AccountData obj) {
	// TODO 自動生成されたメソッド・スタブ
	return false;
}

@Override
public boolean remove(AccountData obj) {
	// TODO 自動生成されたメソッド・スタブ
	return false;
}

@Override
public boolean update(AccountData obj) {
	// TODO 自動生成されたメソッド・スタブ
	return false;
}
}

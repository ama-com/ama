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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Account;
/**
 *
 * @author yuuya
 */
public class AccountDAO implements Serializable, DAO {
   public List<Account> searchAll() {
       List<Account> accountList = new ArrayList<>();
       
       try {
           Class.forName("org.mariadb.jdbc.Driver");
       } catch (ClassNotFoundException e) {
           throw new IllegalStateException(
           "JDBCドライバを読み込めませんでした");
       }
       
       try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
           String sql = "";
           PreparedStatement pStmt = conn.prepareStatement(sql);
           
           ResultSet rs = pStmt.executeQuery();
           
           while (rs.next()) {
               Account account = new Account();
           }
       } catch (SQLException e) {
           
       }
       return accountList;
   }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;

/**
 *
 * @author yuuya
 */
public interface DAO<T> {
    String JDBC_URL = "jdbc:mariadb://localhost:3306/ama?characterEncoding=UTF-8&serverTimezone=Asia/Tokyo";
    String DB_USER = "root";
    String DB_PASS = "";
    public List<T> searchAll();
    public List<T> search(T obj);
    public boolean create(T obj);
    public boolean remove(T obj);
    public boolean update(T obj);
}

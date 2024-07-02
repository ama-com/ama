package dao;

import java.util.List;

public interface Dao {
	String JDBC_URL = "jdbc:mariadb://hostname:3306/ama?charaterEncoding=UTF-8&serverTimezone=JST";
	String DB_USER = "root";
	String DB_PASS = "";
	
	public List<Object> searchAll( ) ;
	public boolean search(Object object);
	public boolean create (Object object);
	public boolean remove (Object object);
}

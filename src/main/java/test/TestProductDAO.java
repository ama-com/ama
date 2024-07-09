package test;

import java.util.List;

import dao.ProductDAO;
import model.Product;

public class TestProductDAO {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		ProductDAO dao = new ProductDAO();
		
		List<Product> productList = dao.searchAll();
		
		for(Product pro: productList) {
			int id = pro.getId();
			String name = pro.getName();
			
			System.out.println(id + name);
		}
	}

}

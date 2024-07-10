package model;

import dao.DAO;
import dao.ProductDAO;

public class Product {
	private ProductData data;
	
	public Product(ProductData product) {
		this.data = product;
	}
	public boolean createProduct() {
		DAO<ProductData> dao = new ProductDAO();
		dao.create(data);
		return false;
		
	}
	
	public boolean removeProduct() {
		DAO<ProductData> dao = new ProductDAO();
		dao.remove(data);
		return false;
		
	}
	
	public boolean updateProduct(Product product) {
		DAO<ProductData> dao = new ProductDAO();
		dao.update(data);
		return false;
		
	}
}

package model;

public class ProductRegister {
	public boolean createProduct(Product product) {
		System.out.println(product.getName());
		System.out.println(product.getImagePass());
		return false;
	}
	
	public boolean removeProduct(Product product) {
		return false;
	}
	public boolean upDateProduct(Product oldProduct, Product newProduct) {
		return false;
	}
}

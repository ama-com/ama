package model;
import java.util.List;

import dao.ProductDAO;

public class TopModel {
	public List<Product> execute() {
		ProductDAO dao=new ProductDAO();
		List<Product> proList=dao.searchAll();
		return proList;

	}
}

package model;
<<<<<<< HEAD
import java.util.List;

import dao.ProductDAO;

public class TopModel {
	public List<Product> execute() {
		ProductDAO dao=new ProductDAO();
		List<Product> proList=dao.searchAll();
		return proList;

	}
=======

import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;

public class TopModel {
    public List<Product> execute() {
        List<Product> productlist = new ArrayList();
        ProductDAO dao = new ProductDAO();
        productlist = dao.searchAll();
        return productlist;
    }
>>>>>>> branch 'main' of git@github.com:ama-com/ama.git
}

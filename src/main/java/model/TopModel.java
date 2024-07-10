package model;

import java.util.ArrayList;
import java.util.List;

import dao.ProductDAO;

public class TopModel {
    public List<ProductData> execute() {
        List<ProductData> productlist = new ArrayList();
        ProductDAO dao = new ProductDAO();
        productlist = dao.searchAll();
        return productlist;
    }
}

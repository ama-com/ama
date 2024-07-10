/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author yuuya
 */
public class ProductList extends DataModel implements Serializable{
	List<ProductData> ProductDataList;

	public List<ProductData> getProductList() {
		return ProductDataList;
	}

	public void setProductList(List<ProductData> ProductDataList) {
		this.ProductDataList = ProductDataList;
	}
}

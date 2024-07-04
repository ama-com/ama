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
public class Product extends DataModel implements Serializable{
    private String explanation;
    private int price;
    private int stock;
    private List<String> subImagePaths;

    /**
     * @return the explanation
     */
    public String getExplanation() {
        return explanation;
    }

    /**
     * @param explanation the explanation to set
     */
    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the stock
     */
    public int getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * @return the subImagePaths
     */
    public List<String> getSubImagePaths() {
        return subImagePaths;
    }

    /**
     * @param subImagePaths the subImagePaths to set
     */
    public void setSubImagePaths(List<String> subImagePaths) {
        this.subImagePaths = subImagePaths;
    }
}

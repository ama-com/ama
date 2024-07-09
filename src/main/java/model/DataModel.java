/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 *
 * @author yuuya
 */
public class DataModel implements Serializable {
    private int id;
    private ZonedDateTime additionalDateTime;
    private String name;
    private String imagePath;
    
    DataModel() {
    	
    }
    DataModel(String name, String imagePath) {
    	this.name = name;
    	this.imagePath = imagePath;
    }
    
    DataModel(int id, ZonedDateTime additionalDateTime, String name, String imagePath) {
    	this.id = id;
    	this.additionalDateTime = additionalDateTime;
    	this.name = name;
    	this.imagePath = imagePath;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the additionalDate
     */
    public ZonedDateTime getAdditionalDate() {
        return additionalDateTime;
    }

    /**
     * @param additionalDate the additionalDate to set
     */
    public void setAdditionalDate(ZonedDateTime additionalDate) {
        this.additionalDateTime = additionalDate;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the imagePass
     */
    public String getImagePass() {
        return imagePath;
    }

    /**
     * @param imagePass the imagePass to set
     */
    public void setImagePass(String imagePass) {
        this.imagePath = imagePass;
    }
}

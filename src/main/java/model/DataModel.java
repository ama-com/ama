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
    private ZonedDateTime additionalDate;
    private String name;
    private String imagePass;

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
        return additionalDate;
    }

    /**
     * @param additionalDate the additionalDate to set
     */
    public void setAdditionalDate(ZonedDateTime additionalDate) {
        this.additionalDate = additionalDate;
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
        return imagePass;
    }

    /**
     * @param imagePass the imagePass to set
     */
    public void setImagePass(String imagePass) {
        this.imagePass = imagePass;
    }
}

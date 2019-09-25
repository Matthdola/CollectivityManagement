package com.mycompany.productmanagement.models;

import java.util.Date;

/**
 *
 * @author Matthias DOLA
 */
public class Product {
    private int Id;
    private String name;
    private String description;
    private Float price;
    private Date addDate;
    private byte[] image;
    private String imgPath;
    
    public Product(){
        
    }

    public Product(int Id, String name, String description, Float pPrice, Date addDate, byte[] image) {
        this.Id = Id;
        this.name = name;
        this.description = description;
        this.price = pPrice;
        this.addDate = addDate;
        this.image = image;
    }
    
    public Product(int Id, String name, String description, Float pPrice, Date addDate, String image) {
        this.Id = Id;
        this.name = name;
        this.description = description;
        this.price = pPrice;
        this.addDate = addDate;
        this.image = null;
        this.imgPath = image;
    }
    
    public int getId(){
        return this.Id;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public Date getAddDate(){
        return this.addDate;
    }
    
    public byte[] getImage() {
        return this.image;
    }
    
    public Float getPrice(){
        return this.price;
    }
    
    public String getImgPath(){
        return this.imgPath;
    }
}

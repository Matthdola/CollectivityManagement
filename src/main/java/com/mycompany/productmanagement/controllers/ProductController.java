package com.mycompany.productmanagement.controllers;

import com.mycompany.productmanagement.models.Product;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ProductController {
    public static Connection con = ConnectionDatabase.con;
    
    public static boolean insertProduct(Product p, String imgPath){
        try {
            String insertQuery = "INSERT INTO product (name, description, price, addDate) "
                    + "values(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(insertQuery);
            
            ps.setString(1, p.getName());
            ps.setString(2, p.getDescription());
            ps.setFloat(3, p.getPrice());
            Date dateVal = p.getAddDate();
            int d = dateVal.getDate();
            int m = dateVal.getMonth() + 1;
            int y = dateVal.getYear() + 1900;
            String date = String.format("%s-%s-%s", y, m, d);
            java.sql.Date dd = java.sql.Date.valueOf(date);
            ps.setDate(4, dd);
            if(imgPath != null){
                InputStream img = new FileInputStream(new File(imgPath));
                //ps.setBlob(5, img);
            }
            ps.executeUpdate();
            
            return true;
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean  updateProduct(Product p, String imgPath){
        try {
            if(imgPath == null){
                String updateQuery = "UPDATE product SET name= ?, description = ?, price = ?, addDate = ? WHERE id = ?;";
                PreparedStatement ps = con.prepareStatement(updateQuery);
                ps.setString(1, p.getName());
                ps.setString(2, p.getDescription());
                ps.setFloat(3, p.getPrice());
                Date dateVal = p.getAddDate();
                int d = dateVal.getDate();
                int m = dateVal.getMonth() + 1;
                int y = dateVal.getYear() + 1900;
                String date = String.format("%s-%s-%s", y, m, d);
                ps.setDate(4, java.sql.Date.valueOf(date));
                ps.setInt(5, p.getId());

                ps.executeUpdate();
            } else {
                String updateQuery = "UPDATE product SET name= ?, description = ?, price = ?, addDate = ?, image = ? WHERE id = ?;";
                PreparedStatement ps = con.prepareStatement(updateQuery);
                ps.setString(1, p.getName());
                ps.setString(2, p.getDescription());
                ps.setFloat(3, p.getPrice());
                Date dateVal = p.getAddDate();
                int d = dateVal.getDate();
                int m = dateVal.getMonth() + 1;
                int y = dateVal.getYear() + 1900;
                String date = String.format("%s-%s-%s", y, m, d);
                ps.setDate(4, java.sql.Date.valueOf(date));
                InputStream img = new FileInputStream(new File(imgPath));
                ps.setBlob(5, img);
                ps.setInt(6, p.getId());
                ps.executeUpdate();
            }

            return true;
        } catch (SQLException | FileNotFoundException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
       
    }
    
    public static boolean deleteProduct(int id){
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM product WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static Product getProduct(int id){
        Product p = new Product();
        return p;
    }
    
    public static ArrayList<Product> getAllProduct(){
        ArrayList<Product> productList = new ArrayList<>();
        try {
            
            String query = "SELECT * FROM product";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            Product p;
            while(rs.next()) {
                p = new Product(rs.getInt("id"), 
                        rs.getString("name"), 
                        rs.getString("description"), 
                        rs.getFloat("price"),
                        rs.getDate("addDate"),
                        rs.getBytes("image"));
                productList.add(p);
            }
            return productList;
        } catch (SQLException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void sellProduct(int i, int quantity){
        
    }
    
    public static ImageIcon resizeImage(String imagePath, byte[] p, JLabel lblImage) {
        ImageIcon myImg;
        if(imagePath != null){
            myImg = new ImageIcon(imagePath);
        } else {
            myImg = new ImageIcon(p);
        }
        
        Image img = myImg.getImage();
        Image img2 = img.getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement.controllers;

import com.mycompany.productmanagement.models.Commune;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CommuneController {
    public static Connection con = ConnectionDatabase.con;
    
    public static boolean insertCommune(Commune p){
        try {
            String insertQuery = "INSERT INTO commune (nom, population, superficie) "
                    + "values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(insertQuery);
            
            ps.setString(1, p.getNom());
            ps.setInt(2, p.getPopulation());
            ps.setFloat(3, p.getSuperficie());
            /*
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
            */
            ps.executeUpdate();
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CommuneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static boolean  updateCommune(Commune c){
        try {
            String updateQuery = "UPDATE commune SET nom= ?, population = ?, superficie = ? WHERE id = ?;";
            PreparedStatement ps = con.prepareStatement(updateQuery);
            ps.setString(1, c.getNom());
            ps.setInt(2, c.getPopulation());
            ps.setFloat(3, c.getSuperficie());
            /*
            Date dateVal = p.getAddDate();
            int d = dateVal.getDate();
            int m = dateVal.getMonth() + 1;
            int y = dateVal.getYear() + 1900;
            String date = String.format("%s-%s-%s", y, m, d);
            ps.setDate(4, java.sql.Date.valueOf(date));
            */
            ps.setInt(4, c.getId());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CommuneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
       
    }
    
    public static boolean deleteCommune(int id){
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM commune WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CommuneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public static Commune getCommune(int id){
        Commune p = new Commune();
        return p;
    }
    
    public static ArrayList<Commune> getAllCommune(){
        ArrayList<Commune> communeList = new ArrayList<>();
        try {
            
            String query = "SELECT * FROM commune";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            Commune c;
            while(rs.next()) {
                c = new Commune( 
                        rs.getString("nom"), 
                        rs.getFloat("superficie"),
                        rs.getInt("populatIon")
                        );
                c.setId(rs.getInt("id"));
                communeList.add(c);
            }
            return communeList;
        } catch (SQLException ex) {
            Logger.getLogger(CommuneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author macbookair
 */
public class ConnectionDatabase {
    public static Connection con = getConnection();
    
    public static Connection getConnection(){
        try{
            con = DriverManager.
                getConnection("jdbc:mysql://localhost:/products", "root", "Q8intsAQ2");
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Not Connected to the database" + e.getMessage());
        }
        return con;
    }
    
}

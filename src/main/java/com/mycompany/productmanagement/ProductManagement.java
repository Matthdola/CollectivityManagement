package com.mycompany.productmanagement;


import com.mycompany.productmanagement.vues.PrincipalForm;

/**
 *
 * @author Matthias DOLA
 */
public class ProductManagement {
    
    
    public static void main(String[] args){
        PrincipalForm communes = new PrincipalForm();
        communes.setLocation(150, 100);
        communes.setResizable(false);
        communes.setVisible(true);
    }
}
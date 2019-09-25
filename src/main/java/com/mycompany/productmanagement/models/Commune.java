/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.productmanagement.models;

/**
 *
 * @author macbookair
 */
public class Commune extends CollectiviteLocale {

    public Commune() {
    }
    
    public Commune(String nom, float superficie, int population) {
        this.nom = nom;
        this.population = population;
        this.superficie = superficie;
    }   

    @Override
    public int getPopulation() {
        return this.population; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getSuperficie() {
        return this.superficie; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    } 
}

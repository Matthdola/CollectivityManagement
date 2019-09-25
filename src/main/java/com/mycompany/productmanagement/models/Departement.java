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
public class Departement extends CollectiviteLocale {
    private CommunautesCommunes[] communautes;

    public Departement(String nom, CommunautesCommunes[] communautes) {
        this.nom = nom;
        this.communautes = communautes;
    }

    /**
     * Methode permettant de calculer ou modifier la population d'une collectivites
     * de commune
     */
    @Override
    public int getPopulation() {
        int pop = 0;
        for (CommunautesCommunes communaute : communautes) {
            pop += communaute.getPopulation();
        }
        return pop;
    }

    /**
     * Methode permettant de calculer ou modifier la superficie d'une commune
     */
    @Override
    public float getSuperficie() {
        float sup = 0;
        for (CommunautesCommunes communaute : communautes) {
            sup += communaute.getSuperficie();
        }
        return sup;
    }    
}

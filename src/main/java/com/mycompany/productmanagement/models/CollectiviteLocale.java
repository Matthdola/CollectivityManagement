package com.mycompany.productmanagement.models;

import java.util.Date;

/**
 *
 * @author Matthias DOLA
 * classe abstraite de la collectivite locale
 */
public abstract class CollectiviteLocale { 
    protected int id;
    protected String nom;
    protected int population;
    protected float superficie;

    /**
     * Cette methode retourne le nom de la collectivite
     * @return 
     */
    public String getNom() { //
        return this.nom;
    }

    /**
     * Cette methode d'affecter ou modifier le nom de la collectivite nom :
     * parametre fourni au programme de type String
     * @param nom
     */
    public void setNom(String nom) { //
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    /**
     * Cette methode permet de recuperer ou de calculer la population de la
     * collectivite
     * @return 
     */
    public abstract int getPopulation(); // Methode permettant de connaitre la population de la collectivite

    /**
     * Cette methode permet de recuperer ou de calculer la superficie de la
     * collectivite
     * @return 
     */
    public abstract float getSuperficie(); // Methode permettant de connaitre la superficie de la collectivite

    /**
     * Cette methode permet de calculer la densite de la collectivite On calcule la
     * densité d'une population donnée en divisant le nombre d'habitants par la
     * superficie exprimée en km² La superficie doit etre superieure a zero
     * @return float
     */
    public float getDensite() {
        if (superficie == 0) {
                return 0;
        }
        float densite = population / superficie;
        return densite;
    }

    @Override
    public String toString() {
        return "collectivite " + this.nom + " de" + this.getSuperficie() + " a une population de "
                            + this.getPopulation() + " avec une densite de " + this.getDensite() + " par m2.";
    }
}
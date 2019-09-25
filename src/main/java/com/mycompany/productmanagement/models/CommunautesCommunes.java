package com.mycompany.productmanagement.models;

/**
 *
 * @author Matthias DOLA
 */
public class CommunautesCommunes extends CollectiviteLocale {
    protected Commune[] communautes;

    public CommunautesCommunes(String nom, Commune[] collectivite) {
        this.nom = nom;
        this.communautes = collectivite;
    }

    /**
     * Methode permettant de calculer ou modifier la population d'une collectivites
     * de commune
     */
    @Override
    public int getPopulation() {
        int pop = 0;
        for (Commune communaute : communautes) {
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
        for (Commune communaute : communautes) {
            sup += communaute.getSuperficie();
        }
        return sup;
    }
}

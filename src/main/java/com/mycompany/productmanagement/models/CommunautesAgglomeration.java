package com.mycompany.productmanagement.models;

/**
 * 
 * @author Matthias DOLA
 */
public class CommunautesAgglomeration extends CommunautesCommunes {
    public CommunautesAgglomeration(String nom, Commune[] communautes) throws Exception {
        super(nom, communautes);
        int pop = 0;
        for (Commune communaute : communautes) {
            pop += communaute.getPopulation();
        }
        if (pop < 50000)
            throw new Exception("La population doit etre superieure a 50 000 pour creer une communaute d'agglomeration");
    }
}

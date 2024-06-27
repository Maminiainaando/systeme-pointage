package org.example.model;

import java.util.Date;

final class Superior extends Employee{
    private final String nameCategorie;
    public Superior(String nom, String prenom, int numeroMatricule, Date dateDeNaissance, Date dateDEmbauche, Date dateFinContrat, double salaireBrute, String nameCategorie) {
        super(nom, prenom, numeroMatricule, dateDeNaissance, dateDEmbauche, dateFinContrat, salaireBrute);
        this.nameCategorie = nameCategorie;
    }

    @Override
    public double calculerSalaireTotal(int heuresNormales, int heuresSupplementaires, int heuresMajorees) {
        return this.getSalaireBrute();
    }

    @Override
    public int nombreHeureNormalDeTravailParSemaine() {
        return 0;
    }

    public Double salaireNormalParDesHeureNormalParSemaine() {
        return null;
    }

    public Double montantIndemnitéProportionnelleAuSalaire() {
        return null;
    }
}

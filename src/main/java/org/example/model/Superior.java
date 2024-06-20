package org.example.model;

import java.util.Date;

final class Superior extends Employee{

    public Superior(String nom, String prenom, int numeroMatricule, Date dateDeNaissance, Date dateDEmbauche, Date dateFinContrat, Double salaireBrute, String categorie) {
        super(nom, prenom, numeroMatricule, dateDeNaissance, dateDEmbauche, dateFinContrat, salaireBrute, categorie);
    }

    @Override
    public double calculerSalaireTotal(int heuresNormales, int heuresSupplementaires, int heuresMajorees) {
        return this.getSalaireBrute(); // Salaire brut fixe
    }
}

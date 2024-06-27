package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
final class Chauffeur extends Employee{
    private final String nameCategorie;

    public Chauffeur(String nom, String prenom, int numeroMatricule, Date dateDeNaissance, Date dateDEmbauche, Date dateFinContrat, double salaireBrute, String nameCategorie) {
        super(nom, prenom, numeroMatricule, dateDeNaissance, dateDEmbauche, dateFinContrat, salaireBrute);
        this.nameCategorie = nameCategorie;
    }

    @Override
    public double calculerSalaireTotal(int heuresNormales, int heuresSupplementaires, int heuresMajorees) {
        return 0;
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

    public static void main(String[] args) {

    }
}

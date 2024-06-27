package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Logger;

@Getter
@Setter
@ToString
@AllArgsConstructor
public  abstract sealed class Employee permits Guard,NormalEmployes,Superior,Chauffeur{
    private String nom;
    private String prenom;
    private int numeroMatricule;
    private Date dateDeNaissance;
    private Date dateDEmbauche;
    private Date dateFinContrat;
    private double salaireBrute;
    public double  calculerSalaireNet() {
        return (this.salaireBrute) * 0.80;
    }

    public abstract double calculerSalaireTotal(int heuresNormales, int heuresSupplementaires, int heuresMajorees);

    public abstract int nombreHeureNormalDeTravailParSemaine();
}

package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.logging.Logger;

@Getter
@Setter
@ToString
@AllArgsConstructor
abstract sealed class Employee permits Guard,NormalEmployes,Superior{
    private String nom;
    private String prenom;
    private int numeroMatricule;
    private Date dateDeNaissance;
    private Date dateDEmbauche;
    private Date dateFinContrat;
    private Double salaireBrute;
    private String categorie;
    public Double calculerSalaireNet() {
        return this.salaireBrute * 0.80;
    }

    public abstract double calculerSalaireTotal(int heuresNormales, int heuresSupplementaires, int heuresMajorees);
}

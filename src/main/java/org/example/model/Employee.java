package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Employee {
    private String nom;
    private String prenom;
    private int numeroMatricule;
    private Date dateDeNaissance;
    private Date dateDEmbauche;
    private Date dateFinContrat;
    private Salaire montantDuSalaire;
    private String categorie;
}

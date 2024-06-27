package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@Getter
@Setter
@ToString
public final class NormalEmployes extends Employee{
    private final String nameCategorie;
    private static final double TAUX_HS30 = (100/130);
    private static final double TAUX_HS50 = (100/150);

    public NormalEmployes(String nom, String prenom, int numeroMatricule, Date dateDeNaissance, Date dateDEmbauche, Date dateFinContrat, double salaireBrute, String nameCategorie) {
        super(nom, prenom, numeroMatricule, dateDeNaissance, dateDEmbauche, dateFinContrat, salaireBrute);
        this.nameCategorie = nameCategorie;
    }


    @Override
    public double calculerSalaireTotal(int heuresNormales, int heuresSupplementaires, int heuresMajorees) {
        double salaireNormal = this.getSalaireBrute();
        int salaireSupplementaire = 0;
        if (heuresSupplementaires > 8) {
            salaireSupplementaire += 8 * (salaireNormal / heuresNormales) * TAUX_HS30;
            salaireSupplementaire += (heuresSupplementaires - 8) * (salaireNormal / heuresNormales) * TAUX_HS50;
        } else {
            salaireSupplementaire += heuresSupplementaires * (salaireNormal / heuresNormales) * TAUX_HS30;
        }
        return salaireNormal + salaireSupplementaire;
    }

    @Override
    public int nombreHeureNormalDeTravailParSemaine() {
        return 40;
    }

    public Double salaireNormalParDesHeureNormalParSemaine() {
        return 100_000d;
    }

    public Double montantIndemnitéProportionnelleAuSalaire() {
        return null;
    }
}

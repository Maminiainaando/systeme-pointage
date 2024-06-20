package org.example.model;

import java.util.Date;

final class NormalEmployes extends Employee{
    private static final double TAUX_HS30 = 1.3;
    private static final double TAUX_HS50 = 1.5;

    public NormalEmployes(String nom, String prenom, int numeroMatricule, Date dateDeNaissance, Date dateDEmbauche, Date dateFinContrat, Double salaireBrute, String categorie) {
        super(nom, prenom, numeroMatricule, dateDeNaissance, dateDEmbauche, dateFinContrat, salaireBrute, categorie);
    }

    @Override
    public double calculerSalaireTotal(int heuresNormales, int heuresSupplementaires, int heuresMajorees) {
        double salaireNormal = this.getSalaireBrute();
        double salaireSupplementaire = 0.0;

        if (heuresSupplementaires > 8) {
            salaireSupplementaire += 8 * (salaireNormal / heuresNormales) * TAUX_HS30;
            salaireSupplementaire += (heuresSupplementaires - 8) * (salaireNormal / heuresNormales) * TAUX_HS50;
        } else {
            salaireSupplementaire += heuresSupplementaires * (salaireNormal / heuresNormales) * TAUX_HS30;
        }

        return salaireNormal + salaireSupplementaire;
    }
}

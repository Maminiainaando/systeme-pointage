package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public final class Guard extends Employee{
    private final String nameCategorie;
    private static final double TAUX_HS30 = 1.3;
    private static final double TAUX_HS50 = 1.5;
    private static final double HEUREMAJORE_HM30 = 1.3;
    private static final double HEUREMAJORE_HM40 = 1.4;
    private static final double HEUREMAJORE_HM50 =1.5;
    private String jourOuNuit;
    public Guard(String nom, String prenom,int numeroMatricule, Date dateDeNaissance, Date dateDEmbauche, Date dateFinContrat, double salaireBrute, String nameCategorie,String jourOuNuit) {
        super(nom, prenom, numeroMatricule, dateDeNaissance, dateDEmbauche, dateFinContrat, salaireBrute);
        this.nameCategorie = nameCategorie;
        this.jourOuNuit=jourOuNuit;
    }
    @Override
    public double calculerSalaireTotal(int heuresNormales,int heuresSupplementaires,int heuresMajorees) {
        double result=0;
        double salaireUneHeure=salaireNormalParDesHeureNormalParSemaine()/56d;
        double salaireHeureNormal=0;
        double salaireSupplementaire=0;
        double salaireMajore=0;
        salaireHeureNormal=heuresNormales*salaireUneHeure;
        result=salaireHeureNormal;
        return result;

    }
    public double calculerSalaireTotalEnUtilisantHeure(int heuresNormales,int heuresSupplementaires,int heuresMajoreNuit,int heuresMajoreDimanche,int heuresMajoreFerie){
        double result=0;
        double salaireDeUneHeure=salaireNormalParDesHeureNormalParSemaine()/nombreHeureNormalDeTravailParSemaine();
        double salaireUnJour=salaireNormalParDesHeureNormalParSemaine()/7;
        double salaireUneNuit=130000/7;
        double salaireNormal=heuresNormales*salaireDeUneHeure;
        double salaireSupplementaire=0;
        if(heuresMajoreNuit>0 && heuresMajoreFerie==0){
            result = salaireNormal * HEUREMAJORE_HM30;
        } else if (heuresMajoreFerie>0 && heuresMajoreNuit==0) {
            result = salaireNormal+(heuresMajoreFerie*salaireUnJour*HEUREMAJORE_HM30);
        }else if(heuresMajoreFerie>0 && heuresMajoreNuit>0){
            System.out.println(salaireUneNuit);
            result = salaireNormal * HEUREMAJORE_HM30;
            result +=heuresMajoreFerie*salaireUneNuit*HEUREMAJORE_HM30;
        }else {
            result=salaireNormal;
        }
        System.out.println("Salaire de une heure : "+salaireDeUneHeure);
        System.out.println("Salaire de une nuit : "+salaireUneNuit);
        System.out.println("Salaire normal : "+salaireNormal);
        System.out.println("Salaire net : "+result*0.80);
        return result;
    }
    @Override
    public int nombreHeureNormalDeTravailParSemaine() {
        return 70;
    }

    public Double salaireNormalParDesHeureNormalParSemaine() {
        return 100000d;
    }
}

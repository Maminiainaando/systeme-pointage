package org.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Method {
    public static Calendrier calendrierDuMois(Mois mois,List<Object> jourFeries){
        List<Object> resultJour=new ArrayList<>();
        Calendrier resultCalendrier=new Calendrier(resultJour,mois);
        Jour lundi=new Jour("lundi");
        Jour mardi=new Jour("mardi");
        Jour mercredi=new Jour("mercredi");
        Jour jeudi=new Jour("jeudi");
        Jour vendredi=new Jour("vendredi");
        Jour samedi=new Jour("samedi");
        Jour dimanche=new Jour("dimanche");
        List<String> listJourString=Arrays.asList(
           "lundi","mardi","mercredi","jeudi","vendredi","samedi","dimanche"
        ) ;
        List<Jour> jourDeTravailEmployeeNormal= Arrays.asList(lundi,mardi,mercredi,jeudi,vendredi);
        List<Jour> jourDeTravailGardien=Arrays.asList(
                lundi,mardi,mercredi,jeudi,vendredi,samedi,dimanche
                );
        List<Jour> jourFeries=new ArrayList<>();
        List<Object> feries=Arrays.asList(jourFeries,mois);
        List<String> jourMoisComplet=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (String s:listJourString) {
                jourMoisComplet.add(s);
            }
        }
        for (int i = 0; i < jourMoisComplet.size(); i++) {
            /*for (String s:listJourString) {
                if(listJourString.indexOf(s)<=5){
                    System.out.println(listJourString.get(listJourString.indexOf(s))+" - >"+" employee et gardiens ");
                }else {
                    System.out.println(listJourString.get(listJourString.indexOf(s))+" -> "+" gardiens");
                }
            }*/
        }
        System.out.println(jourMoisComplet);
        return resultCalendrier;
    }

    public static void main(String[] args) {
        Mois mois=new Mois("juin");
        calendrierDuMois(mois);
    }
}

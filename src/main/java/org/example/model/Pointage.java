package org.example.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static org.example.model.Calendar.getCalendareeee;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Pointage {
    private Calendar calendar;
    private Employee employee;
    public static int nombreDepointage(Pointage pointage){
        int result=0;
        List<DayOfWeek> workingDay=new ArrayList<>();
        workingDay.clear();
        workingDay.addAll(Arrays.asList(
                DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
                DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY,
                DayOfWeek.SUNDAY
        ));
        Map<LocalDate, Boolean> calendar = new HashMap<>();
        LocalDate startDate = pointage.getCalendar().getStart();
        LocalDate endDate = pointage.getCalendar().getEnd();
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            boolean isWorkingDay = workingDay.contains(date.getDayOfWeek()) && !pointage.getCalendar().getPublicHoliday().contains(date);
            if(isWorkingDay==true){
                result+=1;
            }
            calendar.put(date, isWorkingDay);
        }
        return result;
    }
    public static int heureDeTravail(Pointage pointage){
        int result=0;
        List<LocalDate> workingHard=new ArrayList<>();
        Map<LocalDate,String> calendare=getCalendareeee(pointage.getCalendar().getStart(),pointage.getCalendar().getEnd(), pointage.getCalendar().getPublicHoliday(), pointage.getEmployee(),workingHard);

        for (Map.Entry<LocalDate, String> entry : calendare.entrySet()) {
            LocalDate date = entry.getKey();
            String value = entry.getValue();
            if(pointage.getEmployee() instanceof Guard){
                if(((Guard) pointage.getEmployee()).getJourOuNuit()=="nuit"){
                    result+=14;
                }else{
                    result+=10;
                }
            }
        }
        return result;
    }
    public static int heureDeTravailEffectue(Pointage pointage){
        int result=0;
        int nombreJHeureEffectue=0;
        List<LocalDate> workingHard=new ArrayList<>();
        Map<LocalDate,String> calendare=getCalendareeee(pointage.getCalendar().getStart(),pointage.getCalendar().getEnd(), pointage.getCalendar().getPublicHoliday(), pointage.getEmployee(),workingHard);
        int nombreDeJour=calendare.size();
        List<LocalDate> localDateList=new ArrayList<>();
        for (Map.Entry<LocalDate, String> entry : calendare.entrySet()) {
            LocalDate date = entry.getKey();
            String value = entry.getValue();
            localDateList.add(date);
            if(value.equals("publicHoliday")){
                nombreJHeureEffectue+=10;
                nombreJHeureEffectue+=0;
            } else if (value.equals("workingHard")) {
                nombreJHeureEffectue+=24;
            }else{
                nombreJHeureEffectue+=10;
            }
        }

        if(pointage.getEmployee() instanceof Guard)
        {
            if(((Guard) pointage.getEmployee()).getJourOuNuit().equals("nuit")){
                nombreJHeureEffectue+=4*nombreDeJour;
            }
        }
        result=nombreJHeureEffectue;
        return nombreJHeureEffectue;
    }
    public static double amountSalary(Pointage pointage){
        List<LocalDate> workingHard=new ArrayList<>();
        Map<LocalDate,String> calendaResult=getCalendareeee(pointage.getCalendar().getStart(),pointage.getCalendar().getEnd(), pointage.getCalendar().getPublicHoliday(), pointage.getEmployee(),workingHard);
        List<LocalDate> publicHoliday=new ArrayList<>();
        publicHoliday.add(LocalDate.of(2024, Month.JUNE, 17));
        publicHoliday.add(LocalDate.of(2024, Month.JUNE, 25));
        publicHoliday.add(LocalDate.of(2024, Month.JUNE, 26));
        int heureSup=0;
        int heureEffectue=heureDeTravailEffectue(pointage);
        int nombreDeJour=calendaResult.size();
        int nombreDeSemaine=nombreDeJour/7;
        int heureNormal=nombreDepointage(pointage)*10;
        int heuresMajoreNuit=0;
        int heuresMajoreDimanche=0;
        int heuresMajoreFerie=0;
        int heureMaj=0;
        for (Map.Entry<LocalDate, String> entry : calendaResult.entrySet()) {
            LocalDate date = entry.getKey();
            String value = entry.getValue();
            if(value.equals("publicHoliday")){
                heuresMajoreFerie+=1;
            }
        }
        if(pointage.getEmployee() instanceof Guard){
            if(((Guard) pointage.getEmployee()).getJourOuNuit()=="nuit"){
                heuresMajoreNuit+=4;
            }
        }
        System.out.println("Le nombre de jour : "+nombreDeJour);
        System.out.println("Le nombre de semaine : "+nombreDeSemaine);
        System.out.println("Le nombre de heureSup : "+heureSup);
        System.out.println("Le nombre de heure normal : "+heureNormal);
        System.out.println("Le nombre de heureEffectue : "+heureEffectue);
        System.out.println("Le nombre de heure majorée dimanche: "+heuresMajoreDimanche);
        System.out.println("Le nombre de heure majorée ferié: "+heuresMajoreFerie);
        System.out.println("Le nombre de heure majorée nuit: "+heuresMajoreNuit);
        if(pointage.getEmployee() instanceof Guard){
         return ((Guard) pointage.getEmployee()).calculerSalaireTotalEnUtilisantHeure(heureNormal,heureSup,heuresMajoreNuit,heuresMajoreDimanche,heuresMajoreFerie);
        }else {
            return pointage.getEmployee().calculerSalaireTotal(nombreDeSemaine,heureSup,heureMaj);
        }
    }
    public static void main(String[] args) {
        List<DayOfWeek> workingDays = new ArrayList<>();
        List<LocalDate> publicHolidays = new ArrayList<>();
        Employee normalEmployee = new NormalEmployes("Nom", "Prenom", 123, new Date(), new Date(), new Date(), 100000, "Categorie1");
        Employee guard = new Guard("Nom", "Prenom", 456, new Date(), new Date(), new Date(), 100000, "Categorie2","nuit");
        Guard guarde = new Guard("Nom", "Prenom", 456, new Date(), new Date(), new Date(), 100000, "Categorie2","jour");
        Calendar calendar1=new Calendar(publicHolidays,LocalDate.of(2024, 5, 26),LocalDate.of(2024, 6, 1));
        List<LocalDate> workingHard=new ArrayList<>();
        Pointage pointage=new Pointage(calendar1,guarde);
        //System.out.println(nombreDepointage(pointage));
        //System.out.println(heureDeTravailEffectue(pointage));
        //System.out.println();
      System.out.println(amountSalary(pointage));
        //System.out.println((getCalendareeee(calendar1.getStart(),calendar1.getEnd(),publicHolidays,guard,workingHard)));
        /*System.out.println("calendrier :"+getCalendare(pointage.getCalendar().getStart(),
                pointage.getCalendar().getEnd(), pointage.getCalendar().getPublicHoliday(),
                pointage.getEmployee()
                ));*/
    }
}

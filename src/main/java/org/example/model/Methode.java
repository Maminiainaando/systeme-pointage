package org.example.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.logging.Logger;

public class Methode {
    private static final Logger logger = Logger.getLogger(Methode.class.getName());
    public static Map<LocalDate, String> calendarEmployee(Employee employee, List<DayOfWeek> workingDay, List<LocalDate> publicHoliday) {
        publicHoliday.add(LocalDate.of(2024, Month.JUNE, 17));
        publicHoliday.add(LocalDate.of(2024, Month.JUNE, 25));
        publicHoliday.add(LocalDate.of(2024, Month.JUNE, 26));
        if (employee instanceof Guard) {
            workingDay.clear();
            workingDay.addAll(Arrays.asList(
                    DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
                    DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY,
                    DayOfWeek.SUNDAY
            ));
        } else{
            workingDay.clear();
            workingDay.addAll(Arrays.asList(
                    DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
                    DayOfWeek.THURSDAY, DayOfWeek.FRIDAY
            ));
        }
        Map<LocalDate, String> calendar = new HashMap<>();
        LocalDate startDate = LocalDate.of(2024, Month.JUNE, 1);
        LocalDate endDate = LocalDate.of(2024, Month.JUNE, 30);

        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            boolean isWorkingDay = workingDay.contains(date.getDayOfWeek()) && !publicHoliday.contains(date);
            String result = isWorkingDay ? "working" : "not working";
            calendar.put(date, result);
        }
        return calendar;
    }
    public static Map<LocalDate, String> calendarGuard(Guard guard, List<DayOfWeek> workingDay, List<LocalDate> publicHoliday) {
        publicHoliday.add(LocalDate.of(2024, Month.JUNE, 17));
        publicHoliday.add(LocalDate.of(2024, Month.JUNE, 25));
        publicHoliday.add(LocalDate.of(2024, Month.JUNE, 26));
            workingDay.clear();
            workingDay.addAll(Arrays.asList(
                    DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
                    DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY,
                    DayOfWeek.SUNDAY
            ));
        Map<LocalDate, String> calendar = new HashMap<>();
        LocalDate startDate = LocalDate.of(2024, Month.JUNE, 1);
        LocalDate endDate = LocalDate.of(2024, Month.JUNE, 30);

        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            boolean isWorkingDay = workingDay.contains(date.getDayOfWeek()) && !publicHoliday.contains(date);
            String result = isWorkingDay ? "working" : "not working";
            calendar.put(date, result);
        }
        System.out.println(publicHoliday);
        return calendar;
    }

    public static Double amountSalary(Guard guard,Pointage pointageOriginal){
        List<LocalDate> dates=new ArrayList<>();
        dates.add(LocalDate.of(2024, 6, 24));
        dates.add(LocalDate.of(2024, 6, 25));
        dates.add(LocalDate.of(2024, 6, 26));
        dates.add(LocalDate.of(2024, 6, 27));
        dates.add(LocalDate.of(2024, 6, 28));
        Pointage pointage=new Pointage(dates,guard);
        int heureEffectue = heureDeTravailEffectue(guard);
        int heureNormal = guard.nombreHeureNormalDeTravailParSemaine();
        int heureSup = 0;
        int heureMajoree = pointage.getLocalDates().size();
        if (heureEffectue > heureNormal){
            heureSup = heureEffectue - heureNormal;
        }

        if (guard.getJourOuNuit().equals("nuit")) {
            heureMajoree = heureEffectue;
        }
        guard.calculerSalaireTotal(heureNormal,heureSup,heureMajoree);
        Double result = guard.calculerSalaireTotal(heureNormal, heureSup, heureMajoree);
        return result;
    }
    public static int heureDeTravailEffectue(Guard guard){
        List<DayOfWeek> workingDays = new ArrayList<>();
        List<LocalDate> publicHolidays = new ArrayList<>();
        calendarEmployee(guard, workingDays, publicHolidays);
        int jourDeTravail= (calendarGuard(guard,new ArrayList<>(workingDays), new ArrayList<>(publicHolidays))).size()- publicHolidays.size();
        int result=0;
        if(guard.getJourOuNuit()=="nuit")
        {
            result=14*(jourDeTravail*24);
        }
        else{
            result=10*(jourDeTravail*24);
        }
        return result;
    }
}

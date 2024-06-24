package org.example.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Pointage {
    private List<LocalDate> localDates;
    private Employee employee;
    public static Map<LocalDate, String> pointage(Pointage pointage) {
        List<DayOfWeek> workingDays = new ArrayList<>();
        List<LocalDate> publicHolidays = new ArrayList<>();
        Map<LocalDate, Boolean> calendar = Calendar.calendarEmployee(pointage.getEmployee(), new ArrayList<>(workingDays), new ArrayList<>(publicHolidays));
        Map<LocalDate, String> pointageMap = new HashMap<>();

        for (int i = 0; i < pointage.getLocalDates().size(); i++) {
            LocalDate date = pointage.getLocalDates().get(i);
            boolean isWorkingDay = calendar.getOrDefault(date, false);
            String status = isWorkingDay ? "Working day" : "Not working";
            pointageMap.put(date, status);
            System.out.println(date + " is a " + status);
        }
        return pointageMap;
    }
    public static void main(String[] args) {
        List<DayOfWeek> workingDays = new ArrayList<>();
        List<LocalDate> publicHolidays = new ArrayList<>();
        Employee normalEmployee = new NormalEmployes("Nom", "Prenom", 123, new Date(), new Date(), new Date(), 3000.0, "Categorie1");
        Employee guard = new Guard("Nom", "Prenom", 456, new Date(), new Date(), new Date(), 3500.0, "Categorie2","nuit");
        Guard guarde = new Guard("Nom", "Prenom", 456, new Date(), new Date(), new Date(), 3500.0, "Categorie2","nuit");


        List<LocalDate> dates=new ArrayList<>();
        dates.add(LocalDate.of(2024, 6, 24));
        dates.add(LocalDate.of(2024, 6, 25));
        dates.add(LocalDate.of(2024, 6, 26));
        dates.add(LocalDate.of(2024, 6, 27));
        dates.add(LocalDate.of(2024, 6, 28));
        Pointage pointage=new Pointage(dates,guarde);
        System.out.println(pointage(pointage));
    }
}

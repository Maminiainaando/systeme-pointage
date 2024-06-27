package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Calendar {
    private List<LocalDate> publicHoliday;
    private LocalDate start;
    private LocalDate end;
    public static Map<LocalDate, Boolean> calendarEmp(LocalDate start, LocalDate end, List<LocalDate> publicHoliday, Employee employee) {
        /*publicHoliday.add(LocalDate.of(2024, Month.JUNE, 17));
        publicHoliday.add(LocalDate.of(2024, Month.JUNE, 25));
        publicHoliday.add(LocalDate.of(2024, Month.JUNE, 26));*/
        List<DayOfWeek> workingDay = new ArrayList<>();
        if (employee instanceof Guard) {
            workingDay.clear();
            workingDay.addAll(Arrays.asList(
                    DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
                    DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY,
                    DayOfWeek.SUNDAY
            ));
        }
        else{
            workingDay.clear();
            workingDay.addAll(Arrays.asList(
                    DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
                    DayOfWeek.THURSDAY, DayOfWeek.FRIDAY
            ));
        }
        Map<LocalDate, Boolean> calendar = new HashMap<>();
        LocalDate startDate = start;
        LocalDate endDate = end;
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            boolean isWorkingDay = workingDay.contains(date.getDayOfWeek()) && !publicHoliday.contains(date);
            calendar.put(date, isWorkingDay);
        }
        return calendar;
    }
    public static Map<LocalDate, String> getCalendareeee(LocalDate start, LocalDate end, List<LocalDate> publicHoliday, Employee employee,List<LocalDate> workHard) {
        workHard.add(LocalDate.of(2024,Month.JUNE,1));
        List<DayOfWeek> workingDay = new ArrayList<>();
        if (employee instanceof Guard) {
            workingDay.clear();
            workingDay.addAll(Arrays.asList(
                    DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
                    DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY,
                    DayOfWeek.SUNDAY
            ));
        }
        else{
            workingDay.clear();
            workingDay.addAll(Arrays.asList(
                    DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
                    DayOfWeek.THURSDAY, DayOfWeek.FRIDAY
            ));
        }
        Map<LocalDate, String> calendar = new HashMap<>();
        LocalDate startDate = start;
        LocalDate endDate = end;
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            String isWorkingDay="";
            if (workingDay.contains(date.getDayOfWeek()) && publicHoliday.contains(date)) {
                isWorkingDay="publicHoliday";
            } else if (workingDay.contains(date.getDayOfWeek()) && workHard.contains(date)) {
                isWorkingDay="workingHard";
            }else{
                isWorkingDay="working";
            }
            calendar.put(date, isWorkingDay);
        }
        return calendar;
    }
    public static Map<LocalDate, Boolean> calendareJune(List<LocalDate> publicHoliday,Employee employee){
        publicHoliday.add(LocalDate.of(2024, Month.JUNE, 17));
        publicHoliday.add(LocalDate.of(2024, Month.JUNE, 25));
        publicHoliday.add(LocalDate.of(2024, Month.JUNE, 26));
        List<DayOfWeek> workingDay = new ArrayList<>();
        if (employee instanceof Guard) {
            workingDay.clear();
            workingDay.addAll(Arrays.asList(
                    DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
                    DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY,
                    DayOfWeek.SUNDAY
            ));
        }
        else{
            workingDay.clear();
            workingDay.addAll(Arrays.asList(
                    DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY,
                    DayOfWeek.THURSDAY, DayOfWeek.FRIDAY
            ));
        }
        Map<LocalDate, Boolean> calendar = new HashMap<>();
        LocalDate startDate = LocalDate.of(2024,6,1);
        LocalDate endDate = LocalDate.of(2024,6,30);
        for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
            boolean isWorkingDay = workingDay.contains(date.getDayOfWeek()) && !publicHoliday.contains(date);
            calendar.put(date, isWorkingDay);
        }
        return calendar;
    }
}

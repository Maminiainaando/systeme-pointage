package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Calendar {
    private YearMonth month;
    private List<LocalDate> holidays;
    private List<DayOfWeek> normalWorkingDays;
    private List<DayOfWeek> guardianWorkingDays;

    public Calendar() {
        // Default constructor
    }

    public List<LocalDate> getWorkingDays(List<DayOfWeek> workingDays) {
        List<LocalDate> workDays = new ArrayList<>();
        for (int i = 1; i <= month.lengthOfMonth(); i++) {
            LocalDate date = LocalDate.of(month.getYear(), month.getMonth(), i);
            if (Arrays.asList(workingDays).contains(date.getDayOfWeek()) && !holidays.contains(date)) {
                workDays.add(date);
            }
        }
        return workDays;
    }

    public int calculateWorkHours(LocalDate date, int hoursPerDay) {
        if (holidays.contains(date)) {
            return 0;
        }
        return hoursPerDay;
    }

    public void printCalendar() {
        for (LocalDate date : getWorkingDays(normalWorkingDays)) {
            System.out.println(date + " : Normal working day");
        }
        for (LocalDate date : getWorkingDays(guardianWorkingDays)) {
            if (!normalWorkingDays.contains(date.getDayOfWeek())) {
                System.out.println(date + " : Guardian working day");
            }
        }
    }

    public int calculateOvertimeHours(LocalDate date, int hoursPerDay) {
        if (holidays.contains(date) || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            return hoursPerDay; // All hours are considered overtime
        }
        return 0;
    }
}

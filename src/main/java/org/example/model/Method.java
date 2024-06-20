package org.example.model;
import java.lang.reflect.Array;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class Method {
    private static final Logger logger = Logger.getLogger(Method.class.getName());
    public static Calendar calendarGuard(Employee employee,Month month, List<Date> publicHoliday){
        List<DayOfWeek> allDays=new ArrayList<>();
        Calendar result=new Calendar();
        return result;
    }

        private static final Logger LOGGER = Logger.getLogger(Method.class.getName());

        public static void main(String[] args) {
            Employee employee = new NormalEmployes("Doe", "John", 12345, new Date(), new Date(), null, 2500.0, "Normal");

            LOGGER.info("Employee details: " + employee.toString());
            LOGGER.info("Net salary: " + employee.calculerSalaireNet());

            double totalSalary = employee.calculerSalaireTotal(160, 10, 5);
            LOGGER.info("Total salary: " + totalSalary);


                    // Employee Superior
                    Employee superior = new Superior("Smith", "Alice", 54321, null, null, null, 5000.0, "Manager");
                    LOGGER.info("Superior details: " + superior.toString());
                    LOGGER.info("Net salary: " + superior.calculerSalaireNet());
                    LOGGER.info("Total salary: " + superior.calculerSalaireTotal(160, 10, 5));

                    // Employee Normal
                    Employee normalEmployee = new NormalEmployes("Doe", "John", 12345, null, null, null, 3000.0, "Normal");
                    LOGGER.info("Normal Employee details: " + normalEmployee.toString());
                    LOGGER.info("Net salary: " + normalEmployee.calculerSalaireNet());
                    LOGGER.info("Total salary: " + normalEmployee.calculerSalaireTotal(160, 10, 5));

                    // Employee Guard
                    Employee guard = new Guard("Johnson", "Jane", 98765, null, null, null, 2500.0, "Guard");
                    LOGGER.info("Guard details: " + guard.toString());
                    LOGGER.info("Net salary: " + guard.calculerSalaireNet());
                    LOGGER.info("Total salary: " + guard.calculerSalaireTotal(160, 10, 5));

                    // Exemple d'utilisation de la classe Calendar
                    YearMonth currentMonth = YearMonth.now();
                    List<DayOfWeek> normalWorkingDays = Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY);
                    List<DayOfWeek> guardianWorkingDays = Arrays.asList(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY);

                    Calendar calendar = new Calendar(currentMonth, null, normalWorkingDays, guardianWorkingDays);
                    LOGGER.info("Printing calendar for " + currentMonth);
                    calendar.printCalendar();

                    LocalDate today = LocalDate.now();
                    int hoursPerDay = 8;

                    int workHours = calendar.calculateWorkHours(today, hoursPerDay);
                    LOGGER.info("Work hours for " + today + ": " + workHours);

                    int overtimeHours = calendar.calculateOvertimeHours(today, hoursPerDay);
                    LOGGER.info("Overtime hours for " + today + ": " + overtimeHours);
                }

}





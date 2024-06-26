import org.example.model.*;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.example.model.Pointage.*;
import static org.junit.Assert.assertEquals;

public class PointageTest {
    Employee rakoto=new Guard("Rakoto","be",1234,new Date(1999,12,12),new Date(2024,04,06),new Date(2023,12,12),100000d,"guard","jour");
    Employee rabe=new Guard("Rabe","kely",1234,new Date(1999,12,12),new Date(2024,04,06),new Date(2023,12,12),100000d,"guard","nuit");
    @Test
    public void heureDeTravailTestJour(){
        List<DayOfWeek> workingDays = new ArrayList<>();
        List<LocalDate> publicHolidays = new ArrayList<>();
        Employee normalEmployee = new NormalEmployes("Nom", "Prenom", 123, new Date(), new Date(), new Date(), 100000d, "Categorie1");
        Employee guard = new Guard("Nom", "Prenom", 456, new Date(), new Date(), new Date(), 100000d, "Categorie2","nuit");
        Guard guarde = new Guard("Nom", "Prenom", 456, new Date(), new Date(), new Date(), 100000d, "Categorie2","nuit");
        Calendar calendar1=new Calendar(publicHolidays,LocalDate.of(2024, 5, 26),LocalDate.of(2024, 7, 6));
        Pointage pointage=new Pointage(calendar1,rakoto);
        assertEquals(420,heureDeTravail(pointage));
    }
    @Test
    public void heureDeTravailTestNuit(){
        List<DayOfWeek> workingDays = new ArrayList<>();
        List<LocalDate> publicHolidays = new ArrayList<>();
        Employee normalEmployee = new NormalEmployes("Nom", "Prenom", 123, new Date(), new Date(), new Date(), 3000.0, "Categorie1");
        Employee guard = new Guard("Nom", "Prenom", 456, new Date(), new Date(), new Date(), 3500.0, "Categorie2","nuit");
        Guard guarde = new Guard("Nom", "Prenom", 456, new Date(), new Date(), new Date(), 3500.0, "Categorie2","nuit");
        Calendar calendar1=new Calendar(publicHolidays,LocalDate.of(2024, 5, 26),LocalDate.of(2024, 7, 6));
        Pointage pointage=new Pointage(calendar1,rabe);
        assertEquals(588,heureDeTravail(pointage));
    }
    @Test
    public void salaireGagneParRabeNormal(){
        List<LocalDate> publicHolidays = new ArrayList<>();
        Calendar calendar1=new Calendar(publicHolidays,LocalDate.of(2024, 5, 26),LocalDate.of(2024, 7, 6));
        Pointage pointage=new Pointage(calendar1,rabe);
        double expectedSalary = 780000;
        double actualSalary = amountSalary(pointage);
        double delta = 0.0001;
        assertEquals(expectedSalary, actualSalary, delta);
    }
    @Test
    public void salaireGagneParRakotoNormal(){
        List<LocalDate> publicHolidays = new ArrayList<>();
        Calendar calendar1=new Calendar(publicHolidays,LocalDate.of(2024, 5, 26),LocalDate.of(2024, 7, 6));
        Pointage pointage=new Pointage(calendar1,rakoto);
        double expectedSalary = 600000;
        double actualSalary = amountSalary(pointage);
        double delta = 0.0001;
        assertEquals(expectedSalary, actualSalary, delta);
    }
    @Test
    public void salaireGagneParRakotoavecJourFerie(){
        List<LocalDate> publicHolidays = new ArrayList<>();
        publicHolidays.add(LocalDate.of(2024, Month.JUNE, 17));
        publicHolidays.add(LocalDate.of(2024, Month.JUNE, 25));
        publicHolidays.add(LocalDate.of(2024, Month.JUNE, 26));
        Calendar calendar1=new Calendar(publicHolidays,LocalDate.of(2024, 5, 26),LocalDate.of(2024, 7, 6));
        Pointage pointage=new Pointage(calendar1,rakoto);
        double expectedSalary = 612857.1428571428;
        double actualSalary = amountSalary(pointage);
        double delta = 0.0001;
        assertEquals(expectedSalary, actualSalary, delta);
    }
    @Test
    public void salaireGagneParRabeavecJourFerie(){
        List<LocalDate> publicHolidays = new ArrayList<>();
        publicHolidays.add(LocalDate.of(2024, Month.JUNE, 17));
        publicHolidays.add(LocalDate.of(2024, Month.JUNE, 25));
        publicHolidays.add(LocalDate.of(2024, Month.JUNE, 26));
        Calendar calendar1=new Calendar(publicHolidays,LocalDate.of(2024, 5, 26),LocalDate.of(2024, 7, 6));
        Pointage pointage=new Pointage(calendar1,rabe);
        double expectedSalary = 807855.2142857143;
        double actualSalary = amountSalary(pointage);
        double delta = 0.0001;
        assertEquals(expectedSalary, actualSalary, delta);
    }
}

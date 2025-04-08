package Level_1.Exercici_1.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class RunMain {

    private final static List<Month> months = new ArrayList<>();

    public static void run() {

        createMonthList();

        System.out.println("Antes de añadir agosto:");
        for (Month month : months) {
            System.out.println("- " + month);
        }

        months.add(7, new Month("Agosto"));

        System.out.println("Después de añadir agosto en la posición correspondiente:");
        for (Month month : months) {
            System.out.println("- " + month);
        }

        months.add(7, new Month("Agosto"));
        System.out.println("Agosto duplicado");

        HashSet<Month> monthsHashSet = new HashSet<>(months);
        System.out.println("Hashset creado y meses añadidos");

        System.out.println("El HashSet sin duplicados, gracias a los métodos sobrescritos en la clase Month:");
        Iterator<Month> iterator = monthsHashSet.iterator();

        while (iterator.hasNext()) {
            System.out.println("- " + iterator.next());
        }
    }

    public static void createMonthList() {
        String[] monthNames = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        for (String monthName : monthNames) {
            months.add(new Month(monthName));
        }
    }

}
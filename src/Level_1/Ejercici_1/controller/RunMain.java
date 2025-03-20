package Level_1.Ejercici_1.controller;

import Level_1.Ejercici_1.model.entities.Month;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class RunMain {

    public static void run() {

        ArrayList<Month> months = new ArrayList<>();

        months.add(new Month("Enero"));
        months.add(new Month("Febrero"));
        months.add(new Month("Marzo"));
        months.add(new Month("Abril"));
        months.add(new Month("Mayo"));
        months.add(new Month("Junio"));
        months.add(new Month("Julio"));
        months.add(new Month("Septiembre"));
        months.add(new Month("Octubre"));
        months.add(new Month("Noviembre"));
        months.add(new Month("Diciembre"));

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

}
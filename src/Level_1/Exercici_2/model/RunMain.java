package Level_1.Exercici_2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class RunMain {

    public static void run() {

        List<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        System.out.println("Orden original: " + numbers);

        List<Integer> numbersReverseOrder = new ArrayList<>();

        ListIterator<Integer> iterator = numbers.listIterator(numbers.size());
        while(iterator.hasPrevious()) {
            numbersReverseOrder.add(iterator.previous());
        }

        System.out.println("Orden inverso usando el ListIterator: " + numbersReverseOrder);
    }

}
    package Level_1.Ejercici_2;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.ListIterator;

    public class Main {

        public static void main(String[] args) {

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

            System.out.println("Orden inverso usando ListIterator: " + numbersReverseOrder);

        }

    }
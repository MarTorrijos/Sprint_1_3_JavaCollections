package Level_2.Exercici_1.model;

import Level_2.Exercici_1.model.data.RestaurantInstances;

import java.util.Scanner;

import static Level_2.Exercici_1.Main.restaurants;

public class RunMain {

    private final Scanner scanner = new Scanner(System.in);
    private String name = "";
    private int rating = 0;


    public void run() {

        RestaurantInstances.loadRestaurantData(restaurants);

        System.out.println("_________Restaurantes iniciales________");
        for (Restaurant restaurant : restaurants) {
            System.out.println("- " + restaurant);
        }
        System.out.println("________________________________________");

        System.out.println("Se prueba de introducir un restaurante que ya existe (name: Can Paco, rating: 10)");
        handleRestaurantAddition("Can Paco", 10);

        System.out.println("________________________________________");

        System.out.println("Se introduce un restaurante con nombre que ya existe pero distinta puntuación (name: Can Paco, rating: 1)");
        handleRestaurantAddition("Can Paco", 1);

        System.out.println("_________Restaurantes actualizados________");
        for (Restaurant restaurant : restaurants) {
            System.out.println("- " + restaurant);
        }

        System.out.println("________________________________________");

        name = addName();
        rating = addRating();
        handleRestaurantAddition(name, rating);

        scanner.close();

        System.out.println("________________________________________"
                + "\nRestaurantes finales. Con el nuevo restaurante añadido:");

        for (Restaurant restaurant : restaurants) {
            System.out.println("- " + restaurant);
        }

    }

    public String addName() {
        boolean hasName = false;


        while (!hasName) {
            System.out.println("Dime el nombre del restaurante que quieres introducir:");
            name = scanner.nextLine();

            if (name.isEmpty()) {
                System.out.println("Nombre de restaurante vacío. Debes introducir un nombre");
            } else {
                hasName = true;
            }
        }

        return name;
    }

    public int addRating() {
        boolean hasRating = false;

        while (!hasRating) {
            System.out.println("Introduce la puntuación. Puede ser una cifra del 1 al 10");
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                System.out.println("No puedes dejar la puntuación en blanco");
            } else {
                try {
                    rating = Integer.parseInt(input);
                    if (rating < 0 || rating > 10) {
                        System.out.println("Número incorrecto. Debes introducir una puntuación del 1 al 10");
                    } else {
                        hasRating = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Puntuación inválida. Debes introducir un número del 1 al 10");
                }
            }
        }

        return rating;
    }

    private static void handleRestaurantAddition(String name, int rating) {
        boolean restaurantExists = Restaurant.checkDuplicity(restaurants, name, rating);

        if (!restaurantExists) {
            System.out.println(Restaurant.addRestaurant(name, rating));
        } else {
            System.out.println("Ya existe un restaurante con el mismo nombre y puntuación. Lo siento, no se puede añadir");
        }
    }

}
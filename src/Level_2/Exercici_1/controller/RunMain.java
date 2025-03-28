package Level_2.Exercici_1.controller;

import Level_2.Exercici_1.model.data.RestaurantInstances;
import Level_2.Exercici_1.model.entities.Restaurant;

import java.util.InputMismatchException;
import java.util.Scanner;

import static Level_2.Exercici_1.Main.restaurants;

public class RunMain {

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        boolean hasName = false;
        boolean hasRating = false;
        boolean restaurantHasBeenAdded = false;
        boolean restaurantExists;
        String name = "";
        int rating = 0;

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

        // Añadir restaurante
        do {
            // Pide name
            while (!hasName) {
                try {
                    System.out.println("Dime el nombre del restaurante que quieres introducir:");
                    name = scanner.nextLine();

                    if (name.isEmpty()) {
                        throw new IllegalArgumentException();
                    }

                    hasName = true;

                } catch (IllegalArgumentException e) {
                    System.out.println("Nombre de restaurante vacío. Debes introducir un nombre");
                }
            }

            // Pide rating
            while (!hasRating) {
                try {
                    System.out.println("Introduce la puntuación. Puede ser una cifra del 1 al 10");
                    String input = scanner.nextLine();

                    // Largo de explicar por qué recibo los datos como string y luego lo cambio
                    // Pero el resumen es que sino tenía problemas con consumir las entradas vacías
                    rating = Integer.parseInt(input);

                    if (rating < 0 || rating > 10) {
                        throw new IllegalArgumentException();
                    }

                    hasRating = true;

                } catch (IllegalArgumentException | InputMismatchException e) {
                    System.out.println("Número incorrecto. Debes introducir una puntuación del 1 al 10");
                }

            }

            scanner.close();

            // Comprueba si el restaurante existe y lo añade o no
            restaurantExists = Restaurant.checkDuplicity(restaurants, name, rating);

            if (!restaurantExists) {
                System.out.println(Restaurant.addRestaurant(name, rating));
                restaurantHasBeenAdded = true;
            } else {
                System.out.println("Ya existe un restaurante con el mismo nombre y puntuación. Lo siento, no se puede añadir");
                // Se reinician name y rating
                hasName = false;
                hasRating = false;
            }

        } while (!restaurantHasBeenAdded);

        System.out.println("________________________________________"
                + "\nRestaurantes finales. Con el nuevo restaurante añadido:");
        for (Restaurant restaurant : restaurants) {
            System.out.println("- " + restaurant);
        }

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
package Level_2.Ejercici_2.controller;

import Level_2.Exercici_1.model.data.RestaurantInstances;
import Level_2.Exercici_1.model.entities.Restaurant;
import Level_2.Ejercici_2.model.RestaurantComparator;

import java.util.ArrayList;
import java.util.List;

import static Level_2.Exercici_1.Main.restaurants;

public class RunMain {

    public static void run() {

        RestaurantInstances.loadRestaurantData(restaurants);

        System.out.println("Restaurantes cargados desde el ejercicio 1:");
        for (Restaurant restaurant : restaurants) {
            System.out.println("- " + restaurant);
        }

        System.out.println("________________________________________");

        System.out.println("Se añade un restaurante con el mismo nombre y distinta puntuación.");
        restaurants.add(new Restaurant("Can Paco", 1));

        List<Restaurant> restaurants = new ArrayList<>(Level_2.Exercici_1.Main.restaurants);

        restaurants.sort(new RestaurantComparator());

        System.out.println("Restaurantes ordenados por nombre y puntuación descendente:");
        for (Restaurant restaurant : restaurants) {
            System.out.println("- " + restaurant);
        }

    }

}
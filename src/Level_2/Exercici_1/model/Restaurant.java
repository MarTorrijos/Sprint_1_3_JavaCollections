package Level_2.Exercici_1.model;

import java.util.HashSet;

import static Level_2.Exercici_1.Main.restaurants;

public class Restaurant {

    private final String name;
    private final int rating;

    public Restaurant(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public static boolean checkDuplicity(HashSet<Restaurant> restaurants, String name, int rating) {
        boolean restaurantExists = false;
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getName().equalsIgnoreCase(name) && restaurant.getRating() == rating) {
                restaurantExists = true;
            }
        }

        return restaurantExists;
    }

    public static String addRestaurant(String name, int rating) {
        restaurants.add(new Restaurant(name, rating));

        return "Restaurante con nombre " + name + " y puntuación de " + rating + " añadido";
    }

    @Override
    public String toString() {
        return this.name + ", puntuación de " + this.rating;
    }

}
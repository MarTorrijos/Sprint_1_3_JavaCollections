package Level_2.Exercici_2.model;

import Level_2.Exercici_1.model.Restaurant;
import Level_2.Exercici_1.model.data.RestaurantInstances;

import java.util.Set;
import java.util.TreeSet;

import static Level_2.Exercici_1.Main.restaurants;

public class RunMain {
    public static void run() {
        RestaurantInstances.loadRestaurantData(restaurants);

        Set<Restaurant> restaurantsSet = new TreeSet<>(new RestaurantComparator());

        restaurantsSet.addAll(restaurants);

        restaurantsSet.add(new Restaurant("Can Paco", 1));

        System.out.println("Restaurantes ordenados por nombre y puntuación descendente:");
        for (Restaurant restaurant : restaurantsSet) {
            System.out.println("- " + restaurant);
        }
    }
}

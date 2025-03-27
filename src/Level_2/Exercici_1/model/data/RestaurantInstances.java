package Level_2.Exercici_1.model.data;

import Level_2.Exercici_1.model.entities.Restaurant;

import java.util.HashSet;

public class RestaurantInstances {

    public static void loadRestaurantData(HashSet<Restaurant> restaurants) {
        restaurants.add(new Restaurant("Can Paco", 10));
        restaurants.add(new Restaurant("Pizzeria Roma", 7));
        restaurants.add(new Restaurant("Pizza Hut", 5));
        restaurants.add(new Restaurant("Ensaladas Conchi", 6));
    }
    
}

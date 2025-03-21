package Level_2.Ejercici_2.model;

import Level_2.Ejercici_1.model.entities.Restaurant;

import java.util.Comparator;

public class RestaurantComparator implements Comparator<Restaurant> {

    @Override
    public int compare(Restaurant r1, Restaurant r2) {
        int nameComparison = r1.getName().compareTo(r2.getName());
        if (nameComparison == 0){
            return Integer.compare(r1.getRating(), r2.getRating());
        }
        return nameComparison;
    }

}
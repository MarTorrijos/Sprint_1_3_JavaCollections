package Level_2.Ejercici_1;

import Level_2.Ejercici_1.controller.RunMain;
import Level_2.Ejercici_1.model.entities.Restaurant;

import java.util.HashSet;

public class Main {
    public static HashSet<Restaurant> restaurants = new HashSet<>();

    public static void main(String[] args) {
        RunMain.run();
    }

}
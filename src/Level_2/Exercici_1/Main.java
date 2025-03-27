package Level_2.Exercici_1;

import Level_2.Exercici_1.controller.RunMain;
import Level_2.Exercici_1.model.entities.Restaurant;

import java.util.HashSet;

public class Main {
    public static HashSet<Restaurant> restaurants = new HashSet<>();

    public static void main(String[] args) {
        RunMain.run();
    }

}
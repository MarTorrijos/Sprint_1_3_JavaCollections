package Level_1.Exercici_3.controller;

import Level_1.Exercici_3.model.GameMethods;

public class GameController {

    private GameMethods gameMethods;

    public GameController() {
        this.gameMethods = new GameMethods();
    }

    public void run() {
        gameMethods.fillHashMap();
        gameMethods.storeUsername();
        gameMethods.playGame();

        System.out.println("Juego terminado :D Tu puntuación es de " + gameMethods.getPoints() + " puntos");
        System.out.println(gameMethods.storeRatingToTxt());
    }

}
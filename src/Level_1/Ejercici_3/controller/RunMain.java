package Level_1.Ejercici_3.controller;

import Level_1.Ejercici_3.model.Methods;

import java.util.Scanner;

import static Level_1.Ejercici_3.model.Methods.*;

public class RunMain {

    static Scanner scanner = new Scanner(System.in);
    static String answer;

    public static void run() {
        Methods.fillHashMap(getFileLocation());

        System.out.print("Dime tu nombre de usuario: ");
        String username = scanner.nextLine();

        System.out.println("De acuerdo, " + username + ".");

        for (int i = 0; i < 10; i++) {
            System.out.println("Cual es la capital de este país? Responde con el nombre en inglés (sorry):\n"
                    + randomCountry());

            answer = scanner.nextLine().trim();
            System.out.println(checkAnswer(answer));
        }

        System.out.println("Juego terminado :D Tu puntuación es de " + Methods.getPoints() + " puntos");
    }

}
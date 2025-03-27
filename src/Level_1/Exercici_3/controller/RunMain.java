package Level_1.Exercici_3.controller;

import Level_1.Exercici_3.model.Methods;

import java.io.IOException;
import java.util.Scanner;

import static Level_1.Exercici_3.model.Methods.*;

public class RunMain {

    static Scanner scanner = new Scanner(System.in);
    static String answer;
    static String username;

    public static void run() {
        Methods.fillHashMap(getFileLocation());
        boolean hasUsername = false;

        while (!hasUsername) {
            try {
                System.out.print("Dime tu nombre de usuario: ");
                username = scanner.nextLine();

                if (username.isEmpty()) {
                    throw new IOException();
                }

                hasUsername = true;
                System.out.println("De acuerdo, " + username + ".");
                playGame();

            } catch (IOException e) {
                System.out.println("No puedes dejar el nombre vacío >:(");

            }
        }
    }

    private static void playGame() {
        for (int i = 0; i < 2; i++) {

            try {
                System.out.print("Cual es la capital de este país? Responde con el nombre en inglés (sorry):\n"
                        + randomCountry() + " - ");
                answer = scanner.next().trim();

                // esto quizás no es buena práctica (meter un if else dentro de un try-catch)
                // Comprobar
                if (answer.isEmpty()) {
                    throw new IOException();
                } else {
                    System.out.println(checkAnswer(answer));
                }
            } catch (IOException e) {
                System.out.println("Responder en blanco no es una capital");
            }

            // Guardar la puntuación!
        }

        System.out.println("Juego terminado :D Tu puntuación es de " + Methods.getPoints() + " puntos");
    }

}
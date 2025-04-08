package Level_1.Exercici_3.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class GameMethods {

    private final HashMap<String, String> countries = new HashMap<>();
    private final Path FILELOCATION = Paths.get("src", "Level_1", "Exercici_3", "resources", "countries.txt");
    private int points = 0;
    private String selectedCountry, username;
    private final Scanner scanner = new Scanner(System.in);

    public int getPoints() {
        return points;
    }

    public void fillHashMap() {
        try (BufferedReader bufferedReader = Files.newBufferedReader(FILELOCATION)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(" ");

                if (parts.length == 2) {
                    countries.put(parts[0], parts[1]);
                } else {
                    System.out.println("Error. Formato de datos inválido" + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error. Archivo no encontrado o error de lectura");
            e.printStackTrace();
        }
    }

    public void storeUsername() {
        boolean hasUsername = false;

        while (!hasUsername) {
            System.out.print("Dime tu nombre de usuario: ");
            username = scanner.nextLine().trim();

            if (username.isEmpty()) {
                System.out.println("No puedes dejar el nombre de usuario en blanco");
            } else {
                hasUsername = true;
                System.out.println("De acuerdo, " + username + ".");
            }
        }
    }

    public void playGame() {
        for (int i = 1; i < 10; i++) {
            System.out.print("¿Cuál es la capital de este país? Responde con el nombre en inglés (sorry):\n"
                    + randomCountry() + " - ");
            String answer = scanner.nextLine().trim();

            if (answer.isEmpty()) {
                System.out.println("Responder en blanco no es una opción");
            } else {
                System.out.println(checkAnswer(answer));
            }
        }
    }

    public String randomCountry() {
        List<String> keys = new ArrayList<>(countries.keySet());
        Random rand = new Random();

        selectedCountry = keys.get(rand.nextInt(keys.size()));

        return selectedCountry;
    }

    public String checkAnswer(String answer) {
        String correctCapital = countries.get(selectedCountry);
        String message;

        if (answer.equalsIgnoreCase(correctCapital)) {
            points++;
            message = "Correcto! Has ganado un punto";
        } else {
            message = "Capital incorrecta";
        }
        return message;
    }

    public String storeRatingToTxt() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("classification.txt"))) {
            pw.println("Nombre de usuario: " + username);
            pw.println("Puntuación de " + points + " puntos");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
        return "Nombre de usuario y puntuación guardados en un .txt";
    }

}
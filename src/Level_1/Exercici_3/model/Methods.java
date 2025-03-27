package Level_1.Exercici_3.model;

import java.io.*;
import java.util.*;

public class Methods {

    private static final HashMap<String, String> countries = new HashMap<>();
    private static final String fileLocation = "src/Level_1/Exercici_3/resources/countries.txt";
    private static int points = 0;
    private static String selectedCountry;

    public static String getFileLocation() {
        return fileLocation;
    }

    public static int getPoints() {
        return points;
    }

    public static void fillHashMap(String fileLocation) {
        // Sustituido el Scanner por un BufferedReader por razones de eficiencia
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation))) {
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

    public static String randomCountry() {
        List<String> keys = new ArrayList<>(countries.keySet());
        Random rand = new Random();

        selectedCountry = keys.get(rand.nextInt(keys.size()));

        return selectedCountry;
    }

    public static String checkAnswer(String answer) {
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

}
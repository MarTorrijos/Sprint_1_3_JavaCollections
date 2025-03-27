package Level_1.Ejercici_3.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Methods {

    private static final HashMap<String, String> countries = new HashMap<>();
    // esto no hacerlo así
    // hacer un bufferedReader
    private static final String fileLocation = "src/Level_1/Ejercici_3/resources/countries.txt";
    private static int points = 0;
    private static String selectedCountry;

    public static String getFileLocation() {
        return fileLocation;
    }

    public static int getPoints() {
        return points;
    }

    public static void fillHashMap(String fileLocation) {
        try {
            File countriesTextFile = new File(fileLocation);
            Scanner myReader = new Scanner(countriesTextFile);

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] parts = data.split(" ");

                if (parts.length == 2) {
                    countries.put(parts[0], parts[1]);
                } else {
                    System.out.println("Warning: Invalid data format (country capital expected): " + data);
                }
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error. Archivo no encontrado");
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
            message = "Correcto! Has ganado un punto.";
        } else {
            message = "Capital incorrecta. Prueba otra vez.";
        }

        return message;
    }

}
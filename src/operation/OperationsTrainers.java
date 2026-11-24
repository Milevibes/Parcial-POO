package operation;

import clases.Pokemon;
import clases.Trainer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static clases.Trainer.parseTrainer;

public class OperationsTrainers {
    public static void removePokemonFromTrainers(Pokemon pokemon) {

    }

    public static boolean saveTrainer(Trainer trainer) {
        try {
            FileWriter escribir = new FileWriter("Trainer.csv", true);
            escribir.write(trainer.trainerToCSV());
            escribir.write("\n");
            escribir.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public static Trainer readOneTrainer(String name) {
        try {
            FileReader lector = new FileReader("Trainer.csv");
            BufferedReader buffer = new BufferedReader(lector);
            String TrainerReader;
            boolean encontrado = false;

            while ((TrainerReader = buffer.readLine()) != null) {
                if (TrainerReader.toLowerCase().contains(name.toLowerCase())) {
                    System.out.println("Entrenador: " + TrainerReader);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("No se encontro el Entrenador buscado");
            }
            buffer.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static List<Trainer> readTrainers() {
        try {
            List<Trainer> currentTrainers = new ArrayList();
            FileReader lector = new FileReader("Trainer.csv");
            BufferedReader buffer = new BufferedReader(lector);
            String TrainerReader;
            while ((TrainerReader = buffer.readLine()) != null) {
                String[] tempLine = TrainerReader.split(",");
                Trainer temp = new Trainer();
                temp.setId(tempLine[0]);
                temp.setTrainerName(tempLine[1]);
                temp.setMedallas(Integer.parseInt(tempLine[2]));
                currentTrainers.add(temp);
            }
            buffer.close();
            return currentTrainers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return List.of();
    }
    private static List<String> readLines() {
        List<String> lineas = new ArrayList<>();
        File archivo = new File("Trainer.csv");

        if (!archivo.exists()) {
            return lineas;
        }

        try (BufferedReader buffer = new BufferedReader(
                new InputStreamReader(new FileInputStream(archivo), StandardCharsets.UTF_8))) {

            String linea;
            while ((linea = buffer.readLine()) != null) {
                if (!linea.isBlank()) {
                    lineas.add(linea);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }

        return lineas;
    }

    public static boolean deleteTrainer(String referencia) {
        if (referencia == null) {
            return false;
        }

        String buscado = referencia.trim();
        List<String> restantes = new ArrayList<>();
        boolean borrado = false;

        for (String linea : readLines()) {
            Trainer trainer = parseTrainer(linea);
            if (trainer != null
                    && (trainer.getId().equalsIgnoreCase(buscado)
                    || trainer.getTrainerName().equalsIgnoreCase(buscado))) {
                borrado = true;
            } else {
                restantes.add(linea);
            }
        }

        if (borrado) {
            return writeLines(restantes);
        }
        return false;
    }

    private static boolean writeLines(List<String> lineas) {
        try (BufferedWriter escribir = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("Trainer.csv"), StandardCharsets.UTF_8))) {

            for (String linea : lineas) {
                escribir.write(linea);
                escribir.newLine();
            }
            return true;

        } catch (IOException e) {
            System.out.println("Error al escribir: " + e.getMessage());
            return false;
        }
    }
}

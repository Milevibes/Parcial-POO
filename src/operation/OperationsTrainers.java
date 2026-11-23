package operation;

import java.io.*;

public class OperationsTrainers {
    public static void saveTrainer(String nameTrainer, String[] Pokemones) {
        try {
            FileWriter escribir = new FileWriter("Trainer.csv", true);
            String equipo = String.join(" | ", Pokemones);
            escribir.write(nameTrainer + ": " + equipo + "\n");
            escribir.close();
            System.out.println("Entrenador guardado");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void readOneTrainer(String name){
        try {
            FileReader lector = new FileReader("Trainer.csv");
            BufferedReader buffer = new BufferedReader(lector);
            String TrainerReader;
            boolean encontrado = false;

            while ((TrainerReader = buffer.readLine()) != null) {
                if (TrainerReader.toLowerCase().contains(name.toLowerCase())){
                    System.out.println("Entrenador: "+ TrainerReader);
                    encontrado = true;
                }
            }
            if (!encontrado){
                System.out.println("No se encontro el Entrenador buscado");
            }
            buffer.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void readTrainers() {
        try {
            FileReader lector = new FileReader("Trainer.csv");
            BufferedReader buffer = new BufferedReader(lector);
            String TrainerReader;
            while ((TrainerReader = buffer.readLine()) != null) {
                System.out.println(TrainerReader);
            }
            buffer.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void deleteTrainer(String name){
        boolean borrado = false;

        try {
            FileReader lector = new FileReader("Trainer.csv");
            BufferedReader buffer = new BufferedReader(lector);
            String TrainerReader;

            while ((TrainerReader = buffer.readLine()) != null) {
                if (!TrainerReader.toLowerCase().contains(name.toLowerCase())) ;
                else {
                    borrado = true;
                }
            }
            buffer.close();

            FileWriter escribir = new FileWriter("Trainer.csv");
            escribir.write("\n");

            escribir.close();

            if (borrado){
                System.out.println("Entrenador eliminado");
            } else {
                System.out.println("No se encontro el Entrenador");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

package operation;

import java.io.*;

public class OperationsTrainers {
    public static void saveTrainer(String nameTrainer, String[] Pokemones) {
        try {
            FileWriter escribir = new FileWriter("Trainer.csv", true);
            String equipo = String.join(" | ", Pokemones);
            escribir.write(nameTrainer + "," + equipo + "\n");
            escribir.close();
            System.out.println("Entrenador guardado");
        } catch (IOException e) {
            System.out.println("Error al guardar entrenador: " + e.getMessage());
        }
    }
}

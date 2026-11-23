package clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Trainer {
    private int id;
    private String trainerName;
    private Pokemon[] plantilla;

    public Trainer(String trainerName, Pokemon[] plantilla) {
        this.id = (int) (Math.random() * 100) + 1;
        this.trainerName = trainerName;
        this.plantilla = plantilla;
    }
}

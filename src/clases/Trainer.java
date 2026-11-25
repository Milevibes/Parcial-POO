package clases;


import operation.OperationsPokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Trainer {
    private String id;
    private String trainerName;
    private Pokemon[] plantilla;
    private int medallas;

    public Trainer(String trainerName, Pokemon[] plantilla) {
        this(trainerName, plantilla, 0);
    }

    public Trainer(String trainerName, Pokemon[] plantilla, int medallas) {
        this.setId();
        this.trainerName = trainerName;
        this.plantilla = plantilla;
        this.medallas = medallas;
    }

    public Trainer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setId() {
        this.id = UUID.randomUUID().toString().substring(0, 3);
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public Pokemon[] getPlantilla() {
        return plantilla;
    }

    public void setPlantilla(Pokemon[] plantilla) {
        this.plantilla = plantilla;
    }

    public int getMedallas() {
        return medallas;
    }

    public void setMedallas(int medallas) {
        this.medallas = medallas;
    }

    public String trainerToCSV() {
        StringBuilder pokemones = new StringBuilder();
        if (plantilla != null) {
            for (int i = 0; i < plantilla.length; i++) {
                if (plantilla[i] == null) {
                    continue;
                }
                if (pokemones.length() > 0) {
                    pokemones.append(",");
                }
                pokemones.append(plantilla[i].getId());
            }
        }
        return this.getId() + "," + this.getTrainerName() + "," + this.getMedallas() + "," + pokemones;
    }

    @Override
    public String toString() {
        int cantidad = plantilla == null ? 0 : plantilla.length;
        return trainerName + " (" + cantidad + " pok., " + medallas + " med.)";
    }
    public static Trainer parseTrainer(String linea) {
        if (linea == null || linea.trim().isEmpty()) {
            return null;
        }

        String[] partes = linea.split(",", 4);
        if (partes.length < 3) {
            return null;
        }

        String id = partes[0].trim();
        String nombre = partes[1].trim();

        int medallas = 0;
        try {
            medallas = Integer.parseInt(partes[2].trim());
        } catch (NumberFormatException e) {
            return null;
        }

        List<Pokemon> equipo = new ArrayList<>();
        if (partes.length == 4 && !partes[3].trim().isEmpty()) {
            String[] idsPokemon = partes[3].split(",");
            for (String idPoke : idsPokemon) {
                String limpio = idPoke.trim();
                if (!limpio.isEmpty()) {
                    Pokemon encontrado = OperationsPokemon.readOnePokemon(limpio);
                    if (encontrado != null) {
                        equipo.add(encontrado);
                    }
                }
            }
        }

        Trainer trainer = new Trainer();
        trainer.setId(id); // Conserva el ID original del CSV, no genera uno nuevo
        trainer.setTrainerName(nombre);
        trainer.setMedallas(medallas);
        trainer.setPlantilla(equipo.toArray(new Pokemon[0]));
        return trainer;
    }
}

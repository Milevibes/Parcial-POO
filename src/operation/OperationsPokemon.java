package operation;

import clases.Pokemon;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class OperationsPokemon {
    private static final String ARCHIVO = "Pokemon.csv";
    private static final String SIN_ENTRENADOR = "Sin entrenador";

    public static boolean savePokemon(Pokemon pokemonToSave) {
        if (pokemonToSave == null) {
            return false;
        }

        try {
            File archivo = new File(ARCHIVO);

            try (BufferedWriter escribir = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(archivo, true), StandardCharsets.UTF_8))) {

                escribir.write(pokemonToSave.PokemonToCSV());
                escribir.newLine();
            }
            return true;

        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
            return false;
        }
    }

    public static List<Pokemon> readPokemons() {
        List<Pokemon> pokemones = new ArrayList<>();
        File archivo = new File(ARCHIVO);

        if (!archivo.exists()) {
            return pokemones;
        }

        try (BufferedReader buffer = new BufferedReader(
                new InputStreamReader(new FileInputStream(archivo), StandardCharsets.UTF_8))) {

            String linea;
            while ((linea = buffer.readLine()) != null) {
                Pokemon pokemon = parsePokemon(linea);
                if (pokemon != null) {
                    pokemones.add(pokemon);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer: " + e.getMessage());
        }

        return pokemones;
    }

    public static Pokemon readOnePokemon(String referencia) {
        if (referencia == null) {
            return null;
        }

        String buscado = referencia.trim();
        for (Pokemon pokemon : readPokemons()) {
            if (pokemon.getId().equalsIgnoreCase(buscado)
                    || pokemon.getName().equalsIgnoreCase(buscado)) {
                return pokemon;
            }
        }
        return null;
    }

    public static Pokemon findByName(String name) {
        if (name == null) {
            return null;
        }

        for (Pokemon pokemon : readPokemons()) {
            if (pokemon.getName().equalsIgnoreCase(name.trim())) {
                return pokemon;
            }
        }
        return null;
    }

    public static boolean deletePokemon(String referencia) {
        if (referencia == null) {
            return false;
        }

        String buscado = referencia.trim();
        List<String> restantes = new ArrayList<>();
        boolean borrado = false;

        for (String linea : readLines()) {
            Pokemon pokemon = parsePokemon(linea);
            if (pokemon != null
                    && (pokemon.getId().equalsIgnoreCase(buscado)
                    || pokemon.getName().equalsIgnoreCase(buscado))) {
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

    public static boolean assignTrainer(Pokemon[] equipo, String trainerName) {
        List<String> ids = new ArrayList<>();
        if (equipo != null) {
            for (Pokemon pokemon : equipo) {
                if (pokemon != null) {
                    ids.add(pokemon.getId());
                }
            }
        }
        return assignTrainerByIds(ids, trainerName);
    }

    public static boolean assignTrainerByIds(List<String> ids, String trainerName) {
        if (ids == null || ids.isEmpty() || trainerName == null) {
            return true;
        }

        List<String> nuevas = new ArrayList<>();
        boolean cambio = false;

        for (String linea : readLines()) {
            Pokemon pokemon = parsePokemon(linea);
            if (pokemon != null && ids.contains(pokemon.getId())) {
                if (!pokemon.getTrainer().equalsIgnoreCase(trainerName)) {
                    pokemon.setTrainer(trainerName);
                    cambio = true;
                }
                nuevas.add(pokemon.PokemonToCSV());
            } else {
                nuevas.add(linea);
            }
        }

        return !cambio || writeLines(nuevas);
    }

    public static boolean clearTrainer(String trainerName) {
        if (trainerName == null) {
            return true;
        }

        List<String> nuevas = new ArrayList<>();
        boolean cambio = false;

        for (String linea : readLines()) {
            Pokemon pokemon = parsePokemon(linea);
            if (pokemon != null && pokemon.getTrainer().equalsIgnoreCase(trainerName)) {
                pokemon.setTrainer(SIN_ENTRENADOR);
                nuevas.add(pokemon.PokemonToCSV());
                cambio = true;
            } else {
                nuevas.add(linea);
            }
        }

        return !cambio || writeLines(nuevas);
    }

    public static boolean clearTrainerByIds(List<String> ids, String trainerName) {
        if (ids == null || ids.isEmpty()) {
            return true;
        }

        List<String> nuevas = new ArrayList<>();
        boolean cambio = false;

        for (String linea : readLines()) {
            Pokemon pokemon = parsePokemon(linea);
            if (pokemon != null && ids.contains(pokemon.getId())
                    && (trainerName == null || pokemon.getTrainer().equalsIgnoreCase(trainerName))) {
                pokemon.setTrainer(SIN_ENTRENADOR);
                nuevas.add(pokemon.PokemonToCSV());
                cambio = true;
            } else {
                nuevas.add(linea);
            }
        }

        return !cambio || writeLines(nuevas);
    }

    private static Pokemon parsePokemon(String linea) {
        if (linea == null || linea.isBlank()) {
            return null;
        }

        String[] datos = linea.split(",", -1);
        if (datos.length < 5) {
            return null;
        }

        Pokemon pokemon = new Pokemon();
        pokemon.setId(datos[0].trim());
        pokemon.setName(datos[1].trim());
        pokemon.setNumber(datos[2].trim());
        pokemon.setType(datos[3].trim());
        pokemon.setLevel(datos[4].trim());
        pokemon.setTrainer(datos.length > 5 && !datos[5].isBlank()
                ? datos[5].trim()
                : SIN_ENTRENADOR);
        return pokemon;
    }

    private static List<String> readLines() {
        List<String> lineas = new ArrayList<>();
        File archivo = new File(ARCHIVO);

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

    private static boolean writeLines(List<String> lineas) {
        try (BufferedWriter escribir = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(ARCHIVO), StandardCharsets.UTF_8))) {

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

package operation;

import java.io.*;

public class Operations {
        public static void savePokemon(clases.Pokemon pokemonToSave) {
            try {
                File archivo = new File("Pokemon.csv");
                FileWriter escribir = new FileWriter(archivo, true);

                escribir.write(pokemonToSave.PokemonToCSV() + "\n");
                escribir.close();
                System.out.println("Pokemon Guardado");

            } catch (IOException e) {
                System.out.println("Error al guardar: " + e.getMessage());
            }
        }
        public static void readOnePokemon(String name){
                try {
                    FileReader lector = new FileReader("Pokemon.csv");
                    BufferedReader buffer = new BufferedReader(lector);
                    String PokemonReader;
                    boolean encontrado = false;

                    while ((PokemonReader = buffer.readLine()) != null) {
                        if (PokemonReader.toLowerCase().contains(name.toLowerCase())){
                            System.out.println("Pokemon: "+ PokemonReader);
                            encontrado = true;
                        }
                    }
                    if (!encontrado){
                        System.out.println("No se encontro el clases.Pokemon buscado");
                    }
                    buffer.close();

                 } catch (Exception e) {
                 System.out.println(e.getMessage());
            }
        }
        public static void readPokemons() {
        try {
            FileReader lector = new FileReader("Pokemon.csv");
            BufferedReader buffer = new BufferedReader(lector);
            String PokemonReader;

            while ((PokemonReader = buffer.readLine()) != null) {
                System.out.println(PokemonReader);
            }

            buffer.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            }
        }
        public static void deletePokemon(String name){
        boolean borrado = false;

        try {
            FileReader lector = new FileReader("Pokemon.csv");
            BufferedReader buffer = new BufferedReader(lector);
            String PokemonReader;

            while ((PokemonReader = buffer.readLine()) != null) {
                if (!PokemonReader.toLowerCase().contains(name.toLowerCase())) ;
                else {
                    borrado = true;
                }
            }
            buffer.close();

            FileWriter escribir = new FileWriter("Pokemon.csv");
            escribir.write("\n");

            escribir.close();

            if (borrado){
                System.out.println("Pokemon eliminado");
            } else {
                System.out.println("No se encontro el Pokemon");
            }
        }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


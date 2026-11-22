import java.io.*;
import java.util.Locale;

public class Operations {
        public static void savePokemon(Pokemon pokemonToSave) {
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
                        System.out.println("No se encontro el Pokemon buscado");
                    }
                 } catch (Exception e) {
                 System.out.println(e.getMessage());
            }
        }
    }


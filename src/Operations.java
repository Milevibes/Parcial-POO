import java.io.*;

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

                    while ((PokemonReader = buffer.readLine()) != null) ;
                 } catch (Exception e) {
                 System.out.println(e.getMessage());
            }
        }
    }


import clases.Pokemon;
import clases.Trainer;
import frontend.InicioModerno;
import operation.OperationsPokemon;
import operation.OperationsTrainers;

import java.awt.EventQueue;
import java.util.List;
import java.util.Scanner;
import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        iniciarInterfaz();
    }

    private static void iniciarInterfaz() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {
        }

        EventQueue.invokeLater(() -> {
            try {
                new InicioModerno().setVisible(true);
            } catch (Exception e) {
                System.out.println("No se pudo abrir la interfaz: " + e.getMessage());
            }
        });
    }

    public static void menuConsola() {
        Scanner leer = new Scanner(System.in);
        int seleccionarOpcion;

        do {
            System.out.println("\n********MENÚ PRINCIPAL*******");
            System.out.println("1. Menú Pokemones");
            System.out.println("2. Menú Entrenadores");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            seleccionarOpcion = leer.nextInt();
            leer.nextLine();

            switch (seleccionarOpcion) {
                case 1:
                    menuPokemon(leer);
                    break;
                case 2:
                    menuTrainers(leer);
                    break;
                case 0:
                    System.out.println("Hasta la próxima :)");
                    break;
                default:
                    System.out.println("Opción NO válida");
            }
        } while (seleccionarOpcion != 0);
    }

    public static void menuPokemon(Scanner leer) {
        int opcion;
        do {
            System.out.println("\n*****MENÚ POKEMONES*****");
            System.out.println("1. Crear Pokemon");
            System.out.println("2. Buscar Pokemon");
            System.out.println("3. Mostrar todos los Pokemones");
            System.out.println("4. Borrar Pokemon");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:
                    newPokemon();
                    break;
                case 2:
                    searchPokemon();
                    break;
                case 3:
                    showAllPokemons();
                    break;
                case 4:
                    deletePokemon();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción NO válida.");
            }
        } while (opcion != 0);
    }

    public static void menuTrainers(Scanner leer) {
        int opcion;
        do {
            System.out.println("\n*****MENÚ ENTRENADORES*****");
            System.out.println("1. Crear Entrenador");
            System.out.println("2. Buscar Entrenador");
            System.out.println("3. Mostrar todos los Entrenadores");
            System.out.println("4. Borrar Entrenador");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:
                    newTrainer();
                    break;
                case 2:
                    searchTrainer();
                    break;
                case 3:
                    readTrainers();
                    break;
                case 4:
                    deleteTrainer();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opción NO válida.");
            }
        } while (opcion != 0);
    }

    public static void newPokemon() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el nombre del Pokemon");
        String name_pokemon = leer.nextLine();
        System.out.println("Ingrese el número del Pokemon");
        String number = leer.nextLine();
        System.out.println("Ingrese el tipo del Pokemon");
        String type = leer.nextLine();
        System.out.println("Ingrese el nivel del Pokemon");
        String level = leer.nextLine();

        boolean guardado = OperationsPokemon.savePokemon(new Pokemon(name_pokemon, number, type, level));
        System.out.println(guardado ? "Pokemon guardado" : "No se pudo guardar el Pokemon");
    }

    public static void searchPokemon() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el Pokemon a buscar");
        Pokemon pokemon = OperationsPokemon.readOnePokemon(leer.next());
        System.out.println(pokemon != null ? pokemon : "No se encontro el Pokemon");
    }

    public static void showAllPokemons() {
        List<Pokemon> pokemones = OperationsPokemon.readPokemons();
        if (pokemones.isEmpty()) {
            System.out.println("No hay Pokemones guardados");
            return;
        }
        for (Pokemon pokemon : pokemones) {
            System.out.println(pokemon);
        }
    }

    public static void deletePokemon() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el Pokemon a eliminar");
        boolean borrado = OperationsPokemon.deletePokemon(leer.next());
        System.out.println(borrado ? "Pokemon eliminado" : "No se encontro el Pokemon");
    }

    public static void newTrainer() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el nombre del Entrenador");
        String name_trainer = leer.next();

        String[] plantilla = new String[6];
        for (int i = 0; i < plantilla.length; i++) {
            System.out.println("Ingrese el nombre del Pokemon " + (i + 1) + ":");
            plantilla[i] = leer.next();
        }
        //OperationsTrainers.saveTrainer(name_trainer, plantilla);
    }

    public static void searchTrainer() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el Entrenador a buscar");
        Trainer trainer = OperationsTrainers.readOneTrainer(leer.next());
        System.out.println(trainer != null ? trainer : "No se encontro el Entrenador");
    }

    public static void readTrainers() {
        List<Trainer> entrenadores = OperationsTrainers.readTrainers();
        if (entrenadores.isEmpty()) {
            System.out.println("No hay Entrenadores guardados");
            return;
        }
        for (Trainer trainer : entrenadores) {
            System.out.println(trainer);
        }
    }

    public static void deleteTrainer() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el Entrenador a eliminar");
        OperationsTrainers.deleteTrainer(leer.next());
    }
}

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int seleccionarOpcion;

        do {
            System.out.println("\n********MENÚ PRINCIPAL*******");
            System.out.println("1. Menú Pokemon");
            System.out.println("2. Menú Trainers");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            seleccionarOpcion = leer.nextInt();

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
            System.out.println("4. Actualizar Pokemon");
            System.out.println("5. Borrar Pokemon");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = leer.nextInt();

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
                case 0:
                    break;
                default:
                    System.out.println("Opción NO válida.");
            }
        } while(opcion !=0);
    }

        public static void menuTrainers(Scanner leer) {
            int opcion;
            do {
                System.out.println("\n*****MENÚ TRAINERS*****");
                System.out.println("1. Crear Entrenador");
                System.out.println("2. Buscar Entrenador");
                System.out.println("3. Mostrar todos los Entrenadores");
                System.out.println("4. Actualizar Entrenador");
                System.out.println("5. Borrar Entrenador");
                System.out.println("0. Volver al Menú Principal");
                System.out.print("Seleccione una opción: ");
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                        newTrainer();
                        break;

                    case 0:
                        break;
                    default:
                        System.out.println("Opción NO válida.");
                }
            } while(opcion !=0);
        }
    public static void newPokemon() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el nombre del Pokemon");
        String name_pokemon = leer.nextLine();
        Operations.savePokemon(new Pokemon(name_pokemon));
    }
    public static void searchPokemon() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el Pokemon a buscar");
        Operations.readOnePokemon(leer.next());
    }
    public static void showAllPokemons() {
        Operations.readPokemons();
    }
    public static void newTrainer() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el nombre del Entrenador");
        String name_trainer = leer.nextLine();
        OperationsTrainers.saveTrainer();
    }
}
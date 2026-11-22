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

                    break;
                case 0:
                    System.out.println("Hasta luego, buen día :)");
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
            System.out.println("2. Buscar Jugador");
            System.out.println("3. Mostrar todos los Jugadores");
            System.out.println("4. Actualizar Jugador");
            System.out.println("5. Borrar Jugador");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:
                    newPokemon();
                    break;
                case 2:
                    findPokemon();
                    break;
                case 3:
                    showAllPokemon();
                    break;
                case 4:
                    updatePokemon();
                    break;
                case 5:
                    deletePokemon();
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
        leer.nextLine();
        Operations.savePokemon(new Pokemon(name_pokemon));
    }
    public static void findPokemon() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el pokemon a buscar");
        Operations.readOnePokemon(leer.next());


    }

}
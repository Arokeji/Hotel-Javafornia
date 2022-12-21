import java.util.Scanner;

public class Main {

    static String[] guests = new String[10];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        insertTestNames();

        do {
            displayGuests();
            displayMenu();
            int option = getOption();

            if (option == 1) {
                addGuest();
            }
            else if (option == 2) {
                insertGuest();
            }
            else if (option == 3) {
                renameGuest();
            }
            else if (option == 4) {
                removeGuest();
            }
            else if (option == 5) {
                System.out.println("Saliendo...");
                break;
            }
        } while (true);

    }

    static void displayGuests() {
        System.out.println("______________________________\n- Visitantes -\n");
        boolean isEmpty = true;
        for (int i = 0; i < guests.length; i++) {
            if (guests[i] != null) {
                System.out.println((i + 1) + ". " + guests[i]);
                isEmpty = false;
            }
        }

        if (isEmpty) {
            System.out.println("La lista de visitantes esta vacia.");
        }
    }

    static void displayMenu() {
        System.out.println("______________________________\n- Menu -\n");
        System.out.println("1 - Nuevo Visitante");
        System.out.println("2 - Añadir Visitante en el Orden Seleccionado");
        System.out.println("3 - Renombrar Visitante");
        System.out.println("4 - Eliminar Visitante");
        System.out.println("5 - Salir");
    }

    static int getOption() {
        System.out.print("Option: ");
        int option = scanner.nextInt(); //
        scanner.nextLine();
        System.out.println();
        return option;
    }

    static void addGuest() {
        for (int i = 0; i < guests.length; i++) {
            if (guests[i] == null) {
                System.out.print("Name: ");
                guests[i] = scanner.nextLine();
                break;
            }
        }
    }

    static void insertGuest() {
        System.out.print("Número: ");
        int num = scanner.nextInt();
        scanner.nextLine();

        if (num >= 1 && num <= 10 && guests[num - 1] != null) {
            System.out.print("Nombre: ");
            String name = scanner.nextLine();

            for (int i = guests.length - 1; i > num - 1; i--) {
                guests[i] = guests[i - 1];
            }

            guests[num - 1] = name;
        }
        else {
            System.out.println("\nError: No hay ningún visitante con ese número.");
        }
    }

    static void renameGuest() {
        System.out.print("Número: ");
        int num = scanner.nextInt();
        scanner.nextLine();

        if (num >= 1 && num <= 10 && guests[num - 1] != null) {
            System.out.print("Nombre: ");
            String name = scanner.nextLine();

            guests[num - 1] = name;
        }
        else {
            System.out.println("\nError: No hay ningún visitante con ese número.");
        }
    }

    static void removeGuest() {
        System.out.print("Número: ");
        int num = scanner.nextInt();

        if (num >= 1 && num <= 10 && guests[num - 1] != null) {
            guests[num - 1] = null;

            String[] temp = new String[guests.length];
            int ti = 0;
            for (int i = 0; i < guests.length; i++) {
                if (guests[i] != null) {
                    temp[ti] = guests[i];
                    ti++;
                }
            }
            guests = temp;
        }
        else {
            System.out.println("\nError: No hay ningún visitante con ese número.");
        }
    }

    static void insertTestNames() {
        guests[0] = "Anacleto Macías";
        guests[1] = "Eustaquio Varas";
        guests[2] = "Rodrigo Chinchilla";
        guests[3] = "Amiano Torroja";
        guests[4] = "Florencia Cabeza de Vaca";
    }

}
package exceptions.a2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CompteEstalvi compteEstalvi = new CompteEstalvi("CuentaDeChema");
        Client client;
        /*compteEstalvi.addUser(new Client("Chema", "Becerra", "12345678Z"));*/

        System.out.println("Introduce un nombre");
        String nombre = scan.nextLine();
        System.out.println("Introduce tu apellido");
        String apellido = scan.nextLine();
        System.out.println("Introduce tu DNI");
        String dni = scan.nextLine();
        client = new Client(nombre, apellido, dni);

        try {
            client.validarDNI(dni);
            compteEstalvi.addUser(client);
        } catch (ClientAccountException e) {
            e.printStackTrace();
        }
        compteEstalvi.ingressar(25);
        System.out.println("Cuento dinero quieres sacar" + " Tienes 25 euros");
        int dinero = scan.nextInt();
        scan.nextLine();

        try {
            compteEstalvi.treure(dinero);
            System.out.println("Su saldo actual es de: " + compteEstalvi.getSaldo() + " euros");
        } catch (BankAccountException e) {
            e.printStackTrace();
            System.exit(0);
        }
        while (true) {
            System.out.println("¿Quieres borrar un usuario?");
            System.out.println("Tienes " + compteEstalvi.getLlista_usuaris().size() + "usuarios");
            String opcion = scan.nextLine();
            if ("si".equals(opcion) || "Si".equals(opcion) || "1".equals(opcion)) {
                try {
                    compteEstalvi.removeUser(client.getDNI());
                    System.out.println("Usuario eliminado");
                } catch (BankAccountException e) {
                    e.printStackTrace();
                    System.exit(0);
                }
            } else {
                System.out.println("Terminando sesion");
                try {
                    Thread.sleep(2000);
                    break;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

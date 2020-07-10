package JavaApplication;

import java.util.Scanner;

public class Main {

    public static AddressBook addressBook = new AddressBook();
    public static Scanner scanner = new Scanner(System.in);
    private static int index = 1;

    public static void main(String[] args) {
        init();

        String line = scanner.nextLine();
        while (!line.equalsIgnoreCase("Q")) {
            if (line.equalsIgnoreCase("A")) pridaj();
            else if (line.equalsIgnoreCase("E")) uprav();
            else if (line.equalsIgnoreCase("D")) zmaz();
            else if (line.equalsIgnoreCase("S")) najdi();
            else if (line.equalsIgnoreCase("L")) zoznam();

            else System.out.println("Skus iny prikaz");
            line = scanner.nextLine();
        }
    }

    private static void pridaj() {
        System.out.println("Zadaj meno: ");
        String firstName = scanner.nextLine();
        System.out.println("Zadaj priezvisko: ");
        String lastName = scanner.nextLine();
        System.out.println("Zadaj e-mail: ");
        String email = scanner.nextLine();

        addressBook.add(new Person(firstName, lastName, email, index++));
    }

    private static void zmaz() {
        System.out.println("Zadaj id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Person p = addressBook.findPersonById(id);

        if (p != null) {
            addressBook.deletePerson(p.getId());
            System.out.println("Odstranenie uspesne");
        } else {
            System.out.println("Osoba nenajdena");
        }
    }

    private static void uprav() {
        System.out.println("Zadaj id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Person p = addressBook.findPersonById(id);

        if (p != null) {
            System.out.println("Zadaj meno: ");
            String firstName = scanner.nextLine();
            System.out.println("Zadaj priezvisko: ");
            String lastName = scanner.nextLine();
            System.out.println("Zadaj e-mail: ");
            String email = scanner.nextLine();

            addressBook.add(new Person(firstName, lastName, email, id));
            System.out.println("Uprava uspesna");
        } else {
            System.out.println("Osoba nenajdena");
        }
    }

    private static void najdi() {
        System.out.println("Zadaj id:");
        int id = scanner.nextInt();
        scanner.nextLine();
        Person p = addressBook.findPersonById(id);

        if (p != null) {
            System.out.println("Osoba: " + p.getFirstName() + " " + p.getLastName() + ", email: " + p.getEmail() + ", id: " + id);
        } else {
            System.out.println("Osoba nenajdena");
        }
    }

    private static void zoznam() {
        for (Person p : addressBook.getPersons().values()) {
            System.out.println("Osoba: " + p.getFirstName() + " " + p.getLastName() + ", email: " + p.getEmail() + ", id: " + p.getId());
        }
    }

    private static void init() {
        System.out.println("\nChoose your action: (A)dd, (E)dit, (D)elete, (S)earch, (L)ist, (Q)uit ");
        naplnenieAddressBooku();
    }

    private static void naplnenieAddressBooku() {
        addressBook.add(new Person("AAaaaa", "Aaaaaa", "aa", index++));
        addressBook.add(new Person("Bbbb", "bbbbb", "bb", index++));
        addressBook.add(new Person("ccccc", "ccccc", "cc", index++));
        addressBook.add(new Person("ddddd", "ddddd", "dd", index++));
        addressBook.add(new Person("eeeee", "eeeee", "ee", index++));
    }
}

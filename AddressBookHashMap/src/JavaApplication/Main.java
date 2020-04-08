package JavaApplication;

import java.util.Scanner;

public class Main {

    public static AddressBook addressBook = new AddressBook();

    public static void main(String[] args) {
        Scanner vstup = new Scanner(System.in);

        mainLoop:
        while (true) {
            System.out.println("\nEnter a command: (A)/(E)/(D)/(S)/(L)/(Q)");
            String input = vstup.nextLine();
            switch (input) {
                case "A":
                    System.out.println("Enter a name: ");
                    String firstName = vstup.nextLine();
                    System.out.println("Enter a last name: ");
                    String lastName = vstup.nextLine();
                    System.out.println("Enter an e-mail: ");
                    String email = vstup.nextLine();

                    addressBook.add(firstName,lastName,email);
                    break;

                case "E":
                    System.out.println("Enter an UUID: ");
                    String editedUuid = vstup.nextLine();
                    System.out.println("Enter a new first name (or leave blank): ");
                    String newFirstName = vstup.nextLine();
                    System.out.println("Enter a new last name (or leave blank): ");
                    String newLastName = vstup.nextLine();
                    System.out.println("Enter a new e-mail (or leave blank): ");
                    String newEmail = vstup.nextLine();

                    addressBook.edit(editedUuid, newFirstName, newLastName, newEmail);
                    break;

                case "D":
                    System.out.println("Enter an UUID: ");
                    String deleteUuid = vstup.nextLine();

                    addressBook.delete(deleteUuid);
                    break;

                case "S":
                    System.out.println("Enter an UUID: ");
                    String searchUuid = vstup.nextLine();

                    addressBook.search(searchUuid);
                    break;

                case "L":
                    addressBook.list();
                    break;

                case "Q":
                    System.out.println("Exiting...");
                    break mainLoop;

                default:
                    System.out.println("Wrong command.");
            }
        }
    }
}

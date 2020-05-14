package AddressBook;

import java.util.Scanner;

public class Main {

    public static AddressBook addressBook = new AddressBook();

    public static void main(String[] args) {
        Scanner vst = new Scanner(System.in);
        String firstName;
        String lastName;
        String email;
        mainLoop:
        while (true) {
            System.out.println("(a)dd, (e)dit, (d)elete, (s)earch, (l)ist, (q)uit");
            String input = vst.nextLine();
            switch (input) {
                case "a":
                    System.out.println("Zadaj meno: ");
                    firstName = vst.nextLine();
                    System.out.println("Zadaj priezvisko: ");
                    lastName = vst.nextLine();
                    System.out.println("Zadaj e-mail: ");
                    email = vst.nextLine();
                    addressBook.add(firstName,lastName,email);
                    break;
                case "e":
                    System.out.println("Zadaj UUID: ");
                    String editedUuid =vst.nextLine();
                    System.out.println("Zadaj nové meno: ");
                    String newFirstName =vst.nextLine();
                    System.out.println("Zadaj nové priezvisko: ");
                    String newLastName =vst.nextLine();
                    System.out.println("Zadaj nový e-mail: ");
                    String newEmail = vst.nextLine();
                    addressBook.edit(editedUuid, newFirstName, newLastName, newEmail);
                    break;

                case "d":
                    System.out.println("Zadaj UUID: ");
                    String deleteUuid = vst.nextLine();
                    addressBook.delete(deleteUuid);
                    break;

                case "s":
                    System.out.println("Zadaj UUID: ");
                    String searchUuid = vst.nextLine();
                    addressBook.search(searchUuid);
                    break;

                case "l":
                    addressBook.list();
                    break;

                case "q":
                    break mainLoop;

                default:
                    System.out.println("Nesprávný príkaz.");
            }
        }
    }
}

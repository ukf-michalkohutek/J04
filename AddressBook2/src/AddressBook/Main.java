package AddressBook;

import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

public class Main  {

    public static void main(String[] args) {
        UUID uuid;
        HashMap<UUID, Student> Students = new HashMap<>();
        Scanner vstup = new Scanner(System.in);
        String meno;
        String priezvisko;
        String email;
        boolean quit = true;
        while (quit) {
            switch (vstup.next().charAt(0)){
                case 'a':
                    uuid = UUID.randomUUID();
                    meno = vstup.next();
                    priezvisko = vstup.next();
                    email = vstup.next();
                    Students.put(uuid, new Student(meno,priezvisko,email));
                    break;
                case 'd':
                    Students.remove(UUID.fromString(vstup.next()));
                    break;
                case 'e':
                    uuid = UUID.fromString(vstup.next());
                    meno = vstup.next();
                    priezvisko = vstup.next();
                    email = vstup.next();
                    Students.put(uuid, new Student(meno,priezvisko,email));
                    break;
                case 's':
                    meno = vstup.next();
                    System.out.println(Students.get(UUID.fromString(meno)).getFirstName() + " " + Students.get(UUID.fromString(meno)).getLastName() + " " + Students.get(UUID.fromString(meno)).getEmail());
                    break;
                case 'l':
                    for(UUID i: Students.keySet()) System.out.println(i + " " + Students.get(i).getFirstName() + " " + Students.get(i).getLastName() + " " + Students.get(i).getEmail());
                    break;
                case 'q':
                    quit = false;
                    break;
                default:
                    break;
            }
        }
    }
}

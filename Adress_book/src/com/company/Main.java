package com.company;

import java.util.Scanner;
import java.util.HashMap;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Scanner vstup = new Scanner(System.in);
        HashMap<UUID, Osoba> Students = new HashMap<>();
        UUID uuid;
        String meno, priezvisko, email;
        boolean odist = true;

        while (odist) {
            System.out.println(" a → pridá novú osobu do zoznamu: meno priezvisko email \n d → vymazať osobu \n " +
                    "e → upraví osobu s uuid, takisto meno priezvisko email \n → vráti údaje o osobe \n " +
                    "l → vypise cely zoznam \n q → odist");
            switch (vstup.next().charAt(0)){
                case 'a':
                    uuid = UUID.randomUUID();
                    meno = vstup.next();
                    priezvisko = vstup.next();
                    email = vstup.next();
                    Students.put(uuid, new Osoba(meno,priezvisko,email));
                    break;
                case 'd':
                    Students.remove(UUID.fromString(vstup.next()));
                    break;
                case 'e':
                    uuid = UUID.fromString(vstup.next());
                    meno = vstup.next();
                    priezvisko = vstup.next();
                    email = vstup.next();
                    Students.put(uuid, new Osoba(meno,priezvisko,email));
                    break;
                case 's':
                    meno = vstup.next();
                    System.out.println(Students.get(UUID.fromString(meno)).getFirstName() + " " + Students.get(UUID.fromString(meno)).getLastName() + " " + Students.get(UUID.fromString(meno)).getEmail());
                    break;
                case 'l':
                    for(UUID i: Students.keySet()) System.out.println(i + " " + Students.get(i).getFirstName() + " " + Students.get(i).getLastName() + " " + Students.get(i).getEmail());
                    break;
                case 'q':
                    odist = false;
                    break;
                default:
                    break;
            }
        }
    }
}

package com.company;
import java.util.Scanner;

public class Main {
    public static Hashmap adressmap = new Hashmap();
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        adressmap.loadstartup();

        System.out.println("(A)dd, (E)dit, (D)elete, (S)earch, (L)ist, (Q)uit");

        String vstup = "";
        boolean run = true;

        while (run) {
            System.out.println("INPUT OPTION:");
            vstup = scan.nextLine();
            switch (vstup){
                case "A":
                    add();
                    break;
                case "E":
                    edit();
                    break;
                case "D":
                    delete();
                    break;
                case "S":
                    search();
                    break;
                case "L":
                    list();
                    break;
                case "Q":
                    run = false;
                    break;
            }
            System.out.println();
        }

    }

    public static void add() {
        System.out.println("Vloz meno");
        String meno = scan.nextLine();
        System.out.println("Vloz priezvysko");
        String priezvysko = scan.nextLine();
        System.out.println("Vloz email");
        String email = scan.nextLine();

        adressmap.put(new Student(meno, priezvysko, email));
        System.out.println("Meno bolo vlozene");

    }
    public static void edit() {
        System.out.println("Zadaj meno/priezvysko/mail:");
        String input = scan.nextLine();
        int pocetvyskytov = adressmap.find(input);

        if (pocetvyskytov == 0) {
            System.out.println("Zaznam s danym menom neexistuje");
        }
        else if (pocetvyskytov == 1) {
            System.out.println("Najdeny jeden zaznam");
            System.out.println(adressmap.oneStudent(0));
            System.out.println("Pre zmenu vloz cislo - 0 meno, 1 priezvysko, 2 email:");
            int c = Integer.parseInt(scan.nextLine());
            if (c == 0){
                System.out.println("Vloz nove meno:");
            }
            else if (c == 1) {
                System.out.println("Vloz nove priezvysko:");
            }
            else if (c == 2){
                System.out.println("Vloz nove email:");
            }
            String newinput = scan.nextLine();
            adressmap.editrecord(0, c, newinput);

        }
        else {
            System.out.println("Najdene zaznamy");
            for (int i = 0; i < pocetvyskytov; i++) {
                System.out.println(i + "  " + adressmap.oneStudent(i));
            }
            System.out.println("Zadaj cislo zaznamu pre upravu");
            int j = Integer.parseInt(scan.nextLine());

            System.out.println("Pre zmenu vloz cislo - 0 meno, 1 priezvysko, 2 email:");
            int c = Integer.parseInt(scan.nextLine());
            if (c == 0){
                System.out.println("Vloz nove meno:");
            }
            else if (c == 1) {
                System.out.println("Vloz nove priezvysko:");
            }
            else if (c == 2){
                System.out.println("Vloz nove email:");
            }
            String newinput = scan.nextLine();
            adressmap.editrecord(j, c, newinput);
            System.out.println("Zaznam zmeneny");
        }

    }
    public static void delete() {
        System.out.println("Zadaj meno/priezvysko/mail:");
        String input = scan.nextLine();
        int pocetvyskytov = adressmap.find(input);

        if (pocetvyskytov == 0) {
            System.out.println("Zaznam s danym menom neexistuje");
        }
        else if (pocetvyskytov == 1) {
            System.out.println("Najdeny jeden zaznam");
            System.out.println(adressmap.oneStudent(0));
            adressmap.delete(0);
            System.out.println("Dany zaznam vymazany");
        }
        else {
            System.out.println("Najdene zaznamy");
            for (int i = 0; i < pocetvyskytov; i++) {
                System.out.println(i + "  " + adressmap.oneStudent(i));
            }
            System.out.println("Zadaj cislo zaznamu pre vymazanie");
            int c = Integer.parseInt(scan.nextLine());

            System.out.println("Mazem zaznam " + adressmap.oneStudent(c));
            adressmap.delete(c);
            System.out.println("Zaznam zmazany ");
        }
    }

    public static void search() {
        System.out.println("Zadaj meno/priezvysko/mail:");
        String input = scan.nextLine();
        int pocetvyskytov = adressmap.find(input);

        if (pocetvyskytov == 0) {
            System.out.println("Zaznam s danym menom neexistuje");
        }
        else if (pocetvyskytov == 1) {
            System.out.println("Najdeny jeden zaznam");
            System.out.println(adressmap.oneStudent(0));
        }
        else {
            System.out.println("Najdene zaznamy");
            for (int i = 0; i < pocetvyskytov; i++) {
                System.out.println(adressmap.oneStudent(i));
            }
        }
    }
    public static void list() {
        System.out.println("ADRESS BOOK table:");
        for(Student s: adressmap.values()){
            System.out.println(s.getFirstName() + "  " + s.getLastName() + "  " + s.getEmail());
        }

    }




}

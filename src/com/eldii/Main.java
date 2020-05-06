package com.eldii;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, String> mapa = new HashMap<>();
        int uuid = 0;
        boolean koniec = true;

        String dalsiPrikaz = "\u001B[33m"+"Ďalší príkaz?"+"\u001B[37m";
        String medzera = " ";
        String predelovac = "----------------------------";
        String info ="\u001B[35m"+ predelovac + "\n" + "Príkazy:" + "\n" + "(A)dd\n" + "(E)dit\n" + "(D)elete\n" + "(S)earch\n" + "(L)ist\n" + "(Q)uit\n" + predelovac+"\u001B[37m";
        System.out.println(info);

        while (koniec) {
            String vstup = in.next();
            switch (vstup) {
                default:
                    System.out.println("Zlý príkaz\n" + info);
                    break;
                case "q":
                case "Q":
                    koniec = false;
                    break;
                case "L":
                case "l":
                    System.out.println(mapa);
                    System.out.println(dalsiPrikaz);
                    break;
                case "A":
                case "a":
                    System.out.print("Krstné Meno: ");
                    String meno = in.next();
                    System.out.print("Priezvisko: ");
                    String priezvisko = in.next();
                    mapa.put(uuid, meno + medzera + priezvisko);
                    uuid++;
                    System.out.println(dalsiPrikaz);
                    break;
                case "E" :
                case "e":
                    System.out.println("Zadaj ID osoby: ");
                    System.out.println(mapa);
                    int key = in.nextInt();
                    mapa.remove(key);
                    System.out.print("Krstné meno: ");
                    String meno1 = in.next();
                    System.out.print("Priezvisko: ");
                    String priezvisko1 = in.next();
                    mapa.put(uuid, meno1 + medzera + priezvisko1);
                    uuid++;
                    System.out.println(dalsiPrikaz);
                    break;
                case "D":
                case "d":
                    System.out.println("Zadaj ID osoby: ");
                    System.out.println(mapa);
                    mapa.remove(in.nextInt());
                    System.out.println(dalsiPrikaz);
                    break;
                case "S":
                case "s":
                    System.out.println("Na toto som jednoducho nevedel prísť, nepomohol mi ani stackoverflow...");
                    System.out.println(dalsiPrikaz);
                    break;
            }
        }
    }
}

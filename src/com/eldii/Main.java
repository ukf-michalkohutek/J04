package com.eldii;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        /*Scanner in = new Scanner(System.in);
        HashMap<Integer, String> mapa = new HashMap<>();
        int uuid = -1;
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
                    uuid++;
                    mapa.put(uuid, meno + medzera + priezvisko);
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
                    uuid++;
                    mapa.put(uuid, meno1 + medzera + priezvisko1);
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

            }
        }
    }*/
        //reset
        final String RESET = "\033[0m";

        // High Intensity
        final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
        final String RED_BRIGHT = "\033[0;91m";    // RED
        final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
        final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
        final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
        final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
        final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
        final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

        // Bold High Intensity
        final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
        final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
        final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
        final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
        final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
        final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
        final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
        final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

        //zdroj: https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

        Scanner in = new Scanner(System.in);
        HashMap<Integer,Osoba> mapa = new HashMap<>();

        String predelovac = "----------------------------";
        String info =YELLOW_BOLD_BRIGHT+ predelovac + "\n" + "Príkazy:" + "\n" + "(A)dd\n" + "(E)dit\n" +
                "(D)elete\n" + "(S)earch\n" + "(L)ist\n" + "(Q)uit\n" + predelovac+RESET;

        boolean koniec = false;
        int uuid = 0;

        System.out.println(info);
        while (!koniec) {
            switch (in.next()) {
                case "A":
                case "a":
                    System.out.print(PURPLE_BRIGHT+"Krstné Meno: ");
                    String meno = in.next();
                    System.out.print("Priezvisko: "+RESET);
                    String priezvisko = in.next();
                    mapa.put(uuid,new Osoba(meno,priezvisko,uuid));
                    uuid++;
                    break;
                case "E" :
                case "e":
                    System.out.print(PURPLE_BOLD_BRIGHT+"Zadaj ID osoby: "+RESET);
                    int idTemp = in.nextInt();
                    System.out.println(BLUE_BOLD_BRIGHT+"Upravuješ: "+mapa.get(idTemp).toString()+RESET);
                    System.out.print(PURPLE_BOLD_BRIGHT+"Zadaj nové meno: ");
                    String meno1 = in.next();
                    System.out.print("Zadaj nové priezvisko: "+RESET);
                    String priez1 = in.next();
                    mapa.get(idTemp).setMeno(meno1);
                    mapa.get(idTemp).setPriezvisko(priez1);
                    break;
                case "D":
                case "d":
                    System.out.print(PURPLE_BOLD_BRIGHT+"Zadaj ID osoby: "+RESET);
                    int idDel = in.nextInt();
                    System.out.println(BLUE_BOLD_BRIGHT+"Vymazal si:  "+mapa.get(idDel)+RESET);
                    mapa.remove(idDel);
                    break;
                case "L":
                case "l":
                    for (int i = 0;i<mapa.size();i++) {
                        System.out.println(mapa.get(i));
                    }
                    break;
                case "S":
                case "s":
                    System.out.print(PURPLE_BOLD_BRIGHT+"Zadaj priezvisko osoby: "+RESET);
                    String tempLast = in.next();
                    for (Integer i : mapa.keySet()) {
                        if (mapa.get(i).getPriezvisko().equals(tempLast)) {
                            System.out.println(mapa.get(i).toString());
                        }
                    }
                    break;
                case "q":
                case "Q":
                    System.out.print(RED_BOLD_BRIGHT+"Ukončujem procesy");
                    System.out.print(".");
                    Thread.sleep(400);
                    System.out.print(".");
                    Thread.sleep(400);
                    System.out.print(".");
                    System.exit(0);
                    break;
            }
        }
    }
}

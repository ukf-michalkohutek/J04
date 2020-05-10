package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        // write your code here
        HashMap<Integer, String> book = new HashMap<Integer, String>();
        int id = 1;
        book.put(id, "Karol Polák");
        id++;
        book.put(id, "Peter Šťastný");
        id++;
        book.put(id, "Tomáš Novák");
        id++;
        book.put(id, "Marek Cestný");
        id++;
        book.put(id, "Ondrej Višňa");

        System.out.println("Vyberte si z nasledujúcich možností:");
        System.out.println("A - pridajte položku do zoznamu");
        System.out.println("E - upravte položku zo zoznamu");
        System.out.println("D - vymažte položku zo zoznamu");
        System.out.println("S - vyhľadajte položku v zozname");
        System.out.println("L - vypísanie zoznamu");
        System.out.println("Q - ukončiť aplikáciu");
        System.out.println("----------------------");

        Scanner input = new Scanner(System.in);
        String row = input.nextLine();
        while (!row.equals("Q")){

            if (row.equals("A")) {
                System.out.println("Zadajte položku v tvare: Meno Priezvisko");
                row = input.nextLine();
                id++;
                book.put(id, row);
                System.out.println("Položka bola pridaná do zoznamu");
                System.out.println("----------------------");
                System.out.println("Môžte zadať ďalšiu možnosť");
                row = input.nextLine();
            }
        if (row.equals("E")) {
            System.out.println("Zadajte ID položky");
            row = input.nextLine();
            int number = Integer.parseInt(row);
            System.out.println("Zadajte novú položku v tvare: Meno Priezvisko");
            row = input.nextLine();
            book.replace(number, row);
            System.out.println("Položka bola upravená");
            System.out.println("----------------------");
            System.out.println("Môžte zadať ďalšiu možnosť");
            row = input.nextLine();
        }
        if (row.equals("D")) {
            System.out.println("Zadajte ID položky");
            row = input.nextLine();
            int number = Integer.parseInt(row);
            book.remove(number);
            System.out.println("Položka bola vymazaná zo zoznamu");
            System.out.println("----------------------");
            System.out.println("Môžte zadať ďalšiu možnosť");
            row = input.nextLine();
        }
        if (row.equals("S")) {
            System.out.println("Zadajte položku v tvare: Meno Priezvisko");
            row = input.nextLine();
            if (!book.containsValue(row)) {
                System.out.println("Daná položka sa v zozname nenachádza");
                System.out.println("Chcete ju pridať? Zadajte A");
                System.out.println("----------------------");
                System.out.println("Môžte zadať ďalšiu možnosť");
                row = input.nextLine();
            } else {
                System.out.println("Daná položka sa v zozname nachádza");
                System.out.println("----------------------");
                System.out.println("Môžte zadať ďalšiu možnosť");
                row = input.nextLine();
            }
        }
        if (row.equals("L")) {
            for (Map.Entry m : book.entrySet()) {
                System.out.println(m.getKey() + " " + m.getValue());
            }
            System.out.println("----------------------");
            System.out.println("Môžte zadať ďalšiu možnosť");
            row = input.nextLine();
        }
        if (row.equals("Q")) {
            System.exit(0);
        }
    }
    }
}

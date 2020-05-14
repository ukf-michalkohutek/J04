package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main {

    private static Scanner scan;
    private static adresar a;
    private static int ID = 1;

    public static void main(String[] args) {
        urob();

    }


    private static void vložMenoOsoby() {
        int b = -1;
        String line = null;
        while (b == -1 || b == 0) {
            System.out.println(" Pridaj meno a priezvisko osoby:");
            line = scan.nextLine();
            b = line.indexOf(" ");
        }
        if (line != null) {
            String stat = line.substring(0, b);
            String mesto = line.substring(b + 1);
            a.vložMenoOsoby(new statik(stat, mesto,ID++));
        } else {
            System.out.println("Neuložené");
        }
    }

    private static void NajdiMeno() {
        System.out.println("Zadaj ID: ");
        int id = scan.nextInt();
        scan.nextLine();
        statik s = a.NajdiMeno(id);
        if (s == null) {
            System.out.println("Zadané meno a priezvisko nenájdené");
        } else {
            System.out.println(s.toString());
        }
    }



    private static void rekonstruct() {
        System.out.println("Zadaj ID: ");
        int id = scan.nextInt();
        scan.nextLine();
        statik s = a.NajdiMeno(id);
        if (s == null) {
            System.out.println("zadané Meno neexistuje");
        } else {
            pridajMenoOsoby();
            System.out.println("Zmenené");
        }
    }

    private static void vymaz() {
        System.out.println("Zadaj ID: ");
        int id = scan.nextInt();
        scan.nextLine();
        statik s = a.NajdiMeno(id);
        if (s == null) {
            System.out.println("Meno a priezvisko nenájdené");
        } else {
            a.VymazMenoOsoby(s.getId());
            System.out.println("Meno a priezvisko sú vymazané");
        }
    }
    private static void naplnZoznam() {
        a.vložMenoOsoby(new statik("Ibrahim"+", ","Majga", 1));
        a.vložMenoOsoby(new statik("Vincent"+", ", "Klein", 2));
        a.vložMenoOsoby(new statik("HOrác"+", ", "Horák", 3));
        a.vložMenoOsoby(new statik("Servác"+", ", "Mokrý", 4));
        a.vložMenoOsoby(new statik("Júlia"+", ", "Nováková", 5));
        a.vložMenoOsoby(new statik("Martá"+", ", "Mladá", 6));
        a.vložMenoOsoby(new statik("Martin"+", ", "Nový", 7));
        idecko = 8;
    }


    private static void urob() {
        a = new adresát();
        scan = new Scanner(System.in);
        naplnZoznam();

    }

}

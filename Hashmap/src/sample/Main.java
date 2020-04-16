package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main {

    private static adresar a;
    private static Scanner c;
    private static int idecko = 1;

    public static void main(String[] args) {
        urob();
        menu();
    }

    private static void menu() {
        String vstup= c.nextLine();
        while (!vstup.equalsIgnoreCase("K")) {
            if (vstup.equalsIgnoreCase("A")) pridajStatMesto();
            if (vstup.equalsIgnoreCase("H")) hladajStatMesto();
            if (vstup.equalsIgnoreCase("U")) ukazStatMesto();
            if (vstup.equalsIgnoreCase("P")) prerob();
            if (vstup.equalsIgnoreCase("V")) vymaz();
            if (vstup.equalsIgnoreCase("N")) navigacia();
            vstup= c.nextLine();

        }
    }
    private static void pridajStatMesto() {
        int is = -1;
        String line = null;
        while (is == -1 || is == 0) {
            System.out.println(" Pridaj štát a  jeho hlavné mesto:");
            line = c.nextLine();
            is = line.indexOf(" ");
        }
        if (line != null) {
            String stat = line.substring(0, is);
            String mesto = line.substring(is + 1);
            a.pridajStatMesto(new statik(stat, mesto,idecko++));
        } else {
            System.out.println("Neuložené");
        }
    }

    private static void hladajStatMesto() {
        System.out.println("Zadajte ID: ");
        int id = c.nextInt();
        c.nextLine();
        statik s = a.NajdiStatMesto(id);
        if (s == null) {
            System.out.println("Štát a  jeho hlavné mesto nenájdené");
        } else {
            System.out.println(s.toString());
        }
    }

    private static void ukazStatMesto() {
        for (statik s : a.getPersons().values()) {
            System.out.println(s.toString());
        }
    }

    private static void prerob() {
        System.out.println("Zadajte ID: ");
        int id = c.nextInt();
        c.nextLine();
        statik s = a.NajdiStatMesto(id);
        if (s == null) {
            System.out.println("premenuj štát a  jeho hlavné mesto nenájdené");
        } else {
            pridajStatMesto();
            System.out.println("Upravené");
        }
    }

    private static void vymaz() {
        System.out.println("Zadajte ID: ");
        int id = c.nextInt();
        c.nextLine();
        statik s = a.NajdiStatMesto(id);
        if (s == null) {
            System.out.println("Štát a  jeho hlavné mesto nenájdené");
        } else {
            a.vymazStatMesto(s.getId());
            System.out.println("Štát a  jeho hlavné mesto vymazané");
        }
    }

    private static void navigacia() {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("XX  Pridaj = A      Hľadaj = H      Ukáž štáty a hlavné mestá = U      Prerob = P      Vymaž = V      Navigácia = N      Koniec = K  XX");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX Môžeš použiť aj mále pismená XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

    }

    private static void naplnMapu() {
        a.pridajStatMesto(new statik("Slovensko"+", ","Bratislava", 1));
        a.pridajStatMesto(new statik("Maďarsko"+", ", "Budapešť", 2));
        a.pridajStatMesto(new statik("Česko"+", ", "Praha", 3));
        a.pridajStatMesto(new statik("USA"+", ", "Washington D.C", 4));
        a.pridajStatMesto(new statik("Francúzsko"+", ", "Paris", 5));
        idecko = 6;
    }

    private static void urob() {
        a = new adresar();
        c = new Scanner(System.in);
        naplnMapu();
        navigacia();
    }

}

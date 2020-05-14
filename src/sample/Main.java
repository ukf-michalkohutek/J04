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
        menu();
    }

    private static void menu() {
        String vstup= scan.nextLine();
        while (!vstup.equalsIgnoreCase("K")) {
            if (vstup.equalsIgnoreCase("A")) pridajStatMesto();
            if (vstup.equalsIgnoreCase("H")) hladajStatMesto();
            if (vstup.equalsIgnoreCase("U")) ukazStatMesto();
            if (vstup.equalsIgnoreCase("P")) prerob();
            if (vstup.equalsIgnoreCase("V")) vymaz();
            if (vstup.equalsIgnoreCase("N")) navigacia();
            vstup= scan.nextLine();

        }
    }
    private static void pridajStatMesto() {
        int b = -1;
        String line = null;
        while (b == -1 || b == 0) {
            System.out.println(" Pridaj štát a  jeho hlavné mesto:");
            line = scan.nextLine();
            b = line.indexOf(" ");
        }
        if (line != null) {
            String stat = line.substring(0, b);
            String mesto = line.substring(b + 1);
            a.pridajStatMesto(new statik(stat, mesto,ID++));
        } else {
            System.out.println("Neuložené");
        }
    }

    private static void hladajStatMesto() {
        System.out.println("Zadaj ID: ");
        int id = scan.nextInt();
        scan.nextLine();
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
        System.out.println("Zadaj ID: ");
        int id = scan.nextInt();
        scan.nextLine();
        statik s = a.NajdiStatMesto(id);
        if (s == null) {
            System.out.println("premenuj štát a jeho hlavné mesto nenájdené");
        } else {
            pridajStatMesto();
            System.out.println("Upravené");
        }
    }

    private static void vymaz() {
        System.out.println("Zadaj ID: ");
        int id = scan.nextInt();
        scan.nextLine();
        statik s = a.NajdiStatMesto(id);
        if (s == null) {
            System.out.println("Štát a jeho hlavné mesto nenájdené");
        } else {
            a.vymazStatMesto(s.getId());
            System.out.println("Štát a jeho hlavné mesto vymazané");
        }
    }

    private static void navigacia() {
        System.out.println("000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000");
        System.out.println("00  Pridaj = A      Hľadaj = H      Ukáž štáty a ich hlavné mestá = U      Prerob = P      Vymaž = V      Navigácia = N      Koniec = K  00");
        System.out.println("000000000000000000000000000000000000000000000000000 Môžeš použiť aj mále pismená 000000000000000000000000000000000000000000000000000");

    }

    private static void naplnMapu() {
        a.pridajStatMesto(new statik("Austrália"+", ","Canberra", 1));
        a.pridajStatMesto(new statik("Slovensko"+", ", "Bratislava", 2));
        a.pridajStatMesto(new statik("Rusko"+", ", "Moskva", 3));
        a.pridajStatMesto(new statik("Irán"+", ", "Teherán", 4));
        a.pridajStatMesto(new statik("Grécko"+", ", "Atény", 5));
        ID = 6;
    }

    private static void urob() {
        a = new adresar();
        scan = new Scanner(System.in);
        naplnMapu();
        navigacia();
    }

}

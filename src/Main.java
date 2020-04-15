import java.util.Scanner;

public class Main {

    private static AddressBook ab;
    private static Scanner console;
    private static int ord = 1;

    public static void main(String[] args) {
        init();
        handleInput();
    }

    private static void handleInput() {
        String line = console.nextLine();
        while (!line.equalsIgnoreCase("Q")) {
            if (line.equalsIgnoreCase("L")) writeLegend();
            if (line.equalsIgnoreCase("C")) showPersons();
            else if (line.equalsIgnoreCase("S")) searchForPerson();
            else if (line.equalsIgnoreCase("A")) addPerson();
            else if (line.equalsIgnoreCase("E")) editPerson();
            else if (line.equalsIgnoreCase("D")) deletePerson();
            else System.out.println("Poziadavka nerozpoznana, skuste znovu");
            line = console.nextLine();
        }
    }

    private static void deletePerson() {
        System.out.println("Zadajte id:");
        int id = console.nextInt();
        console.nextLine();
        Person p = ab.findPersonById(id);
        if (p == null) {
            System.out.println("Osoba nenajdena");
        } else {
            ab.deletePerson(p.getId());
            System.out.println("Osoba odstranena");
        }
    }

    private static void editPerson() {
        System.out.println("Zadajte id:");
        int id = console.nextInt();
        console.nextLine();
        Person p = ab.findPersonById(id);
        if (p == null) {
            System.out.println("Osoba nenajdena");
        } else {
            addPerson();
            System.out.println("Upravene");
        }
    }

    private static void addPerson() {
        int is = -1;
        String line = null;
        while (is == -1 || is == 0) {
            System.out.println("Zadajte meno a priezvisko:");
            line = console.nextLine();
            is = line.indexOf(" ");
        }
        if (line != null) {
            String name = line.substring(0, is);
            String surname = line.substring(is + 1);
            ab.addPerson(new Person(name, surname, ord++));
        } else {
            System.out.println("Ulozenie neuspesne");
        }
    }

    private static void searchForPerson() {
        System.out.println("Zadajte id:");
        int id = console.nextInt();
        console.nextLine();
        Person p = ab.findPersonById(id);
        if (p == null) {
            System.out.println("Osoba nenajdena");
        } else {
            System.out.println(p.toString());
        }
    }

    private static void showPersons() {
        for (Person p : ab.getPersons().values()) {
            System.out.println(p.toString());
        }
    }


    private static void init() {
        ab = new AddressBook();
        console = new Scanner(System.in);
        fillDummy();
        writeLegend();
    }

    private static void writeLegend() {
        System.out.println("-------------------------");
        System.out.println("L - Legenda");
        System.out.println("C - Vypis listu");
        System.out.println("A - Add osoby");
        System.out.println("E - Edit osoby s id");
        System.out.println("D - Zmazanie osoby s id");
        System.out.println("S - Search osoby podla id");
        System.out.println("Q - Koniec");
        System.out.println("-------------------------");
        System.out.println();
        System.out.println();
    }

    private static void fillDummy() {
        ab.addPerson(new Person("Janko", "Marienka", 1));
        ab.addPerson(new Person("Janko", "Barlenka", 2));
        ab.addPerson(new Person("Danko", "Andrejka", 3));
        ab.addPerson(new Person("Janko", "Marlenka", 4));
        ab.addPerson(new Person("Jabko", "Snehulienka", 5));
        ord = 6;
    }
}

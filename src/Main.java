import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    static HashMap<Integer, String> nameList = new HashMap<Integer, String>();
    public static void main(String[] args) throws InterruptedException {
        UUID uuid = UUID.randomUUID();
        System.out.println("+---------------------------------------------------+");
        System.out.println("|          \"L\" - Pre zobrazenie listu               |");
        System.out.println("|          \"S\" - Pre vyhľadávanie v zozname         |");
        System.out.println("|          \"A\" - Pre pridávanie prvkov do zoznamu   |");
        System.out.println("|          \"E\" - Pre menenie hodnôť zoznamu         |");
        System.out.println("|          \"D\" - Pre vymazanie zo zoznamu           |");
        System.out.println("|          \"Q\" - Pre vypnutie programu              |");
        System.out.println("+---------------------------------------------------+");
        System.out.println();
        System.out.println();
        Scanner vstup = new Scanner(System.in);
        String x = vstup.nextLine();

        int i = 0;
        nameList.put(i, "Jozef " + "Bukvička"); i++;
        nameList.put(i, "Jozef " + "Kotvička"); i++;
        nameList.put(i, "Jozef " + "Šošovička"); i++;
        nameList.put(i, "Jozef " + "Mušlička"); i++;
        nameList.put(i, "Jozef " + "Krhlička"); i++;
        nameList.put(i, "Jozef " + "Bukvička"); i++;


        if(x.equals("Q")){
            System.exit(1);
        }
        if(x.equals("L")){
            for (Map.Entry me : nameList.entrySet()) {
                System.out.println("Key: " + me.getKey() + " Value: " + me.getValue());
            }
        }
        if(x.equals("A")){
            System.out.print("Zadajte hodnotu, ktorú chcete pridať: ");
            String pridaj = vstup.nextLine();
            nameList.put(i, pridaj);
            i++;
            System.out.println("Pridané...");
            Thread.sleep(2000);
            for (Map.Entry me : nameList.entrySet()) {
                System.out.println("Key: " + me.getKey() + " Value: " + me.getValue());
            }
        }
        if(x.equals("E")){
            System.out.print("Zadajte číslo hodnoty a hodnotu, ktorú chcete meniť: ");
            int cisloHodnoty = vstup.nextInt();
            String hodnota = vstup.nextLine();
            nameList.replace(cisloHodnoty, hodnota);
            System.out.println("Zmenené...");
            for (Map.Entry me : nameList.entrySet()) {
                System.out.println("Key: " + me.getKey() + " Value: " + me.getValue());
            }
        }
        if(x.equals("D")){
            System.out.print("Zadajte hodnotu, ktorú chete vymazať: ");
            Integer vymaz = vstup.nextInt();
            nameList.remove(vymaz);
            System.out.println("Vymazané...");
            Thread.sleep(2000);
            for (Map.Entry me : nameList.entrySet()) {
                System.out.println("Key: " + me.getKey() + " Value: " + me.getValue());
            }
        }
        if(x.equals("S")){
            System.out.print("Zadajte hodnotu, ktorú chcete vyhľadať: ");
            String hladanie = vstup.nextLine();
            if(nameList.containsValue(hladanie)){
                System.out.println(hladanie + " sa vyskytuje v našom zozname.");
            } else System.out.println(hladanie + " sa nevyskytuje v našom zozname");
        }




    }


}

package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    boolean quit = false;

	    /*
		Naimplementujte pomocou HashMap aplikáciu AdressBook, s podobnými funkciami ako mala aplikácia zo zadania J02
		Naimplementujte pridávanie, odoberanie, vyhľadávanie osoby, vypísanie všetkých záznamov a ukončenie aplikácie príkazom v príkazovom riadku napr. (A)dd, (E)dit, (D)elete, (S)earch, (L)ist, (Q)uit
		Ako jednoznačný identifikátor použite UUID, alebo si vymyslite vlastný systém
		*/

	    HashMap<Osoba, String> hm = new HashMap<Osoba, String>();

		System.out.println("Zadaj prikaz");
	    while(!quit){
	        switch(input.nextLine()){
	        	//add
				case "a":
					System.out.print("Zadaj meno: ");
					String p1 = input.nextLine();
					System.out.print("Zadaj priezvisko: ");
					String p2 = input.nextLine();
					Osoba o = new Osoba(p1, p2);
					hm.put(o, Integer.toString((int)(Math.random()*100000)));
					System.out.println("Hotovo, co ďalej?");
					break;

				//edit
				case "e":
					System.out.println("Zadaj id osoby ktoru chces zmenit: ");
					for(Osoba i : hm.keySet()){
						System.out.print(i.toString());
						System.out.println(", "+hm.get(i));
					}
					String toscan69 = input.nextLine();
					try {
						for (Osoba i : hm.keySet()) {
							if (hm.get(i) == toscan69) ;
							hm.remove(i);
						}
					}catch(Exception e){}
					System.out.print("Zadaj nove meno: ");
					String p4 = input.nextLine();
					System.out.print("Zadaj nove priezvisko: ");
					String p5 = input.nextLine();
					hm.remove(toscan69);
					Osoba o1 = new Osoba(p4, p5);
					hm.put(o1, Integer.toString((int)(Math.random()*100000)));
					System.out.println("Hotovo, co ďalej?");
					break;

				//delete
				case "d":
					System.out.println("Zadaj id osoby ktoru chces zmazat: ");
					for(Osoba i : hm.keySet()){
						System.out.print(i.toString());
						System.out.println(", "+hm.get(i));
					}
					String toscan = input.nextLine();
					try {
						for (Osoba i : hm.keySet()) {
							if (hm.get(i) == toscan) ;
							hm.remove(i);
						}
					}catch(Exception e){/*fakt neviem preco tu vznika exepšn ale funguje to*/}
					System.out.println("Hotovo, co ďalej?");
					break;

				//search
				case "s":
					System.out.print("Zadaj id: ");
					String toscan1 = input.nextLine();
					for(Osoba i : hm.keySet()){
						if(hm.get(i).equals(Integer.parseInt(toscan1))){System.out.println(i.toString()); /*BOHA PRECO TO NEJDE*/}
					}
					System.out.println("Hotovo, co ďalej?");
					break;

				//list
				case "l":
					System.out.println("--- ZOZNAM OSOB --------------------------------------");
					for(Osoba i : hm.keySet()){
						System.out.print(i.toString());
						System.out.println(", "+hm.get(i));
					}
					System.out.println("Hotovo, co ďalej?");break;

	        	//quit
                case "q": System.out.println("konec"); quit = true; break;

                default:
                	System.out.println("Zly prikaz, skus jeden z tychto: ");
                	System.out.println("a - pridaj");
                	System.out.println("e - uprav");
                	System.out.println("d - zmaz");
                	System.out.println("s - vyhladaj");
                	System.out.println("q - ukonci");
                	break;
            }
	    }
    }
}

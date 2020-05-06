package com.company;

import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    static UUID newUUID()
    {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        System.out.println("Random UUID String = "+randomUUIDString);
        System.out.println("UUID version       = "+uuid.version());
        System.out.println("UUID variant       = "+uuid.variant());
        return uuid;
    }

    public static void main(String[] args) {
        HashMap<UUID,Student> students = new HashMap<>();
        Student temp;
        Scanner x = new Scanner(System.in);
        while(true)
        {
            System.out.println("........................");
            System.out.println("1 - vypis Studentov" +"\n"+
                    "2 - novy Student" +"\n"+
                    "3 - prerobit studenta" +"\n"+
                    "4 - vymazat studenta" +"\n"+
                    "5 - vyhladat studenta " +"\n"+
                    "6 - quit");
            int a = x.nextInt();
            switch(a)
            {
                case 1 :{for (UUID p : students.keySet()) System.out.println(students.get(p));break;}
                case 2 :{System.out.println("Napiste meno");
                String meno=x.nextLine();
                System.out.println("Napiste priezvisko");
                String priezvisko=x.nextLine();
                System.out.println("napiste vek");
                int vek =x.nextInt();
                Student s = new Student(vek,meno,priezvisko);
                students.put(newUUID(),s);
                break;
                }
                case 3 :{
                    System.out.println("Napiste meno");
                    String meno=x.nextLine();
                    System.out.println("Napiste priezvisko");
                    String priezvisko=x.nextLine();
                    for (UUID p : students.keySet())
                        if (students.get(p).meno.equals(meno) && students.get(p).priezvisko.equals(priezvisko)){
                            students.remove(p);
                            System.out.println("Napiste nove meno");
                            String nmeno=x.nextLine();
                            System.out.println("Napiste nove priezvisko");
                            String npriezvisko=x.nextLine();
                            System.out.println("Napiste novy vek");
                            int nvek = x.nextInt();
                            temp = new Student(nvek,nmeno,npriezvisko);
                            students.put(newUUID(),temp);
                        }
                    else
                        {
                            System.out.println("Student neexistuje");
                        }
                    break;
                }
                case 4 :{
                    System.out.println("Napiste meno");
                    String meno=x.nextLine();
                    System.out.println("Napiste priezvisko");
                    String priezvisko=x.nextLine();
                    for (UUID p : students.keySet())
                        if (students.get(p).meno.equals(meno) && students.get(p).priezvisko.equals(priezvisko)){
                            students.remove(p);
                        }
                        else
                        {
                            System.out.println("Student neexistuje");
                        }
                        break;
                }
                case 5 :{
                    System.out.println("Napiste meno");
                    String meno=x.nextLine();
                    System.out.println("Napiste priezvisko");
                    String priezvisko=x.nextLine();
                    for (UUID p : students.keySet())
                        if (students.get(p).meno.equals(meno) && students.get(p).priezvisko.equals(priezvisko)){
                            System.out.println(students.get(p));
                        }
                        else
                        {
                            System.out.println("Student neexistuje");
                        }
                        break;
                }
            }
            if(a==6)break;
        }


    }
}

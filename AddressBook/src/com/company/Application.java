package com.company;

import java.util.List;
import java.util.Scanner;

public class Application {

    private Database database;
    private PersonController personController;
    private Scanner scanner;

    public Application(){
        database=new Database();
        personController=new PersonController(database.getTable_people());
        scanner=new Scanner(System.in);
    }

    public void start(){
        loop();
        database.destruct();
        System.out.println("Application terminated");
    }

    private void loop(){
        boolean isEnd = false;
        while(!isEnd){
            System.out.print("Awaiting your command: ");
            String command = scanner.nextLine();
            String[] words = command.split(" ");
            switch (words[0]){
                case "add":
                    if(words.length!=4){
                        System.out.println("Syntax error\nArguments required: 3 (First Name, Last Name, E-mail)\nArguments provided: "+(words.length-1));
                        break;
                    }
                    personController.store(new Person(words[1],words[2],words[3]));
                    break;
                case "update":
                    if(words.length!=5){
                    System.out.println("Syntax error\nArguments required: 4 (ID, First Name, Last Name, E-mail)\nArguments provided: "+(words.length-1));
                    break;
                    }
                    personController.update(Integer.parseInt(words[1]),words[1],words[2],words[3]);
                    break;
                case "delete":
                    if(words.length!=2){
                        System.out.println("Syntax error\nArguments required: 1 (ID)\nArguments provided: "+(words.length-1));
                        break;
                    }
                    personController.delete(Integer.parseInt(words[1]));
                    break;
                case "search":
                    if(words.length!=3){
                        System.out.println("Syntax error\nArguments required: 2 (slug, value)\nArguments provided: "+(words.length-1)+"\nAll availaible slugs: id firstname lastname email");
                        break;
                    }
                    List<Person> found = personController.findByKV(words[1],words[2]);
                    for(Person p:found){
                        String formattedId = p.getId()+"";
                        while(formattedId.length()<4)formattedId="0".concat(formattedId);
                        System.out.println("Person no. "+formattedId+" "+p.getFirst_name()+" "+p.getLast_name()+" "+p.getEmail());
                    }
                    break;
                case "list":
                    List<Person> list = personController.getAll();
                    for(Person p:list){
                        String formattedId = p.getId()+"";
                        while(formattedId.length()<4)formattedId="0".concat(formattedId);
                        System.out.println("Person no. "+formattedId+" "+p.getFirst_name()+" "+p.getLast_name()+" "+p.getEmail());
                    }
                    break;
                case "help":
                    System.out.println("Availaible commands");
                    System.out.println("add arg1 arg2 arg3 (firstname, lastname, email) -> creates new data entry");
                    System.out.println("update arg1 arg2 arg3 arg4 (id, firstname, lastname, email) -> updates existing data entry by id");
                    System.out.println("delete arg1 (id) -> deletes data entry by id");
                    System.out.println("search arg1 arg2 (slug, value) -> searches for all data entries by given slug");
                    System.out.println("list -> list all data entries");
                    System.out.println("help -> lists all availaible commands");
                    System.out.println("quit -> terminates application");
                    break;
                case "quit":
                    isEnd=true;
                    break;
                default:
                    System.out.println("Unknown command\nPlease type \"help\" to list all availaible commands");
                    break;
            }
        }
    }

}


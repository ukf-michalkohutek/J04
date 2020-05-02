package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Database {

    private Map<Integer, Person> table_people = new HashMap<>();

    public Database(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("database.txt")));
            String line=br.readLine();
            line=br.readLine();
            while(line!=null&&line!=""){
                String[] array=line.split(";");
                table_people.put(Integer.parseInt(array[0]), new Person(Integer.parseInt(array[0]),array[1],array[2],array[3]));
                line=br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<Integer, Person> getTable_people(){
        return table_people;
    }

    public void destruct(){
        try {
            BufferedWriter br = new BufferedWriter(new FileWriter(new File("database.txt")));
            br.write(Person.getId_giver()+"\n");
            for(Person p: table_people.values()) br.write(p.getId()+";"+p.getFirst_name()+";"+p.getLast_name()+";"+p.getEmail()+"\n");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

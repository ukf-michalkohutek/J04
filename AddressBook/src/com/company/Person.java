package com.company;

import java.io.*;

public class Person {

    private static int id_giver = 0;
    static{
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("database.txt")));
            id_giver=Integer.parseInt(br.readLine());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int id;
    private String first_name,last_name,email;

    public Person(int id, String first_name, String last_name, String email){
        this.id=id;this.first_name=first_name;this.last_name=last_name;this.email=email;
    }
    public Person(String first_name, String last_name, String email){
        this(++id_giver,first_name,last_name,email);
    }
    public Person(){
        this("","","");
    }

    public static int getId_giver() {
        return id_giver;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAttributeBySlug(String slug){
        if(slug.equals("firstname")||slug.equals("lastname")) return (slug.equals("firstname")?first_name:last_name);
        return (slug.equals("email")?email:(id+""));
    }

}

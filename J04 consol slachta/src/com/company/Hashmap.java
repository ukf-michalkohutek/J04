package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Hashmap {
    public static HashMap<String, Student> hashmapa = new HashMap<String, Student>();
    public static RandomUUID randomStringUUID = new RandomUUID();
    //String[] finded = new String[50]; //finded uuid which corespond to conditions as name or name and surname or name n sur n email
    public static ArrayList<String> finded = new ArrayList<String>();

    public static void put(Student student){
        hashmapa.put(randomStringUUID.newuid(), student);
    }

    public static Student get(String uuid){
        return hashmapa.get(uuid);
    }

    public static int size(){
        return hashmapa.size();
    }

    public static Collection<Student> values(){
        return hashmapa.values();
    }

    public static void loadstartup() {
        hashmapa.put(randomStringUUID.newuid(), new Student("Janko", "Hrasko","janko.hrasko@student.ukf.sk"));
        hashmapa.put(randomStringUUID.newuid(), new Student("Stefan", "Ruzicka","stefan.ruzicka@student.ukf.sk"));
        hashmapa.put(randomStringUUID.newuid(), new Student("Stefan", "Kelnicka","stef000@student.ukf.sk"));
        hashmapa.put(randomStringUUID.newuid(), new Student("Stefan", "Ruzicka","stef111@student.ukf.sk"));
        hashmapa.put(randomStringUUID.newuid(), new Student("Eugen", "Vesely","eugen.vesely@student.ukf.sk"));
    }

    public static int find(String input) {
        finded.clear();
        for (Map.Entry<String, Student> map : hashmapa.entrySet()) {
            if (map.getValue().getFirstName().equals(input) || map.getValue().getLastName().equals(input) || map.getValue().getEmail().equals(input)) {
                finded.add(map.getKey());
            }
        }
        return finded.size();
    }

    public static String oneStudent(int i) {
        Student student = get(finded.get(i));
        return student.getFirstName() + "  " + student.getLastName() + "  " + student.getEmail();
    }

    public static void delete(int i ) {
        hashmapa.remove(finded.get(i));
    }

    public static void editrecord(int i, int c, String newdata) {
        Student student = hashmapa.get(finded.get(i));
        if (c == 0) {
            hashmapa.put(finded.get(i), new Student(newdata, student.getLastName(), student.getEmail()));
        }
        else if (c == 1) {
            hashmapa.put(finded.get(i), new Student(student.getFirstName(), newdata, student.getEmail()));
        }
        else if (c == 2) {
            hashmapa.put(finded.get(i), new Student(student.getFirstName(), student.getLastName(), newdata));
        }
    }



}

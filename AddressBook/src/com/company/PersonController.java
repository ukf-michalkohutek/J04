package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonController {

    private Map<Integer, Person> table;

    public PersonController(Map<Integer, Person> table){
        this.table=table;
    }

    public void store(Person person){
        table.put(person.getId(),person);
    }

    public void update(int id, String fn, String ln, String e){
        Person person = findById(id);
        System.out.println(fn+" "+ln+" "+e);
        if(fn!=null&&!fn.equals("")) person.setFirst_name(fn);
        if(ln!=null&&!ln.equals("")) person.setLast_name(ln);
        if(e!=null&&!e.equals("")) person.setEmail(e);
    }

    public void delete(int id){
        table.remove(id);
    }

    public Person findById(int id){
        return table.get(id);
    }

    public List<Person> findByKV(String key, String value){
        List<Person> ret = new ArrayList<>();
        for(Person p:table.values()) if(p.getAttributeBySlug(key).equals(value)) ret.add(p);
        return ret;
    }

    public List<Person> getAll(){
        return new ArrayList<Person>(table.values());
    }

}

package com.company;

public class Osoba {
    private String meno;
    private String priezvisko;

    public Osoba(String meno, String priezvisko){
        this.meno = meno;
        this.priezvisko = priezvisko;
    }

    public String toString(){
        return meno + " " + priezvisko;
    }
}

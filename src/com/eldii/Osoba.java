package com.eldii;

public class Osoba {

    private String Meno;
    private String Priezvisko;
    private int uuid;

    Osoba (String meno, String priezvisko, int uuid) {
        this.Meno = meno;
        this.Priezvisko = priezvisko;
        this.uuid = uuid;
    }

    public String getMeno() {
        return Meno;
    }

    public String getPriezvisko() {
        return Priezvisko;
    }

    public int getUuid() {
        return uuid;
    }

    public void setMeno(String meno) {
        Meno = meno;
    }

    public void setPriezvisko(String priezvisko) {
        Priezvisko = priezvisko;
    }

    @Override
    public String toString() {
        String ret = "\033[0;96m"+"ID: "+this.uuid+" | Meno: "+Meno+" "+Priezvisko+"\033[0m";
        return ret;
    }
}

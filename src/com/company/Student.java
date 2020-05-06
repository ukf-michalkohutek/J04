package com.company;

public class Student {
    int vek;
    String meno;
    String priezvisko;

    public Student(int vek, String meno, String priezvisko) {
        this.vek = vek;
        this.meno = meno;
        this.priezvisko = priezvisko;
    }

    @Override
    public String toString() {
        return "Student{" +
                "vek=" + vek +
                ", meno='" + meno + '\'' +
                ", priezvisko='" + priezvisko + '\'' +
                '}';
    }
}

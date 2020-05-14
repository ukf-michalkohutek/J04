package sample;

public class statik {
    private String stat, mesto;
    private int id;

    public statik(String stat, String mesto, int id) {
        this.stat = stat;
        this.mesto = mesto;
        this.id = id;}

    public String getMesto() {
        return mesto;}
    public void setMesto(String mesto) {
        this.mesto = mesto;}
    public String getStat() {
        return stat;}
    public void setStat(String stat) {
        this.stat = stat;}
    public int getId() {
        return id;}
    public void setId(int id) {
        this.id = id;}
    @Override
    public String toString() {
        return this.id + ": " + this.stat + " " + this.mesto;}
}

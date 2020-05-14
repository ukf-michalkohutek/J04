package sample;

public class statik {
    private String Meno, priezvisko;
    private int id;

    public statik(String Meno, String priezvisko, int id) {
        this.Meno = Meno;
        this.priezvisko = priezvisko;
        this.id = id;}

    public String getPriezvisko() {
        return priezvisko;}
    public void setpriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;}
    public String getMeno() {
        return Meno;}
    public void setMeno(String Meno) {
        this.Meno = Meno;}
    public int getId() {
        return id;}
    public void setId(int id) {
        this.id = id;}
    @Override
    public String toString() {
        return this.id + ": " + this.Meno + " " + this.priezvisko;}
}

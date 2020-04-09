import java.util.UUID;

public class Osoba extends Main{
    String meno;
    String priezvisko;
    UUID uuid;
    Integer cislo;

    public Osoba(Integer cislo, String meno, String priezvisko){
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.cislo = cislo;
    }


}

import java.util.HashMap;
import java.util.UUID;

public class ListOsob extends Osoba {
    public ListOsob(Integer cislo, String meno, String priezvisko) {
        super(cislo, meno, priezvisko);
    }

    void setMeno(String meno){
        this.meno=meno;
    }

    String getMeno(){
        return meno;
    }

    void setPriezvisko(String priezvisko){
        this.priezvisko=priezvisko;
    }

    String getPriezvisko(){
        return priezvisko;
    }

    Integer getCislo(){
        return cislo;
    }


}

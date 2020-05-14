package sample;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class adresát {
    private HashMap<Integer, statik> ss;

    public adresát() {
        this.ss = new HashMap<>();
    }

    public void vložMenoOsoby(statik s) {
        this.ss.put(s.getId(), s);
    }

    public boolean VymazMenoOsoby(int id) {
        if (maId(id)) {
            this.ss.remove(id);
            return true;
        }
        return false;
    }

    public boolean maId(int id) {
        return this.ss.containsKey(id);
    }

    public statik NajdiMeno(int id) {
        return this.ss.get(id);
    }
}

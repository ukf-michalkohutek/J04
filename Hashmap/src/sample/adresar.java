package sample;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class adresar {
    private HashMap<Integer, statik> sm;

    public adresar() {
        this.sm = new HashMap<>();
    }

    public void pridajStatMesto(statik s) {
        this.sm.put(s.getId(), s);
    }

    public boolean vymazStatMesto(int id) {
        if (maId(id)) {
            this.sm.remove(id);
            return true;
        }
        return false;
    }

    public boolean maId(int id) {
        return this.sm.containsKey(id);
    }

    public statik NajdiStatMesto(int id) {
        return this.sm.get(id);
    }

    public Map<Integer, statik> getPersons() {
        return Collections.unmodifiableMap(sm);
    }
}


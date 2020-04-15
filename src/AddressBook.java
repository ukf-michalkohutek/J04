import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AddressBook {
    private Map<Integer, Person> persons;

    public AddressBook() {
        this.persons = new HashMap<>();
    }

    public void addPerson(Person p) {
//        if(!containsId(p.getId())) {
//            this.persons.put(p.getId(), p);
//            return true;
//        }
//        return false;
        this.persons.put(p.getId(), p);
    }

    public boolean deletePerson(int id) {
        if (containsId(id)) {
            this.persons.remove(id);
            return true;
        }
        return false;
    }

    public boolean containsId(int id) {
        return this.persons.containsKey(id);
    }

    public boolean containsPerson(Person p) {
        return this.persons.containsValue(p);
    }

    public Person findPersonById(int id) {
        return this.persons.get(id);
    }

    public Map<Integer, Person> getPersons() {
        return Collections.unmodifiableMap(persons);
    }
}

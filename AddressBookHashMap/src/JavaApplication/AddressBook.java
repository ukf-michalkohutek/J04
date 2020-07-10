package JavaApplication;

import java.util.HashMap;
import java.util.Map;

public class AddressBook {

    private Map<Integer, Person> persons;

    public AddressBook() {
        this.persons = new HashMap<>();
    }

    public void add(Person person) {
        persons.put(person.getId(), person);
        System.out.println("Pridane!");
    }

    public void deletePerson(int id) {
            this.persons.remove(id);
    }

    public Person findPersonById(int id) {
        return this.persons.get(id);
    }

    public Map<Integer, Person> getPersons() {
        return this.persons;
    }
}

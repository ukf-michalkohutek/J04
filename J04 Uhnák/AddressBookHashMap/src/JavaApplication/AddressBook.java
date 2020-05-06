package JavaApplication;

import java.util.HashMap;
import java.util.UUID;

public class AddressBook extends HashMap<UUID,Person> {

    AddressBook() {
        super();
    }

    public void add(String firstName, String lastName, String email) {
        try {
            put(UUID.randomUUID(), new Person(firstName, lastName, email));
            System.out.println("Successfully added!");
        } catch (Exception e) { System.err.println(e.getMessage()); }
    }

    public void edit(String uuid, String firstName, String lastName, String email) {
        try {
            Person p = get(UUID.fromString(uuid));
            p.setFirstName((firstName.isBlank()) ? p.getFirstName() : firstName);
            p.setLastName((lastName.isBlank()) ? p.getLastName() : lastName);
            p.setEmail((email.isBlank()) ? p.getEmail() : email);
            System.out.println("Successfully edited!");
        } catch (Exception e) { System.err.println(e.getMessage()); }
    }

    public void delete(String uuid) {
        try {
            remove(UUID.fromString(uuid));
            System.out.println("Successfully deleted!");
        } catch (Exception e) { System.err.println(e.getMessage()); }
    }

    public void search(String uuid) {
        try {
            Person p = get(UUID.fromString(uuid));
            System.out.println(p.getFirstName()+ " " + p.getLastName()+ " "+p.getEmail()+" "+uuid);
            System.out.println("Successfully found!");
        } catch (Exception e) { System.err.println(e.getMessage()); }
    }

    public void list() {
        try {
            for (UUID uuid : keySet()) {
                Person p = get(uuid);
                System.out.println(p.toString() + " " + uuid.toString());
            }
            System.out.println("End of list.");
        } catch(Exception e) { System.err.println(e.getMessage()); }
    }
}

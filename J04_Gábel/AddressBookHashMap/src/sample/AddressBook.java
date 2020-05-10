package sample;

import java.util.HashMap;
import java.util.UUID;

public class AddressBook extends HashMap<UUID,Osoba> {

    AddressBook() {
        super();
    }

    public void add(String firstName, String lastName, String email) {
        try {
            put(UUID.randomUUID(), new Osoba(firstName, lastName, email));
            System.out.println("Successfully added!");
        } catch (Exception e) { System.err.println(e.getMessage()); }
    }

    public void edit(String uuid, String firstName, String lastName, String email) {
        try {
            Osoba o = get(UUID.fromString(uuid));
            o.setFirstName((firstName.isBlank()) ? o.getFirstName() : firstName);
            o.setLastName((lastName.isBlank()) ? o.getLastName() : lastName);
            o.setEmail((email.isBlank()) ? o.getEmail() : email);
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
            Osoba o = get(UUID.fromString(uuid));
            System.out.println(o.getFirstName()+ " " + o.getLastName()+ " "+o.getEmail()+" "+uuid);
            System.out.println("Successfully found!");
        } catch (Exception e) { System.err.println(e.getMessage()); }
    }

    public void list() {
        try {
            for (UUID uuid : keySet()) {
                Osoba o = get(uuid);
                System.out.println(o.toString() + " " + uuid.toString());
            }
            System.out.println("End of list.");
        } catch(Exception e) { System.err.println(e.getMessage()); }
    }
}

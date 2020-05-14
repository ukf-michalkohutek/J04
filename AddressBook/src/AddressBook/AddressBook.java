package AddressBook;

import java.util.HashMap;
import java.util.UUID;

class AddressBook extends HashMap<UUID,Student> {

    AddressBook() {

        super();

    }


    public void add(String firstName, String lastName, String email) {
        try {
            put(UUID.randomUUID(), new Student(firstName, lastName, email));
        } catch (Exception e) {
            System.err.println(e.getMessage());

        }
    }

    public void edit(String uuid, String firstName, String lastName, String email) {
        try {
            Student s = get(UUID.fromString(uuid));
            s.setFirstName((firstName.isBlank()) ? s.getFirstName() : firstName);
            s.setLastName((lastName.isBlank()) ? s.getLastName() : lastName);
            s.setEmail((email.isBlank()) ? s.getEmail() : email);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void delete(String uuid) {
        try {
            remove(UUID.fromString(uuid));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void search(String uuid) {
        try {
            Student s = get(UUID.fromString(uuid));
            System.out.println(s.getFirstName()+ " " + s.getLastName()+ " "+s.getEmail()+" "+uuid);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void list() {
        try {
            for (UUID uuid : keySet()) {
                Student s = get(uuid);
                System.out.println(s.toString() + " " + uuid.toString());
            }
        } catch(Exception e) {
           System.err.println(e.getMessage());
        }
    }
}
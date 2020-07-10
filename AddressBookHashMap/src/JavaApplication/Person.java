package JavaApplication;

public class Person {

    private String firstName = "";
    private String lastName = "";
    private String email = "";
    private int id;

    public Person(String firstName, String lastName, String email, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.id = id;
    }

    public String toString() {
        return firstName+" "+lastName+" "+email;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public int getId() { return id; }
}


public class Person {

    private String firstName;
    private String lastName;
    private String email;

    public Person(String _firstName, String _lastName, String _email)
    {
        firstName = _firstName;
        lastName =_lastName;
        email = _email;
    }

    public void setFirstName(String value)
    {
        firstName = value;
    }

    public void setLastName(String value)
    {
        lastName = value;
    }

    public void setEmail(String value)
    {
        email = value;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getEmail()
    {
        return email;
    }

}

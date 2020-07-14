package com.company;

public class Student {
    private String firstName = "";
    private String lastName = "";
    private String email = "";

    public Student() {
        this("", "", "");
    }

    public Student(String firstName, String lastName, String email) {
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fName) {
        firstName = fName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String fName) {
        lastName = fName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String fName) {
        email = fName;
    }
}

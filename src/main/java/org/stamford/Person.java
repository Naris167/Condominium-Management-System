package org.stamford;

import java.time.LocalDate;

public class Person {
    private String name;
    private String surname;
    private LocalDate birthDate;

    // Final fields must be initialized in constructor
    // Default constructor
    public Person() {
        this.name = "";
        this.surname = "";
        this.birthDate = LocalDate.of(1900, 1, 1);
    }

    // Second constructor is overloaded
    // Constructors must not have a return type
    public Person(String name, String surname, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    // Accessors
    public String getName () {
        return name;
    }
    public LocalDate getBirthDate () {
        return birthDate;
    }
    // Mutators:
    public void setName (String name) {
       this.name = name;
    }

    public void setBirthDate (LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

}

package com.carcompany.carreservationservice.structure.personservice.structure;

public class NaturalPerson extends Person {
    private String firstname;
    private String lastname;

    public NaturalPerson(String firstname, String lastname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname() {
        return this.lastname;
    }
}
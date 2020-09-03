package com.carcompany.carreservationservice.structure.personservice.structure;

public class NaturalPersonFactory extends PersonFactory {
    public Person create(String... parameters) {
        return new NaturalPerson(parameters[0], parameters[1]);
    }
}
package com.carcompany.carreservationservice.structure.personservice.structure;

public class Person {
    private static int instanceCount = 0;

    private int id;

    public Person() {
        this.id = instanceCount++;
    }

    public int getId() {
        return this.id;
    }
}
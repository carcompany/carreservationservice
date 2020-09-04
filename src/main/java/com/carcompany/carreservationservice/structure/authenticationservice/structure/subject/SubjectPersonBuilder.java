package com.carcompany.carreservationservice.structure.authenticationservice.structure.subject;

import com.carcompany.carreservationservice.structure.authenticationservice.structure.Role;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.Credential;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;

public class SubjectPersonBuilder implements SubjectBuilder {

    private PersonSubject personSubject;

    public SubjectPersonBuilder() {
        this.personSubject = new PersonSubject();
    }

    @Override
    public void setPerson(Person person) {
        this.personSubject.setPerson(person);
    }

    @Override
    public void addCredential(Credential credential) {
        this.personSubject.addCredential(credential);
    }

    @Override
    public void addRole(Role role) {
        this.personSubject.addRole(role);
    }

    public Subject getSubject() {
        return this.personSubject;
    }

}

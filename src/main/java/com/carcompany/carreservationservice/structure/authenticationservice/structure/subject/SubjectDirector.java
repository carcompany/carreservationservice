package com.carcompany.carreservationservice.structure.authenticationservice.structure.subject;

import com.carcompany.carreservationservice.structure.authenticationservice.structure.Role;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.Credential;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;

public class SubjectDirector {
    private SubjectBuilder subjectBuilder;

    public void setSubjectBuilder(SubjectBuilder subjectBuilder) {
        this.subjectBuilder = subjectBuilder;
    }

    public Subject build(Person person, Credential credential, Role role) {
        this.subjectBuilder.setPerson(person);
        this.subjectBuilder.addCredential(credential);
        this.subjectBuilder.addRole(role);

        return this.subjectBuilder.getSubject();
    }
}

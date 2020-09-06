package com.carcompany.carreservationservice.structure.authenticationservice.structure.subject;

import com.carcompany.carreservationservice.structure.authenticationservice.structure.Role;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.Credential;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;

public interface SubjectBuilder {
    public void setPerson(Person person);

    public void addCredential(Credential credential);

    public void addRole(Role role);

    public Subject getSubject();
}

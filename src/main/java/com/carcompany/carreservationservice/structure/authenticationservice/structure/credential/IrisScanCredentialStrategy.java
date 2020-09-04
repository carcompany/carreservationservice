package com.carcompany.carreservationservice.structure.authenticationservice.structure.credential;

import java.util.Optional;

import com.carcompany.carreservationservice.structure.authenticationservice.structure.subject.Subject;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:43
 */
public class IrisScanCredentialStrategy implements CredentialStrategy {

    /**
     * 
     * @param subject
     * @param credential
     */
    public boolean authenticate(Subject subject, Credential credential) {
        Optional<Credential> matchingCredential = subject.getCredentials().stream().filter((subjectCredential) -> {
            return subjectCredential instanceof IrisScanCredential;
        }).filter((subjectCredential) -> {
            return subjectCredential.equals(credential);
        }).findFirst();

        return !matchingCredential.isEmpty();
    };

}
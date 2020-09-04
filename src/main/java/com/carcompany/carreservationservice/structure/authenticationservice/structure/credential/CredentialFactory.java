package com.carcompany.carreservationservice.structure.authenticationservice.structure.credential;

public interface CredentialFactory {
    public Credential create(Object secret);
}

package com.carcompany.carreservationservice.structure.authenticationservice.structure.credential;

public class PasswordCredentialFactory implements CredentialFactory {

    @Override
    public Credential create(Object secret) {
        PasswordCredential credential = new PasswordCredential();
        credential.setPassword(secret.toString());

        return credential;
    }

}

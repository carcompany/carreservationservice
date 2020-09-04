package com.carcompany.carreservationservice.structure.authenticationservice.structure.credential;

public class FingerprintCredentialFactory implements CredentialFactory {

    @Override
    public Credential create(Object secret) {
        FingerprintCredential credential = new FingerprintCredential();
        credential.setBiometricHash(secret.toString());

        return credential;
    }

}

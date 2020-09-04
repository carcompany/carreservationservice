package com.carcompany.carreservationservice.structure.authenticationservice.structure.credential;

public class IrisScanCredentialFactory implements CredentialFactory {

    @Override
    public Credential create(Object secret) {
        IrisScanCredential credential = new IrisScanCredential();
        credential.setEyeSignature(Integer.valueOf(secret.toString()));

        return credential;
    }

}

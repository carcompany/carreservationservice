package com.carcompany.carresverationservice.structure;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.carcompany.carreservationservice.structure.authenticationservice.behaviour.AuthenticationService;
import com.carcompany.carreservationservice.structure.authenticationservice.behaviour.AuthenticationServiceImplementation;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.Role;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.CredentialEnumeration;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.FingerprintCredential;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.IrisScanCredential;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.PasswordCredential;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.subject.Subject;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class AuthenticationServiceTest {

    private static AuthenticationService authenticationService;
    private static Person person;
    private static PasswordCredential passwordCredential;
    private static PasswordCredential invalidPasswordCredential;
    private static IrisScanCredential irisScanCredential;
    private static IrisScanCredential invalidIrisScanCredential;
    private static FingerprintCredential fingerprintCredential;
    private static FingerprintCredential invalidFingerprintCredential;

    @BeforeAll
    static void setUpBeforClass() {
        authenticationService = AuthenticationServiceImplementation.getInstance();

        person = new Person();

        passwordCredential = new PasswordCredential();
        passwordCredential.setPassword("super-secure-password");

        invalidPasswordCredential = new PasswordCredential();
        invalidPasswordCredential.setPassword("invalid-password");

        irisScanCredential = new IrisScanCredential();
        irisScanCredential.setEyeSignature(27);

        invalidIrisScanCredential = new IrisScanCredential();
        invalidIrisScanCredential.setEyeSignature(1337);

        fingerprintCredential = new FingerprintCredential();
        fingerprintCredential.setBiometricHash("valid-hash");

        invalidFingerprintCredential = new FingerprintCredential();
        invalidFingerprintCredential.setBiometricHash("invalid-hash");
    }

    @AfterAll
    static void tearDownAfterClass() {
        authenticationService = null;
        person = null;

        passwordCredential = null;
        invalidPasswordCredential = null;

        irisScanCredential = null;
        invalidIrisScanCredential = null;

        fingerprintCredential = null;
        invalidFingerprintCredential = null;
    }

    @Test
    @Order(1)
    public void canCreateCredential() {
        assertNotNull(authenticationService.createCredential(CredentialEnumeration.PASSWORD,
                "test") instanceof PasswordCredential);

        assertNotNull(authenticationService.createCredential(CredentialEnumeration.IRIS_SCAN,
                27) instanceof IrisScanCredential);

        assertNotNull(authenticationService.createCredential(CredentialEnumeration.FINGERPRINT,
                "fingerprinthashgoeshere") instanceof FingerprintCredential);
    }

    @Test
    @Order(2)
    public void canCreateSubject() {
        assertNotNull(authenticationService.createSubject(person, passwordCredential, Role.CUSTOMER));
        assertNotNull(authenticationService.createSubject(person, irisScanCredential, Role.CUSTOMER));
        assertNotNull(authenticationService.createSubject(person, fingerprintCredential, Role.CUSTOMER));
    }

    @Test
    @Order(3)
    public void canAuthenticateSubject() {
        Subject subjectA = authenticationService.createSubject(person, passwordCredential, Role.CUSTOMER);
        Subject subjectB = authenticationService.createSubject(person, irisScanCredential, Role.CUSTOMER);
        Subject subjectC = authenticationService.createSubject(person, fingerprintCredential, Role.CUSTOMER);

        assertTrue(authenticationService.authenticateSubject(subjectA.getId(), passwordCredential, Role.CUSTOMER));
        assertFalse(
                authenticationService.authenticateSubject(subjectA.getId(), invalidPasswordCredential, Role.CUSTOMER));

        assertTrue(authenticationService.authenticateSubject(subjectB.getId(), irisScanCredential, Role.CUSTOMER));
        assertFalse(
                authenticationService.authenticateSubject(subjectB.getId(), invalidIrisScanCredential, Role.CUSTOMER));

        assertTrue(authenticationService.authenticateSubject(subjectC.getId(), fingerprintCredential, Role.CUSTOMER));
        assertFalse(authenticationService.authenticateSubject(subjectC.getId(), invalidFingerprintCredential,
                Role.CUSTOMER));

    }
}

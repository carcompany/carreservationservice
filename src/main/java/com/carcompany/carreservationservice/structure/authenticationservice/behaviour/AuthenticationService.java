package com.carcompany.carreservationservice.structure.authenticationservice.behaviour;

import com.carcompany.carreservationservice.structure.authenticationservice.structure.Role;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.Credential;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.CredentialEnumeration;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.subject.Subject;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;

/**
 * @author Leo
 * @version 1.0
 * @created 28-Aug-2020 17:10:35
 */
public abstract class AuthenticationService {

	private static AuthenticationService instance;

	public static AuthenticationService getInstance() {
		if (instance == null) {
			instance = new AuthenticationServiceImplementation();
		}

		return instance;
	};

	/**
	 * 
	 * @param subject
	 * @param credential
	 * @param role
	 */
	public abstract boolean authenticateSubject(int subjectId, Credential credential, Role role);

	public abstract Subject createSubject(Person person, Credential credential, Role role);

	public abstract Credential createCredential(CredentialEnumeration credentialEnumeration, Object secret);
}
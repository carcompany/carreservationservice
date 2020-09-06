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
public interface AuthenticationService {

	/**
	 * 
	 * @param subject
	 * @param credential
	 * @param role
	 */
	public boolean authenticateSubject(int subjectId, Credential credential, Role role);

	public Subject createSubject(Person person, Credential credential, Role role);

	public Credential createCredential(CredentialEnumeration credentialEnumeration, Object secret);
}
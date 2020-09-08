package com.carcompany.carreservationservice.structure.authenticationservice.behaviour;

import java.util.ArrayList;

import com.carcompany.carreservationservice.structure.authenticationservice.structure.Role;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.Credential;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.CredentialEnumeration;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.CredentialFactory;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.CredentialStrategy;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.FingerprintCredential;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.FingerprintCredentialFactory;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.FingerprintCredentialStrategy;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.IrisScanCredential;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.IrisScanCredentialFactory;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.IrisScanCredentialStrategy;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.PasswordCredential;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.PasswordCredentialFactory;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.PasswordCredentialStrategy;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.subject.Subject;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.subject.SubjectDirector;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.subject.SubjectPersonBuilder;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;

/**
 * @author Leo
 * @version 1.0
 * @created 28-Aug-2020 17:10:35
 */
public class AuthenticationServiceImplementation extends AuthenticationService {

	private ArrayList<Subject> subjects;

	public AuthenticationServiceImplementation() {
		this.subjects = new ArrayList<>();
	}

	/**
	 * 
	 * @param subject
	 * @param credential
	 * @param role
	 */
	public boolean authenticateSubject(int subjectId, Credential credential, Role role) {

		Subject subject = subjects.get(subjectId);

		if (subject.hasRole(role)) {
			CredentialStrategy credentialStrategy = null;

			if (credential instanceof IrisScanCredential)
				credentialStrategy = new IrisScanCredentialStrategy();
			else if (credential instanceof PasswordCredential)
				credentialStrategy = new PasswordCredentialStrategy();
			else if (credential instanceof FingerprintCredential)
				credentialStrategy = new FingerprintCredentialStrategy();

			return credentialStrategy.authenticate(subject, credential);
		}

		return false;
	}

	@Override
	public Subject createSubject(Person person, Credential credential, Role role) {
		SubjectDirector subjectDirector = new SubjectDirector();

		// TODO: Select different builders once we have more than one
		subjectDirector.setSubjectBuilder(new SubjectPersonBuilder());

		Subject subject = subjectDirector.build(person, credential, role);
		subjects.add(subject);

		return subject;
	}

	@Override
	public Credential createCredential(CredentialEnumeration credentialEnumeration, Object secret) {
		CredentialFactory credentialFactory = null;

		switch (credentialEnumeration) {
			case FINGERPRINT:
				credentialFactory = new FingerprintCredentialFactory();
				break;
			case IRIS_SCAN:
				credentialFactory = new IrisScanCredentialFactory();
				break;
			case PASSWORD:
				credentialFactory = new PasswordCredentialFactory();
				break;
		}

		return credentialFactory.create(secret);
	}
}
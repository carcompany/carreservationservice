package com.carcompany.carreservationservice.structure.authenticationservice.structure.credential;

import com.carcompany.carreservationservice.structure.authenticationservice.structure.subject.Subject;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:43
 */
public interface CredentialStrategy {

	/**
	 * 
	 * @param subject
	 * @param credential
	 */
	public boolean authenticate(Subject subject, Credential credential);

}
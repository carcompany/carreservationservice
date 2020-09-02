package com.carcompany.carreservationservice.structure.authenticationservice.structure;

import javax.security.auth.login.CredentialException;

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
	public void authenticate(Subject subject, CredentialException credential);

}
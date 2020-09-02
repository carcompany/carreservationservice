package com.carcompany.carreservationservice.structure.authenticationservice.behaviour;

import com.carcompany.carreservationservice.structure.authenticationservice.structure.Credential;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.CredentialStrategy;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.Role;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.Subject;

/**
 * @author Leo
 * @version 1.0
 * @created 28-Aug-2020 17:10:35
 */
public class AuthenticationServiceImplementation implements AuthenticationService {

	public Subject m_Subject;
	public CredentialStrategy m_CredentialStrategy;

	public AuthenticationServiceImplementation(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param subject
	 * @param credential
	 * @param role
	 */
	public boolean authenticateSubject(Subject subject, Credential credential, Role role){
		return false;
	}
}//end AuthenticationServiceImplementation
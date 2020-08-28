package com.carcompany.carreservationservice.structure.Authentication.behaviour;

import com.carcompany.carreservationservice.structure.Authentication.structure.Credential;
import com.carcompany.carreservationservice.structure.Authentication.structure.Role;
import com.carcompany.carreservationservice.structure.Authentication.structure.Subject;

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
	public boolean authenticateSubject(Subject subject, Credential credential, Role role);

}
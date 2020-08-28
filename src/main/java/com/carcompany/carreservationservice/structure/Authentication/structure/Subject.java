package com.carcompany.carreservationservice.structure.Authentication.structure;


/**
 * @author Leo
 * @version 1.0
 * @created 28-Aug-2020 17:10:55
 */
public abstract class Subject {

	private Credential[] credentials;
	private Role[] roles;
	private int id;
	public Credential m_Credential;
	public Role m_Role;

	public Subject(){

	}

	public void finalize() throws Throwable {

	}
}//end Subject
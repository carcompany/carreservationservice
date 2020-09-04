package com.carcompany.carreservationservice.structure.authenticationservice.structure.subject;

import java.util.ArrayList;

import com.carcompany.carreservationservice.structure.authenticationservice.structure.Role;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.Credential;

/**
 * @author Leo
 * @version 1.0
 * @created 28-Aug-2020 17:10:55
 */
public abstract class Subject {

	private static int instanceCount = 0;

	private ArrayList<Role> roles;
	private ArrayList<Credential> credentials;
	private int id;

	public Subject() {
		this.roles = new ArrayList<>();
		this.credentials = new ArrayList<>();
		this.id = instanceCount++;
	}

	public int getId() {
		return this.id;
	}

	public Boolean hasRole(Role role) {
		return roles.contains(role);
	}

	public void addRole(Role role) {
		roles.add(role);
	}

	public void removeRole(Role role) {
		roles.remove(role);
	}

	public void addCredential(Credential credential) {
		credentials.add(credential);
	}

	public ArrayList<Credential> getCredentials() {
		return credentials;
	}
}
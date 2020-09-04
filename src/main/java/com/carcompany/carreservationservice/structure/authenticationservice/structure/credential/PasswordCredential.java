package com.carcompany.carreservationservice.structure.authenticationservice.structure.credential;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:49
 */
public class PasswordCredential implements Credential {

	private String password;

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}

	/**
	 * 
	 * @param credential
	 */
	public boolean equals(Credential credential) {
		return ((PasswordCredential) credential).getPassword().equals(getPassword());
	}
}// end PasswordCredential
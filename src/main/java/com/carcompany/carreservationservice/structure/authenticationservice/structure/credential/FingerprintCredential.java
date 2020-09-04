package com.carcompany.carreservationservice.structure.authenticationservice.structure.credential;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:46
 */
public class FingerprintCredential implements Credential {

	private String biometricHash;

	public void setBiometricHash(String biometricHash) {
		this.biometricHash = biometricHash;
	}

	public String getBiometricHash() {
		return this.biometricHash;
	}

	/**
	 * 
	 * @param credential
	 */
	public boolean equals(Credential credential) {
		return ((FingerprintCredential) credential).getBiometricHash().equals(this.getBiometricHash());
	}
}
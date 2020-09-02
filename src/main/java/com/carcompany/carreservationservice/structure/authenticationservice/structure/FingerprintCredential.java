package com.carcompany.carreservationservice.structure.authenticationservice.structure;


/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:46
 */
public class FingerprintCredential implements Credential {

	public FingerprintCredential(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param credential
	 */
	public boolean equals(Credential credential){
		return false;
	}
}//end FingerprintCredential
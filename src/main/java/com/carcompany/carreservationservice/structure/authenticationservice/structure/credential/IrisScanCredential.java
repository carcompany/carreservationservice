package com.carcompany.carreservationservice.structure.authenticationservice.structure.credential;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:48
 */
public class IrisScanCredential implements Credential {

	private Integer eyeSignature;

	public Integer getEyeSignature() {
		return this.eyeSignature;
	}

	public void setEyeSignature(Integer eyeSignature) {
		this.eyeSignature = eyeSignature;
	}

	public boolean equals(Credential credential) {
		return ((IrisScanCredential) credential).getEyeSignature().intValue() == this.getEyeSignature().intValue();
	}
}
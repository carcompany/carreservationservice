package com.carcompany.carreservationservice.structure.bookingservice.structure;

import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:35
 */
public class Body {

	private Resource resource;

	public void setResource(Resource resource) {	
		this.resource = resource;
	}

	public Resource getResource() {
		return resource;
	}
}
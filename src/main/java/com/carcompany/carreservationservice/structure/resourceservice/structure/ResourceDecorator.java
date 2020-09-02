package com.carcompany.carreservationservice.structure.resourceservice.structure;

/**
 * @author Kevin
 * @version 1.1
 * @created 28-Aug-2020 17:10:52
 */
public abstract class ResourceDecorator extends Resource {

	private Resource resource;

	public ResourceDecorator(Resource resource) {
		this.resource = resource;
	}

	public Resource getResource() {
		return this.resource;
	}
}
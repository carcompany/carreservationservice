package com.carcompany.carreservationservice.structure.resourceservice.behaviour;

import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;
import com.carcompany.carreservationservice.structure.resourceservice.structure.ResourceEnumeration;
import com.carcompany.carreservationservice.structure.resourceservice.structure.exception.MoreThanOneDecoratableResourceException;
import com.carcompany.carreservationservice.structure.resourceservice.structure.exception.NoDecoratableResourceException;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:52
 */
public abstract class ResourceService {

	private static ResourceService instance;

	public static ResourceService getInstance() {
		if (instance == null) {
			instance = new ResourceServiceImplementation();
		}

		return instance;
	}

	/**
	 * 
	 * @param resourceEnumeration
	 */
	public abstract Resource getSelectedResource(ResourceEnumeration... resourceEnumeration)
			throws MoreThanOneDecoratableResourceException, NoDecoratableResourceException;

}
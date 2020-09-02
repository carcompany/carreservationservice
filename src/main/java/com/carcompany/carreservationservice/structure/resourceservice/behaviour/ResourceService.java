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
public interface ResourceService {

	/**
	 * 
	 * @param resourceEnumeration
	 */
	public Resource getSelectedResource(ResourceEnumeration... resourceEnumeration) throws MoreThanOneDecoratableResourceException, NoDecoratableResourceException;

}
package com.carcompany.carreservationservice.structure.Resource.behaviour;

import com.carcompany.carreservationservice.structure.Resource.structure.Resource;
import com.carcompany.carreservationservice.structure.Resource.structure.ResourceEnumeration;

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
	public Resource getSelectedResource(ResourceEnumeration... resourceEnumeration);

}
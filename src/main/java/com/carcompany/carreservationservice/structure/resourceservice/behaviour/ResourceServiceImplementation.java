package com.carcompany.carreservationservice.structure.resourceservice.behaviour;

import com.carcompany.carreservationservice.structure.resourceservice.structure.Car;
import com.carcompany.carreservationservice.structure.resourceservice.structure.ChildSeat;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;
import com.carcompany.carreservationservice.structure.resourceservice.structure.ResourceEnumeration;
import com.carcompany.carreservationservice.structure.resourceservice.structure.SetTopBox;
import com.carcompany.carreservationservice.structure.resourceservice.structure.exception.MoreThanOneDecoratableResourceException;
import com.carcompany.carreservationservice.structure.resourceservice.structure.exception.NoDecoratableResourceException;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:52
 */
public class ResourceServiceImplementation extends ResourceService {

	/**
	 * 
	 * @param resourceEnumeration
	 * @throws MoreThanOneDecoratableResourceException
	 */
	public Resource getSelectedResource(ResourceEnumeration... resourceEnumerations)
			throws MoreThanOneDecoratableResourceException, NoDecoratableResourceException {
		Boolean foundDecoratableResource = false;
		Resource resource = null;

		for (ResourceEnumeration resourceEnumeration : resourceEnumerations) {
			if (resourceEnumeration == ResourceEnumeration.CAR) {
				if (foundDecoratableResource == true)
					throw new MoreThanOneDecoratableResourceException();
				else {
					foundDecoratableResource = true;
					resource = new Car();
				}
			}
		}

		if (foundDecoratableResource == false)
			throw new NoDecoratableResourceException();

		for (ResourceEnumeration resourceEnumeration : resourceEnumerations) {
			switch (resourceEnumeration) {
				case CHILD_SEAT:
					resource = new ChildSeat(resource);
					break;
				case SET_TOP_BOX:
					resource = new SetTopBox(resource);
					break;
				default:
					break;
			}
		}

		return resource;
	}
}
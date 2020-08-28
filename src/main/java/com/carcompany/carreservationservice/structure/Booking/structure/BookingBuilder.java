package com.carcompany.carreservationservice.structure.Booking.structure;

import com.carcompany.carreservationservice.structure.Person.structure.Person;
import com.carcompany.carreservationservice.structure.Resource.structure.Resource;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:36
 */
public interface BookingBuilder {

	/**
	 * 
	 * @param person
	 */
	public void setHead(Person person);

	/**
	 * 
	 * @param ressource
	 */
	public void setBody(Resource ressource);

	public void setFooter();

}
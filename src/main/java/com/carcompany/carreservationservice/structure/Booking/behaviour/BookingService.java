package com.carcompany.carreservationservice.structure.Booking.behaviour;

import com.carcompany.carreservationservice.structure.Booking.structure.Booking;
import com.carcompany.carreservationservice.structure.Booking.structure.Language;
import com.carcompany.carreservationservice.structure.Resource.structure.Resource;
import com.carcompany.carreservationservice.structure.Person.structure.Person;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:39
 */
public interface BookingService {

	/**
	 * 
	 * @param person
	 * @param resource
	 * @param language
	 */
	public Booking createBooking(Person person, Resource resource, Language language);

}
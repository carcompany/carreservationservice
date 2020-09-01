package com.carcompany.carreservationservice.structure.Booking.behaviour;

import com.carcompany.carreservationservice.structure.Booking.structure.Booking;
import com.carcompany.carreservationservice.structure.Person.structure.Person;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;
import com.carcompany.carreservationservice.structure.Booking.structure.BookingDirector;
import com.carcompany.carreservationservice.structure.Booking.structure.Language;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:39
 */
public class BookingServiceImplementation implements BookingService {

	public BookingDirector m_BookingDirector;

	public BookingServiceImplementation(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param person
	 * @param resource
	 * @param language
	 */
	public Booking createBooking(Person person, Resource resource, Language language){
		return null;
	}
}//end BookingServiceImplementation
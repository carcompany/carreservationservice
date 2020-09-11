package com.carcompany.carreservationservice.structure.bookingservice.behaviour;

import java.util.Map;

import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Language;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:39
 */
public abstract class BookingService {

	private static BookingService bookingService;

	public static BookingService getInstance() {
		if (bookingService == null)
			bookingService = new BookingServiceImplementation();
		return bookingService;
	}

	/**
	 * 
	 * @param person
	 * @param resource
	 * @param language
	 */
	public abstract Booking createBooking(Person person, Resource resource, Language language);

	public abstract Booking getBooking(int id);

	public abstract Map<Integer, Booking> getBookings();
}
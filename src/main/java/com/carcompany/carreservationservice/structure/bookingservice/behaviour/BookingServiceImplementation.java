package com.carcompany.carreservationservice.structure.bookingservice.behaviour;

import java.util.HashMap;
import java.util.Map;

import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;
import com.carcompany.carreservationservice.structure.bookingservice.structure.BookingDirector;
import com.carcompany.carreservationservice.structure.bookingservice.structure.EnglishBookingBuilder;
import com.carcompany.carreservationservice.structure.bookingservice.structure.GermanBookingBuilder;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Language;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:39
 */
public class BookingServiceImplementation extends BookingService {

	public BookingDirector bookingDirector;
	public Map<Integer, Booking> bookings;

	public BookingServiceImplementation() {
		this.bookings = new HashMap<>();
	}

	/**
	 * 
	 * @param person
	 * @param resource
	 * @param language
	 */

	public Booking createBooking(Person person, Resource resource, Language language) {

		if (person != null && resource != null) {
			bookingDirector = new BookingDirector();

			switch (language) {
				case ENGLISH:
					bookingDirector.setBookingBuilder(new EnglishBookingBuilder());
					break;
				case GERMAN:
					bookingDirector.setBookingBuilder(new GermanBookingBuilder());
					break;

				default:
					throw new IllegalArgumentException("Unsupported Language: " + language);
			}

			Booking booking = bookingDirector.build(person, resource);

			this.bookings.put(booking.getId(), booking);

			return booking;

		} else {
			if (person == null) {
				throw new IllegalArgumentException("Person is null");
			} else {
				throw new IllegalArgumentException("Resource is null");
			}
		}
	}

	public Map<Integer, Booking> getBookings() {
		return this.bookings;
	}

	@Override
	public Booking getBooking(int id) {
		return this.bookings.get(id);
	}

}
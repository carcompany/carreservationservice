package com.carcompany.carreservationservice.structure.Booking.behaviour;

import com.carcompany.carreservationservice.structure.Booking.structure.Booking;
import com.carcompany.carreservationservice.structure.Booking.structure.BookingDirector;
import com.carcompany.carreservationservice.structure.Booking.structure.EnglishBookingBuilder;
import com.carcompany.carreservationservice.structure.Booking.structure.GermanBookingBuilder;
import com.carcompany.carreservationservice.structure.Booking.structure.Language;
import com.carcompany.carreservationservice.structure.Person.structure.Person;
import com.carcompany.carreservationservice.structure.Resource.structure.Resource;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:39
 */
public class BookingServiceImplementation implements BookingService {

	public BookingDirector bookingDirector;

	public BookingServiceImplementation() {

	}

	public void finalize() throws Throwable {

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

			return bookingDirector.build(person, resource);
			
		} else {
			if (person == null) {
				throw new IllegalArgumentException("Person is null");
			} else {
				throw new IllegalArgumentException("Resource is null");
			}
		}
	}
}// end BookingServiceImplementation
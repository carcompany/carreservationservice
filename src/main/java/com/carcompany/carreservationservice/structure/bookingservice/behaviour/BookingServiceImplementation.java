package com.carcompany.carreservationservice.structure.bookingservice.behaviour;

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
public class BookingServiceImplementation implements BookingService {

	private static BookingServiceImplementation bookingServiceImplementation;

	public BookingDirector bookingDirector;




	private BookingServiceImplementation(){

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

	public BookingServiceImplementation getInstance(){
		if(bookingServiceImplementation == null) bookingServiceImplementation = new BookingServiceImplementation();

		return bookingServiceImplementation;
	}
}




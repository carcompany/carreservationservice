package com.carcompany.carreservationservice.structure.bookingservice.structure;

import com.carcompany.carreservationservice.structure.Resource.structure.Resource;
import com.carcompany.carreservationservice.structure.Person.structure.Person;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:36
 */
public class BookingDirector {

	private BookingBuilder bookingBuilder;

	/**
	 * 
	 * @param bookingBuilder
	 */
	public void setBookingBuilder(BookingBuilder bookingBuilder) {
		this.bookingBuilder = bookingBuilder;
	}

	/**
	 * 
	 * @param person
	 * @param ressource
	 */
	public Booking build(Person person, Resource ressource) {
		bookingBuilder.setHead(person);
		bookingBuilder.setBody(ressource);
		bookingBuilder.setFooter();

		return bookingBuilder.getBooking();
	}
}
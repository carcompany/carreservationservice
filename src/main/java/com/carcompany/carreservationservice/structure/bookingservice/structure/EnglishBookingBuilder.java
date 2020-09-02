package com.carcompany.carreservationservice.structure.bookingservice.structure;

import com.carcompany.carreservationservice.structure.Person.structure.Person;
import com.carcompany.carreservationservice.structure.Resource.structure.Resource;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:45
 */
public class EnglishBookingBuilder implements BookingBuilder {

	public EnglishBooking englishBooking;

	public EnglishBookingBuilder() {
		this.englishBooking = new EnglishBooking();
	}

	/**
	 * 
	 * @param person
	 */
	public void setHead(Person person) {
		this.englishBooking.head = new Head();
		this.englishBooking.head.setPerson(person);
	}

	/**
	 * 
	 * @param resource
	 */
	public void setBody(Resource resource) {
		this.englishBooking.body = new Body();
		this.englishBooking.body.setResource(resource);
	}

	public void setFooter() {
		this.englishBooking.footer = new Footer();
	}

	public Booking getBooking() {
		return this.englishBooking;
	}
}
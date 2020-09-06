package com.carcompany.carreservationservice.structure.bookingservice.structure;

import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:47
 */
public class GermanBookingBuilder implements BookingBuilder {

	private GermanBooking germanBooking;

	public GermanBookingBuilder() {
		this.germanBooking = new GermanBooking();
	}

	/**
	 * 
	 * @param person
	 */
	public void setHead(Person person) {
		this.germanBooking.head = new Head();
		this.germanBooking.head.setPerson(person);
	}

	/**
	 * 
	 * @param resource
	 */
	public void setBody(Resource resource) {
		this.germanBooking.body = new Body();
		this.germanBooking.body.setResource(resource);

	}

	public void setFooter() {
		this.germanBooking.footer = new Footer();
	}

	public Booking getBooking() {
		return this.germanBooking;
	}
}
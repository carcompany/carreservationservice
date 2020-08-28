package com.carcompany.carreservationservice.structure.Booking.structure;

import com.carcompany.carreservationservice.structure.Resource.structure.Resource;
import com.carcompany.carreservationservice.structure.Person.structure.Person;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:36
 */
public class BookingDirector {

	private BookingBuilder bookingBuilder;
	public BookingBuilder m_BookingBuilder;



	public void finalize() throws Throwable {

	}
	public BookingDirector(){

	}

	/**
	 * 
	 * @param bookingBuilder
	 */
	public void setBookingBuilder(BookingBuilder bookingBuilder){

	}

	/**
	 * 
	 * @param person
	 * @param ressource
	 */
	public Booking build(Person person, Resource ressource){
		return null;
	}
}//end BookingDirector
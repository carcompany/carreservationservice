package com.carcompany.carreservationservice.behaviour;

import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Language;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;
import com.carcompany.carreservationservice.structure.resourceservice.structure.ResourceEnumeration;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:40
 */
public class CarReservationServiceImplementation implements CarReservationService {

	
	public CarReservationServiceImplementation() {

	}

	/**
	 * 
	 * @param names
	 */
	public Person createPerson(String... names) {
		return null;
	}

	/**
	 * 
	 * @param personId
	 */
	public void deletePerson(int personId) {

	}

	/**
	 * 
	 * @param resourceEnumeration
	 */
	public Resource createResource(ResourceEnumeration... resourceEnumeration) {
		return null;
	}

	/**
	 * 
	 * @param personId
	 */
	public void authenticatePerson(int personId) {

	}

	public void showStatistics() {

	}

	/**
	 * 
	 * @param bookingId
	 */
	public void payBooking(int bookingId) {

	}

	public void showBookings() {

	}

	/**
	 * 
	 * @param personId
	 * @param resourceId
	 * @param language
	 */
	public Booking createBooking(int personId, int resourceId, Language language) {
		return null;
	}

	@Override
	public Booking createBooking(Person testPerson, Resource testResource, Language language) {
		return null;
	}
}
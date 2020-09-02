package com.carcompany.carreservationservice.behaviour;

import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Language;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.carreservationservice.structure.personservice.structure.exception.PersonCreationFailedException;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;
import com.carcompany.carreservationservice.structure.resourceservice.structure.ResourceEnumeration;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:40
 */
public interface CarReservationService {

	/**
	 * 
	 * @param names
	 */
	public Person createPerson(String... names) throws PersonCreationFailedException;

	/**
	 * 
	 * @param personId
	 */
	public void deletePerson(int personId);

	/**
	 * 
	 * @param resourceEnumeration
	 */
	public Resource createResource(ResourceEnumeration... resourceEnumeration);

	/**
	 * 
	 * @param personId
	 */
	public void authenticatePerson(int personId);

	public void showStatistics();

	/**
	 * 
	 * @param bookingId
	 */
	public void payBooking(int bookingId);

	public void showBookings();

	/**
	 * 
	 * @param testPerson
	 * @param testResource
	 * @param language
	 */
	public Booking createBooking(Person testPerson, com.carcompany.carreservationservice.structure.resourceservice.structure.Resource testResource, Language language);

}
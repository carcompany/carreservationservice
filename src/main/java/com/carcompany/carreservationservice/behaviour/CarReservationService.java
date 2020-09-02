package com.carcompany.carreservationservice.behaviour;

import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Language;
import com.carcompany.carreservationservice.structure.Person.structure.Person;
import com.carcompany.carreservationservice.structure.Person.structure.exception.PersonCreationFailedException;
import com.carcompany.carreservationservice.structure.Resource.structure.Resource;
import com.carcompany.carreservationservice.structure.Resource.structure.ResourceEnumeration;
import com.carcompany.carreservationservice.structure.Resource.structure.exception.ResourceCreationFailedException;

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
	public Resource createResource(ResourceEnumeration... resourceEnumeration) throws ResourceCreationFailedException;

	/**
	 * 
	 * @param resourceId
	 */
	public void showResource(int resourceId);

	/**
	 * 
	 * @param resourceId
	 */
	public void deleteResource(int resourceId);

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
	 * @param personId
	 * @param resourceId
	 * @param language
	 */
	public Booking createBooking(int personId, int resourceId, Language language);

}
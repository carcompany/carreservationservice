package com.carcompany.carreservationservice.behaviour;

import com.carcompany.carreservationservice.structure.Booking.structure.Language;
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
	public void createPerson(String... names);

	/**
	 * 
	 * @param personId
	 */
	public void deletePerson(int personId);

	/**
	 * 
	 * @param resourceEnumeration
	 */
	public void createResource(ResourceEnumeration... resourceEnumeration);

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
	public void createBooking(int personId, int resourceId, Language language);

}
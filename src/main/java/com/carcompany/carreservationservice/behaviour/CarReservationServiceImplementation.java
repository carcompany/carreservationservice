package com.carcompany.carreservationservice.behaviour;

import com.carcompany.carreservationservice.structure.authenticationservice.behaviour.AuthenticationServiceImplementation;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.Role;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.Credential;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Language;
import com.carcompany.carreservationservice.structure.personservice.behaviour.PersonService;
import com.carcompany.carreservationservice.structure.personservice.behaviour.PersonServiceImplementation;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.carreservationservice.structure.resourceservice.behaviour.ResourceService;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;
import com.carcompany.carreservationservice.structure.resourceservice.structure.ResourceEnumeration;
import com.carcompany.carreservationservice.structure.statisticsservice.behaviour.StatisticsService;

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

		return PersonService.getInstance().createPerson(names);
	
	}

	/**
	 * 
	 * @param personId
	 */
	public void deletePerson(int personId) {
		PersonService.getInstance().deletePerson(int personId);

	}

	/**
	 * 
	 * @param resourceEnumeration
	 */
	public Resource createResource(ResourceEnumeration... resourceEnumeration) {
		return ResourceService.getInstance().createResource(resourceEnumeration);
	}

	/**
	 * 
	 * @param personId
	 */
	public void authenticateSubject(int subjectId, Credential credential, Role role) {

		AuthenticationService.getInstance().authenticateSubject(subjectId, credential, role);

	}

	public void showStatistics() {

		StatisticsService.getInstance().showStatistics();

	}

	/**
	 * 
	 * @param bookingId
	 */
	public void payBooking(int bookingId) {

		BookingService.getInstance().payBooking(bookingId);

	}

	public void showBookings() {

		BookingService.getInstance().showBookings();

	}

	/**
	 * 
	 * @param personId
	 * @param resourceId
	 * @param language
	 */
	public Booking createBooking(int personId, int resourceId, Language language) {
		return BookingService.getInstance().createBooking(personId, resourceId, language);
	}

}
package com.carcompany.carreservationservice.behaviour;

import com.carcompany.carreservationservice.structure.Payment.behaviour.PaymentService;
import com.carcompany.carreservationservice.structure.Content.behaviour.ContentService;
import com.carcompany.carreservationservice.structure.Person.behaviour.PersonService;
import com.carcompany.carreservationservice.structure.Booking.behaviour.BookingService;
import com.carcompany.carreservationservice.structure.Booking.structure.Language;
import com.carcompany.carreservationservice.structure.Authentication.behaviour.AuthenticationService;
import com.carcompany.carreservationservice.structure.Statistics.behaviour.StatisticsService;
import com.carcompany.carreservationservice.structure.resourceservice.behaviour.ResourceService;
import com.carcompany.carreservationservice.structure.resourceservice.structure.ResourceEnumeration;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:40
 */
public class CarReservationServiceImplementation implements CarReservationService {

	private PaymentService paymentService;
	private ContentService contentService;
	private ResourceService resourceService;
	private PersonService personService;
	private BookingService bookingService;
	private AuthenticationService authenticationService;
	private StatisticsService statisticsService;
	public StatisticsService m_StatisticsService;
	public AuthenticationService m_AuthenticationService;
	public BookingService m_BookingService;
	public PersonService m_PersonService;
	public ResourceService m_ResourceService;
	public ContentService m_ContentService;
	public PaymentService m_PaymentService;

	public CarReservationServiceImplementation(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param names
	 */
	public void createPerson(String... names){

	}

	/**
	 * 
	 * @param personId
	 */
	public void deletePerson(int personId){

	}

	/**
	 * 
	 * @param resourceEnumeration
	 */
	public void createResource(ResourceEnumeration... resourceEnumeration){

	}

	/**
	 * 
	 * @param resourceId
	 */
	public void showResource(int resourceId){

	}

	/**
	 * 
	 * @param resourceId
	 */
	public void deleteResource(int resourceId){

	}

	/**
	 * 
	 * @param personId
	 */
	public void authenticatePerson(int personId){

	}

	public void showStatistics(){

	}

	/**
	 * 
	 * @param bookingId
	 */
	public void payBooking(int bookingId){

	}

	public void showBookings(){

	}

	/**
	 * 
	 * @param personId
	 * @param resourceId
	 * @param language
	 */
	public void createBooking(int personId, int resourceId, Language language){

	}
}//end CarReservationServiceImplementation
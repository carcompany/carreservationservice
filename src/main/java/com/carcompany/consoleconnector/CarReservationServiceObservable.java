package com.carcompany.consoleconnector;

import com.carcompany.carreservationservice.behaviour.CarReservationService;
import com.carcompany.carreservationservice.structure.Booking.structure.Language;
import com.carcompany.carreservationservice.structure.Resource.structure.ResourceEnumeration;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:40
 */
public class CarReservationServiceObservable extends Observable implements CarReservationService {

	private CarReservationService carReservationService;

	public CarReservationServiceObservable(){

	}

	public void finalize() throws Throwable {
		super.finalize();
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
}//end CarReservationServiceObservable
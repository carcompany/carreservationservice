package com.carcompany.consoleconnector;

import com.carcompany.carreservationservice.behaviour.CarReservationService;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:41
 */
public class CarReservationServiceSingleton {

	private static CarReservationService carReservationService;

	public CarReservationServiceSingleton(){

	}

	public void finalize() throws Throwable {

	}
	public static CarReservationService getSingleton(){
		return null;
	}
}//end CarReservationServiceSingleton
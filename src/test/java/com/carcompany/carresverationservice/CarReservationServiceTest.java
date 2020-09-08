package com.carcompany.carresverationservice;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.carcompany.carreservationservice.behaviour.CarReservationService;
import com.carcompany.carreservationservice.behaviour.CarReservationServiceImplementation;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Language;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class CarReservationServiceTest {

	public static CarReservationService carReservationService;

	public static Person testPerson;
	public static Resource testResource;
	public static Booking testBooking;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		carReservationService = new CarReservationServiceImplementation();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		carReservationService = null;
	}

	@Test
	@Order(1)
	public void canBookingBeCreated() {
		assertDoesNotThrow(() -> carReservationService.createBooking(testPerson, testResource, Language.GERMAN));
	}

	@Test
	@Order(2)
	public void canBookingsBeShown() {
		assertDoesNotThrow(() -> carReservationService.showBookings());
	}

	
}

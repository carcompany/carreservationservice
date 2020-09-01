package com.carcompany.carresverationservice;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.carcompany.carreservationservice.behaviour.CarReservationService;
import com.carcompany.carreservationservice.behaviour.CarReservationServiceImplementation;
import com.carcompany.carreservationservice.structure.Booking.structure.Language;
import com.carcompany.carreservationservice.structure.Resource.structure.ResourceEnumeration;

public class CarReservationServiceTest {

	public static CarReservationService carReservationService;

	public static int testPersonId;
	public static int testResourceId;
	public static int testBookingId;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		carReservationService = new CarReservationServiceImplementation();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	@Order(1)
	public void canPersonBeCreated() {

		assertDoesNotThrow(() -> testPersonId = carReservationService.createPerson("test", "name"));

	}

	@Test
	@Order(2)
	public void canResourceBeCreated() {

		assertDoesNotThrow(() -> testResourceId = carReservationService.createResource(ResourceEnumeration.CHILD_SEAT,
				ResourceEnumeration.SET_TOP_BOX));

	}

	@Test
	@Order(3)
	public void canBookingBeCreated() {

		assertDoesNotThrow(() -> carReservationService.createBooking(testPersonId, testResourceId, Language.GERMAN));
	}

	@Test
	@Order(4)
	public void canBookingsBeShown() {
		assertDoesNotThrow(() -> carReservationService.showBookings());
	}

	@Test
	@Order(5)
	public void canResourceBeShown() {
		assertDoesNotThrow(() -> carReservationService.showResource(testResourceId));
	}

	@Test
	@Order(6)
	public void canStatisticsBeShown() {
		assertDoesNotThrow(() -> carReservationService.showStatistics());
	}

	@Test
	@Order(7)
	public void canPersonBeAuthenticated() {
		assertDoesNotThrow(() -> carReservationService.authenticatePerson(testPersonId));
	}

	@Test
	@Order(8)
	public void canBookingBePaid() {
		assertDoesNotThrow(() -> carReservationService.payBooking(testBookingId));
	}

	@Test
	@Order(9)
	public void canPersonBeDeleted() {
		assertDoesNotThrow(() -> carReservationService.deletePerson(testPersonId));
	}

	@Test
	@Order(10)
	public void canResourceBeDeleted() {
		assertDoesNotThrow(() -> carReservationService.deleteResource(testResourceId));
	}

}

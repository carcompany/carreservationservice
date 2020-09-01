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

	public static Person testPerson;
	public static Resource testResource;
	public static Booking testBooking;

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

		assertDoesNotThrow(() -> testPerson = carReservationService.createPerson("test", "name"));

	}

	@Test
	@Order(2)
	public void canResourceBeCreated() {

		assertDoesNotThrow(() -> testResource = carReservationService.createResource(ResourceEnumeration.CHILD_SEAT,
				ResourceEnumeration.SET_TOP_BOX));

	}

	@Test
	@Order(3)
	public void canBookingBeCreated() {

		assertDoesNotThrow(() -> carReservationService.createBooking(testPerson, testResource, Language.GERMAN));
	}

	@Test
	@Order(4)
	public void canBookingsBeShown() {
		assertDoesNotThrow(() -> carReservationService.showBookings());
	}

	@Test
	@Order(5)
	public void canResourceBeShown() {
		assertDoesNotThrow(() -> carReservationService.showResource(testResource));
	}

	@Test
	@Order(6)
	public void canStatisticsBeShown() {
		assertDoesNotThrow(() -> carReservationService.showStatistics());
	}

	@Test
	@Order(7)
	public void canPersonBeAuthenticated() {
		assertDoesNotThrow(() -> carReservationService.authenticatePerson(testPerson));
	}

	@Test
	@Order(8)
	public void canBookingBePaid() {
		assertDoesNotThrow(() -> carReservationService.payBooking(testBooking));
	}

	@Test
	@Order(9)
	public void canPersonBeDeleted() {
		assertDoesNotThrow(() -> carReservationService.deletePerson(testPerson));
	}

	@Test
	@Order(10)
	public void canResourceBeDeleted() {
		assertDoesNotThrow(() -> carReservationService.deleteResource(testResource));
	}

}

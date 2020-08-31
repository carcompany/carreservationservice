package com.carcompany.carresverationservice;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.carcompany.carreservationservice.behaviour.CarReservationService;
import com.carcompany.carreservationservice.behaviour.CarReservationServiceImplementation;

public class CarReservationServiceTest {

	public static CarReservationService carReservationService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		carReservationService = new CarReservationServiceImplementation();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void canPersonBeAuthenticated() {
		assertTrue(true);
	}

	@Test
	public void canBookingBeCreated() {
		assertTrue(true);
	}

	@Test
	public void canPersonBeCreated() {
		assertTrue(true);
	}

	@Test
	public void canResourceBeCreated() {
		assertTrue(true);
	}

	@Test
	public void canPersonBeDeleted() {
		assertTrue(true);
	}

	@Test
	public void canResourceBeDeleted() {
		assertTrue(true);
	}

	@Test
	public void canBookingBePaid() {
		assertTrue(true);
	}

	@Test
	public void canBookingBeShown() {
		assertTrue(true);
	}

	@Test
	public void canResourceBeShown() {
		assertTrue(true);
	}

	@Test
	public void canStatisticsBeShown() {
		assertTrue(true);
	}

}

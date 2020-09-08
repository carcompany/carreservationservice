package com.carcompany.carresverationservice.structure;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.carcompany.carreservationservice.structure.bookingservice.behaviour.BookingService;
import com.carcompany.carreservationservice.structure.bookingservice.behaviour.BookingServiceImplementation;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Language;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Car;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;

class BookingServiceTest {

	public static BookingService bookingService;
	public static Person person;
	public static Resource resource;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		bookingService = BookingService.getInstance();
		person = new Person();
		resource = new Car();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void canBookingBeCreated() {
		assertTrue(bookingService.createBooking(person, resource, Language.ENGLISH) instanceof Booking);
	}

	@Test
	void canBookingBeCreatedWhenPersonIsNull() {
		assertThrows(IllegalArgumentException.class,
				() -> bookingService.createBooking(null, resource, Language.ENGLISH));
	}

	@Test
	void canBookingBeCreatedWhenResourceIsNull() {
		assertThrows(IllegalArgumentException.class,
				() -> bookingService.createBooking(person, null, Language.ENGLISH));
	}

	@Test
	void canBookingBeCreatedWhenBothResourceAndPersonAreNull() {
		assertThrows(IllegalArgumentException.class, () -> bookingService.createBooking(null, null, Language.ENGLISH));
	}

}

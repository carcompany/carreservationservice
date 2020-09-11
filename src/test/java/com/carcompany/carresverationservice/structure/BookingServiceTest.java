package com.carcompany.carresverationservice.structure;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.carcompany.carreservationservice.structure.bookingservice.behaviour.BookingService;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Language;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Car;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

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
		resource = null;
		person = null;
		bookingService = null;
	}

	@Test
	@Order(1)
	void canBookingBeCreated() {
		assertTrue(bookingService.createBooking(person, resource, Language.ENGLISH) instanceof Booking);
	}

	@Test
	@Order(2)
	void canBookingBeCreatedWhenPersonIsNull() {
		assertThrows(IllegalArgumentException.class,
				() -> bookingService.createBooking(null, resource, Language.ENGLISH));
	}

	@Test
	@Order(3)
	void canBookingBeCreatedWhenResourceIsNull() {
		assertThrows(IllegalArgumentException.class,
				() -> bookingService.createBooking(person, null, Language.ENGLISH));
	}

	@Test
	@Order(4)
	void canBookingBeCreatedWhenBothResourceAndPersonAreNull() {
		assertThrows(IllegalArgumentException.class, () -> bookingService.createBooking(null, null, Language.ENGLISH));
	}

	@Test
	@Order(5)
	void canBookingBeObtained() {
		Booking booking = bookingService.createBooking(person, resource, Language.ENGLISH);
		assertNotNull(bookingService.getBooking(booking.getId()));
	}

	@Test
	@Order(6)
	void canBookingsBeObtained() {
		bookingService.createBooking(person, resource, Language.ENGLISH);
		assertNotNull(bookingService.getBookings().size() > 0);
	}

}

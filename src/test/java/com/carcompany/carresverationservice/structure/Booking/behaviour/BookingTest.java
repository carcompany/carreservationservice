package com.carcompany.carresverationservice.structure.Booking.behaviour;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.carcompany.carreservationservice.structure.Booking.behaviour.BookingService;
import com.carcompany.carreservationservice.structure.Booking.behaviour.BookingServiceImplementation;
import com.carcompany.carreservationservice.structure.Booking.structure.Booking;
import com.carcompany.carreservationservice.structure.Booking.structure.EnglishBooking;
import com.carcompany.carreservationservice.structure.Booking.structure.Language;
import com.carcompany.carreservationservice.structure.Person.structure.Person;
import com.carcompany.carreservationservice.structure.Resource.structure.Car;
import com.carcompany.carreservationservice.structure.Resource.structure.Resource;

class BookingTest {
	
	public static BookingService bookingService;
	
	public static Person testPerson;
	public static Resource testResource;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		bookingService = new BookingServiceImplementation();
		
		testPerson = new Person();
		testResource = new Car();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void canBookingBeCreated() {
		assertTrue(bookingService.createBooking(testPerson, testResource, Language.ENGLISH) instanceof Booking);
	}
	
	@Test
	void canBookingBeCreatedWhenPersonIsNull() {
		assertThrows(IllegalArgumentException.class, () -> bookingService.createBooking(null, testResource, Language.ENGLISH));
	}
	@Test
	void canBookingBeCreatedWhenResourceIsNull() {
		assertThrows(IllegalArgumentException.class, () -> bookingService.createBooking(testPerson, null, Language.ENGLISH));
	}
	@Test
	void canBookingBeCreatedWhenBothResourceAndPersonAreNull() {
		assertThrows(IllegalArgumentException.class, () -> bookingService.createBooking(null, null, Language.ENGLISH));
	}
	
}

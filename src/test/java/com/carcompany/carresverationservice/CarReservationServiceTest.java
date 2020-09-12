package com.carcompany.carresverationservice;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.carcompany.carreservationservice.behaviour.CarReservationService;
import com.carcompany.carreservationservice.behaviour.CarReservationServiceImplementation;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.Credential;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.CredentialEnumeration;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Language;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PaymentType;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.Account;
import com.carcompany.carreservationservice.structure.personservice.structure.LegalPerson;
import com.carcompany.carreservationservice.structure.personservice.structure.NaturalPerson;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;
import com.carcompany.carreservationservice.structure.resourceservice.structure.ResourceEnumeration;
import com.carcompany.carreservationservice.structure.resourceservice.structure.exception.MoreThanOneDecoratableResourceException;
import com.carcompany.carreservationservice.structure.resourceservice.structure.exception.NoDecoratableResourceException;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.ExternalPaymentServiceEnumeration;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.ExternalPaymentStatistic;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class CarReservationServiceTest {

	public static CarReservationService carReservationService;

	public static Person person;
	public static Resource resource;
	public static Booking booking;

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
	public void canPersonBeCreated() {
		assertTrue(carReservationService.createPerson("CineCar GmbH") instanceof LegalPerson);
		assertTrue(carReservationService.createPerson("Jane", "Doe") instanceof NaturalPerson);
	}

	@Test
	@Order(2)
	public void canGetNaturalPerson() throws MoreThanOneDecoratableResourceException, NoDecoratableResourceException {
		assertDoesNotThrow(() -> {
			Person person = carReservationService.createPerson("Jane", "Doe");
			assertNotNull(carReservationService.showPerson(person.getId()));
		});
	}

	@Test
	@Order(3)
	public void canResourceBeCreated() throws MoreThanOneDecoratableResourceException, NoDecoratableResourceException {
		assertNotNull(carReservationService.createResource(ResourceEnumeration.CAR, ResourceEnumeration.CHILD_SEAT));
	}

	@Test
	@Order(4)
	public void canBookingBeCreated() throws MoreThanOneDecoratableResourceException, NoDecoratableResourceException {
		person = carReservationService.createPerson("CineCar GmbH");
		resource = carReservationService.createResource(ResourceEnumeration.CAR, ResourceEnumeration.CHILD_SEAT,
				ResourceEnumeration.SET_TOP_BOX);
		assertDoesNotThrow(() -> carReservationService.createBooking(person.getId(), resource, Language.GERMAN));
	}

	@Test
	@Order(5)
	public void canAccountBeCreated() {
		assertDoesNotThrow(() -> {
			Person person = carReservationService.createPerson("CineCar");
			carReservationService.createAccount(person.getId(), CredentialEnumeration.PASSWORD, "test",
					PaymentType.APPLE_PAY);
		});
	}

	@Test
	@Order(5)
	public void canAccountBeShown() {
		assertDoesNotThrow(() -> {
			Person person = carReservationService.createPerson("CineCar");

			assertNotNull(carReservationService.createAccount(person.getId(), CredentialEnumeration.PASSWORD, "test",
					PaymentType.APPLE_PAY));
		});
	}

	@Test
	@Order(7)
	public void canBookingBeObtained() throws MoreThanOneDecoratableResourceException, NoDecoratableResourceException {
		person = carReservationService.createPerson("CineCar GmbH");
		resource = carReservationService.createResource(ResourceEnumeration.CAR, ResourceEnumeration.CHILD_SEAT,
				ResourceEnumeration.SET_TOP_BOX);
		assertDoesNotThrow(() -> {
			Booking booking = carReservationService.createBooking(person.getId(), resource, Language.GERMAN);
			assertNotNull(carReservationService.showBooking(booking.getId()));
		});
	}

	@Test
	@Order(6)
	public void canBookingsBeObtained() throws MoreThanOneDecoratableResourceException, NoDecoratableResourceException {
		person = carReservationService.createPerson("CineCar GmbH");
		resource = carReservationService.createResource(ResourceEnumeration.CAR, ResourceEnumeration.CHILD_SEAT,
				ResourceEnumeration.SET_TOP_BOX);
		assertDoesNotThrow(() -> {
			carReservationService.createBooking(person.getId(), resource, Language.GERMAN);
			assertNotNull(carReservationService.showBookings().size() > 0);
		});
	}

	@Test
	@Order(7)
	public void canCredentialBeCreated() {
		assertNotNull(carReservationService.createCredential(CredentialEnumeration.PASSWORD, "test"));
	}

	@Test
	@Order(8)
	public void canBookingBePaid() throws Exception {
		person = carReservationService.createPerson("CineCar GmbH");
		Credential credential = carReservationService.createCredential(CredentialEnumeration.PASSWORD, "test");
		Account account = carReservationService.createAccount(person.getId(), CredentialEnumeration.PASSWORD, "test",
				PaymentType.BANK);
		resource = carReservationService.createResource(ResourceEnumeration.CAR, ResourceEnumeration.CHILD_SEAT,
				ResourceEnumeration.SET_TOP_BOX);
		Booking booking = carReservationService.createBooking(person.getId(), resource, Language.GERMAN);

		carReservationService.payBooking(booking.getId(), PaymentType.BANK, account.getId(), credential);
	}

	@Test
	@Order(9)
	public void canStatisticsBeObtained() throws Exception {
		person = carReservationService.createPerson("CineCar", "GmbH");
		Credential credential = carReservationService.createCredential(CredentialEnumeration.PASSWORD, "test");
		Account account = carReservationService.createAccount(person.getId(), CredentialEnumeration.PASSWORD, "test",
				PaymentType.BANK);
		resource = carReservationService.createResource(ResourceEnumeration.CAR, ResourceEnumeration.CHILD_SEAT,
				ResourceEnumeration.SET_TOP_BOX);

		booking = carReservationService.createBooking(person.getId(), resource, Language.GERMAN);

		carReservationService.payBooking(booking.getId(), PaymentType.BANK, account.getId(), credential);

		ExternalPaymentStatistic statistic = carReservationService.showStatistics(Language.GERMAN,
				ExternalPaymentServiceEnumeration.BANK);

		assertTrue(statistic.getBookingSum() > 0);
	}

	@Test
	@Order(10)
	public void canPersonBeDeleted() {
		assertDoesNotThrow(() -> {
			Person person = carReservationService.createPerson("CineCar");
			assertDoesNotThrow(() -> carReservationService.deletePerson(person.getId()));
		});
	}

	@Test
	@Order(11)
	public void canPersonBeShown() {
		assertDoesNotThrow(() -> {
			Person person = carReservationService.createPerson("CineCar");
			assertNotNull(carReservationService.showPerson(person.getId()));
		});
	}
}

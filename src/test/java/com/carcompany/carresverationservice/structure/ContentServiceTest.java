package com.carcompany.carresverationservice.structure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.carcompany.carreservationservice.structure.authenticationservice.behaviour.AuthenticationService;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.Role;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.Credential;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.CredentialEnumeration;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.subject.Subject;
import com.carcompany.carreservationservice.structure.bookingservice.behaviour.BookingService;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Language;
import com.carcompany.carreservationservice.structure.contentservice.behaviour.ContentService;
import com.carcompany.carreservationservice.structure.contentservice.structure.ContentType;
import com.carcompany.carreservationservice.structure.contentservice.structure.Report;
import com.carcompany.carreservationservice.structure.paymentservice.behaviour.PaymentService;
import com.carcompany.carreservationservice.structure.paymentservice.domainvalue.CurrencyAmount;
import com.carcompany.carreservationservice.structure.paymentservice.structure.Payment;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PaymentType;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.Account;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.AppleAccount;
import com.carcompany.carreservationservice.structure.personservice.behaviour.PersonService;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.carreservationservice.structure.resourceservice.behaviour.ResourceService;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;
import com.carcompany.carreservationservice.structure.resourceservice.structure.ResourceEnumeration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class ContentServiceTest {

	private static ContentService contentService;
	private static PaymentService paymentService;
	private static BookingService bookingService;
	private static PersonService personService;
	private static ResourceService resourceService;
	private static AuthenticationService authenticationService;

	private static Booking booking;
	private static Payment payment;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		contentService = ContentService.getInstance();
		paymentService = PaymentService.getInstance();
		bookingService = BookingService.getInstance();
		personService = PersonService.getInstance();
		resourceService = ResourceService.getInstance();
		authenticationService = AuthenticationService.getInstance();

		// CREATE BOOKING
		Person personA = personService.createPerson("Hans", "KaufGern");
		Resource resourceA = resourceService.getSelectedResource(ResourceEnumeration.CAR);
		booking = bookingService.createBooking(personA, resourceA, Language.GERMAN);

		// CREATE PAYMENT
		Credential credentialA = authenticationService.createCredential(CredentialEnumeration.PASSWORD, "ABC");
		Subject subjectA = authenticationService.createSubject(personA, credentialA, Role.CUSTOMER);
		Account accountA = new AppleAccount(subjectA);

		Person personB = personService.createPerson("Goerg", "VonVerkauf");
		Credential credentialB = authenticationService.createCredential(CredentialEnumeration.PASSWORD, "CBA");
		Subject subjectB = authenticationService.createSubject(personB, credentialB, Role.CUSTOMER);
		Account accountB = new AppleAccount(subjectB);

		CurrencyAmount currencyAmount = new CurrencyAmount();
		currencyAmount.setAmount(120);

		payment = paymentService.payAmount(accountA, accountB, currencyAmount, PaymentType.APPLE_PAY, credentialA);
		booking.getFooter().setPayment(payment);

	}

	@Test
	@Order(1)
	public void canContentBeAdded() {
		assertTrue(contentService.addContent(booking, ContentType.BOOKING));
	}

	@Test
	@Order(2)
	public void canBookingBeObtained() {
		contentService.addContent(booking, ContentType.BOOKING);
		assertEquals("Booking_" + booking.getId(),
				contentService.getSelectedContent("/09-2020/Booking_" + booking.getId()).getName());
	}

	@Test
	@Order(3)
	public void canPaymentBeObtained() {
		contentService.addContent(payment, ContentType.PAYMENT);
		contentService.addContent(payment, ContentType.PAYMENT);

		assertEquals("Payment_" + payment.getId(),
				contentService.getSelectedContent("/09-2020/Payment_" + payment.getId()).getName());
	}

	@Test
	@Order(4)
	public void canReportBeObtained() {
		Report report = (Report) contentService.getSelectedContent("/09-2020/Report");
		assertTrue(report.getBookingNumbers(PaymentType.APPLE_PAY) > 0);
		assertTrue(report.getPaymentNumbers(PaymentType.APPLE_PAY) > 0);
	}

	@Test
	@Order(5)
	public void canContentBeRemoved() {
		contentService.addContent(booking, ContentType.BOOKING);
		contentService.removeContent("09-2020");
		assertNull(contentService.getSelectedContent("/09-2020/"));
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		contentService = null;
	}
}
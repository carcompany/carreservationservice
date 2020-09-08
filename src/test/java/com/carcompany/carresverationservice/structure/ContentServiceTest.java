package com.carcompany.carresverationservice.structure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.carcompany.carreservationservice.structure.authenticationservice.behaviour.AuthenticationService;
import com.carcompany.carreservationservice.structure.authenticationservice.behaviour.AuthenticationServiceImplementation;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.Role;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.Credential;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.CredentialEnumeration;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.subject.Subject;
import com.carcompany.carreservationservice.structure.bookingservice.behaviour.BookingService;
import com.carcompany.carreservationservice.structure.bookingservice.behaviour.BookingServiceImplementation;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Language;
import com.carcompany.carreservationservice.structure.contentservice.behaviour.ContentService;
import com.carcompany.carreservationservice.structure.contentservice.behaviour.ContentServiceImplementation;
import com.carcompany.carreservationservice.structure.contentservice.structure.ContentType;
import com.carcompany.carreservationservice.structure.paymentservice.behaviour.PaymentService;
import com.carcompany.carreservationservice.structure.paymentservice.behaviour.PaymentServiceImplementation;
import com.carcompany.carreservationservice.structure.paymentservice.domainvalue.CurrencyAmount;
import com.carcompany.carreservationservice.structure.paymentservice.structure.Payment;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PaymentType;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.Account;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.AppleAccount;
import com.carcompany.carreservationservice.structure.personservice.behaviour.PersonService;
import com.carcompany.carreservationservice.structure.personservice.behaviour.PersonServiceImplementation;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.carreservationservice.structure.resourceservice.behaviour.ResourceService;
import com.carcompany.carreservationservice.structure.resourceservice.behaviour.ResourceServiceImplementation;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;
import com.carcompany.carreservationservice.structure.resourceservice.structure.ResourceEnumeration;

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
		contentService = ContentServiceImplementation.getInstance();
		paymentService = new PaymentServiceImplementation();
		bookingService = new BookingServiceImplementation();
		personService = new PersonServiceImplementation();
		resourceService = new ResourceServiceImplementation();
		authenticationService = AuthenticationServiceImplementation.getInstance();

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
		Subject subjectB = authenticationService.createSubject(personB, credentialB, Role.STAFF);
		Account accountB = new AppleAccount(subjectB);
		
		CurrencyAmount currencyAmount = new CurrencyAmount();
		currencyAmount.setAmount(120);
		
		payment = paymentService.payAmount(accountA, accountB, currencyAmount, PaymentType.APPLE_PAY, credentialA);
		
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
		assertEquals("Booking_ID_Placeholder", contentService.getSelectedContent("/09-2020/Booking_ID_Placeholder").getName());
	}
	
	@Test
	@Order(2)	
	public void canPaymentBeObtained() {
		contentService.addContent(payment, ContentType.PAYMENT);
		assertEquals("Payment_"  + payment.getId(), contentService.getSelectedContent("/09-2020/Payment_" + payment.getId()).getName());
	}

	@Test
	@Order(3)
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
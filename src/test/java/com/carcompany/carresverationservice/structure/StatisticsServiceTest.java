package com.carcompany.carresverationservice.structure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

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
import com.carcompany.carreservationservice.structure.statisticsservice.behaviour.StatisticsService;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.ExternalPaymentServiceEnumeration;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.ExternalPaymentStatistic;

@TestMethodOrder(OrderAnnotation.class)
class StatisticsServiceTest {

	private static StatisticsService statisticsService;
	private static PaymentService paymentService;
	private static BookingService bookingService;
	private static PersonService personService;
	private static ResourceService resourceService;
	private static AuthenticationService authenticationService;
	private static ContentService contentService;

	private static Booking bookingWithPayPal;
	private static Booking bookingWithPayPal2;

	private static Booking bookingWithApplePay;
	private static Booking bookingWithApplePay2;

	private static Payment paymentWithPayPal;
	private static Payment paymentWithPayPal2;

	private static Payment paymentWithApplePay;
	private static Payment paymentWithApplePay2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		statisticsService = StatisticsService.getInstance();
		paymentService = PaymentService.getInstance();
		bookingService = BookingService.getInstance();
		personService = PersonService.getInstance();
		resourceService = ResourceService.getInstance();
		authenticationService = AuthenticationService.getInstance();
		contentService = ContentService.getInstance();

		/** ------------------------------------------------ **/

		// CREATE BOOKING (PAYPAL, GERMAN)
		Person personA = personService.createPerson("Hans", "KaufGern");
		Resource resourceA = resourceService.getSelectedResource(ResourceEnumeration.CAR);
		bookingWithPayPal = bookingService.createBooking(personA, resourceA, Language.GERMAN);

		/** ------------------------------------------------ **/

		// CREATE BOOKING2 (PAYPAL, GERMAN)
		Person personA2 = personService.createPerson("Peter", "KaufAuchGern");
		Resource resourceA2 = resourceService.getSelectedResource(ResourceEnumeration.CAR);
		bookingWithPayPal2 = bookingService.createBooking(personA2, resourceA2, Language.GERMAN);

		/** ------------------------------------------------ **/

		// CREATE PAYMENT (PAYPAL, GERMAN)
		Credential credentialA = authenticationService.createCredential(CredentialEnumeration.PASSWORD, "ABC");
		Subject subjectA = authenticationService.createSubject(personA, credentialA, Role.CUSTOMER);
		Account accountA = new AppleAccount(subjectA);

		Person personB = personService.createPerson("Goerg", "VonVerkauf");
		Credential credentialB = authenticationService.createCredential(CredentialEnumeration.PASSWORD, "CBA");
		Subject subjectB = authenticationService.createSubject(personB, credentialB, Role.STAFF);
		Account accountB = new AppleAccount(subjectB);

		CurrencyAmount currencyAmount = new CurrencyAmount();
		currencyAmount.setAmount(120);

		paymentWithPayPal = paymentService.payAmount(accountA, accountB, currencyAmount, PaymentType.PAYPAL,
				credentialA);
		bookingWithPayPal.getFooter().setPayment(paymentWithPayPal);

		/** ------------------------------------------------ **/

		// CREATE PAYMENT2 (PAYPAL, GERMAN)
		Credential credentialA2 = authenticationService.createCredential(CredentialEnumeration.PASSWORD, "ABC");
		Subject subjectA2 = authenticationService.createSubject(personA2, credentialA2, Role.CUSTOMER);
		Account accountA2 = new AppleAccount(subjectA2);

		Person personB2 = personService.createPerson("Juergen", "VonTeuerVerkauf");
		Credential credentialB2 = authenticationService.createCredential(CredentialEnumeration.PASSWORD, "CBA");
		Subject subjectB2 = authenticationService.createSubject(personB2, credentialB2, Role.STAFF);
		Account accountB2 = new AppleAccount(subjectB2);

		CurrencyAmount currencyAmount2 = new CurrencyAmount();
		currencyAmount2.setAmount(120);

		paymentWithPayPal2 = paymentService.payAmount(accountA2, accountB2, currencyAmount2, PaymentType.PAYPAL,
				credentialA2);
		bookingWithPayPal2.getFooter().setPayment(paymentWithPayPal2);

		/** ------------------------------------------------ **/

		// below creation of english accounts

		/** ------------------------------------------------ **/

		// CREATE BOOKING (ApplePay, English)
		Person personA3 = personService.createPerson("James", "LoveBuy");
		Resource resourceA3 = resourceService.getSelectedResource(ResourceEnumeration.CAR);
		bookingWithApplePay = bookingService.createBooking(personA3, resourceA3, Language.ENGLISH);

		/** ------------------------------------------------ **/

		// CREATE BOOKING2 (ApplePay, English)
		Person personA4 = personService.createPerson("Jonathan", "LosesMoney");
		Resource resourceA4 = resourceService.getSelectedResource(ResourceEnumeration.CAR);
		bookingWithApplePay2 = bookingService.createBooking(personA4, resourceA4, Language.ENGLISH);

		/** ------------------------------------------------ **/

		// CREATE PAYMENT (ApplePay, English)
		Credential credentialA3 = authenticationService.createCredential(CredentialEnumeration.PASSWORD, "ABC");
		Subject subjectA3 = authenticationService.createSubject(personA3, credentialA3, Role.CUSTOMER);
		Account accountA3 = new AppleAccount(subjectA3);

		Person personB3 = personService.createPerson("Fred", "BestSeller");
		Credential credentialB3 = authenticationService.createCredential(CredentialEnumeration.PASSWORD, "CBA");
		Subject subjectB3 = authenticationService.createSubject(personB3, credentialB3, Role.STAFF);
		Account accountB3 = new AppleAccount(subjectB3);

		CurrencyAmount currencyAmount3 = new CurrencyAmount();
		currencyAmount3.setAmount(120);

		paymentWithApplePay = paymentService.payAmount(accountA3, accountB3, currencyAmount3, PaymentType.APPLE_PAY,
				credentialA3);
		bookingWithApplePay.getFooter().setPayment(paymentWithApplePay);

		/** ------------------------------------------------ **/

		// CREATE PAYMENT2 (ApplePay, English)
		Credential credentialA4 = authenticationService.createCredential(CredentialEnumeration.PASSWORD, "ABC");
		Subject subjectA4 = authenticationService.createSubject(personA4, credentialA4, Role.CUSTOMER);
		Account accountA4 = new AppleAccount(subjectA4);

		Person personB4 = personService.createPerson("Glen", "WorstSeller");
		Credential credentialB4 = authenticationService.createCredential(CredentialEnumeration.PASSWORD, "CBA");
		Subject subjectB4 = authenticationService.createSubject(personB4, credentialB4, Role.STAFF);
		Account accountB4 = new AppleAccount(subjectB4);

		CurrencyAmount currencyAmount4 = new CurrencyAmount();
		currencyAmount4.setAmount(120);

		paymentWithApplePay2 = paymentService.payAmount(accountA4, accountB4, currencyAmount4, PaymentType.APPLE_PAY,
				credentialA4);
		bookingWithApplePay2.getFooter().setPayment(paymentWithApplePay2);
	}

	@Test
	@Order(1)
	void canGermanPaymentOutOfBookingsBeGathered() {

		contentService.addContent(bookingWithPayPal, ContentType.BOOKING);
		contentService.addContent(paymentWithPayPal, ContentType.PAYMENT);
		ExternalPaymentStatistic statistic = statisticsService
				.getGermanBookingsPaidBy(ExternalPaymentServiceEnumeration.PAYPAL);
		assertEquals(1, statistic.getBookingSum());
		assertEquals(120.0, statistic.getPaymentSum());

		contentService.addContent(bookingWithPayPal2, ContentType.BOOKING);
		contentService.addContent(paymentWithPayPal2, ContentType.PAYMENT);
		statistic = statisticsService.getGermanBookingsPaidBy(ExternalPaymentServiceEnumeration.PAYPAL);
		assertEquals(2, statistic.getBookingSum());
		assertEquals(240.0, statistic.getPaymentSum());
	}

	@Test
	@Order(2)
	void canEnglishPaymentOutOfBookingsBeGathered() {

		contentService.addContent(bookingWithApplePay, ContentType.BOOKING);
		contentService.addContent(paymentWithApplePay, ContentType.PAYMENT);
		ExternalPaymentStatistic statistic = statisticsService
				.getEnglishBookingsPaidBy(ExternalPaymentServiceEnumeration.APPLE_PAY);
		assertEquals(1, statistic.getBookingSum());
		assertEquals(120.0, statistic.getPaymentSum());

		contentService.addContent(bookingWithApplePay2, ContentType.BOOKING);
		contentService.addContent(paymentWithApplePay2, ContentType.PAYMENT);
		statistic = statisticsService.getEnglishBookingsPaidBy(ExternalPaymentServiceEnumeration.APPLE_PAY);
		assertEquals(2, statistic.getBookingSum());
		assertEquals(240.0, statistic.getPaymentSum());
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		statisticsService = null;
		paymentService = null;
		bookingService = null;
		personService = null;
		resourceService = null;
		authenticationService = null;
		contentService = null;
	}
}

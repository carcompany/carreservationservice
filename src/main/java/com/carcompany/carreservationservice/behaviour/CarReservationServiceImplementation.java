package com.carcompany.carreservationservice.behaviour;

import java.util.Map;

import javax.security.sasl.AuthenticationException;

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
import com.carcompany.carreservationservice.structure.paymentservice.structure.exception.PaymentExecutionException;
import com.carcompany.carreservationservice.structure.personservice.behaviour.PersonService;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.carreservationservice.structure.resourceservice.behaviour.ResourceService;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;
import com.carcompany.carreservationservice.structure.resourceservice.structure.ResourceDecorator;
import com.carcompany.carreservationservice.structure.resourceservice.structure.ResourceEnumeration;
import com.carcompany.carreservationservice.structure.resourceservice.structure.exception.MoreThanOneDecoratableResourceException;
import com.carcompany.carreservationservice.structure.resourceservice.structure.exception.NoDecoratableResourceException;
import com.carcompany.carreservationservice.structure.statisticsservice.behaviour.StatisticsService;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.ExternalPaymentServiceEnumeration;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.ExternalPaymentStatistic;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:40
 */
public class CarReservationServiceImplementation implements CarReservationService {

	private Account receiverAccount;

	public CarReservationServiceImplementation() {
		Person person = PersonService.getInstance().createPerson("CarCompany");

		Credential credential = AuthenticationService.getInstance().createCredential(CredentialEnumeration.PASSWORD,
				"super-secret-password");
		Subject subject = AuthenticationService.getInstance().createSubject(person, credential, Role.CUSTOMER);
		this.receiverAccount = PaymentService.getInstance().createAccount(subject, PaymentType.BANK);
	}

	public Person createPerson(String... names) {
		return PersonService.getInstance().createPerson(names);
	}

	@Override
	public Person showPerson(int id) throws Exception {
		return PersonService.getInstance().getPerson(id);
	}

	@Override
	public void deletePerson(int id) throws Exception {
		PersonService.getInstance().deletePerson(id);
	}

	public Account createAccount(Person person, CredentialEnumeration credentialEnumeration, Object secret,
			PaymentType paymentType) {
		Credential credential = AuthenticationService.getInstance().createCredential(credentialEnumeration, secret);
		Subject subject = AuthenticationService.getInstance().createSubject(person, credential, Role.CUSTOMER);

		return PaymentService.getInstance().createAccount(subject, paymentType);
	}

	public Resource createResource(ResourceEnumeration... resourceEnumeration)
			throws MoreThanOneDecoratableResourceException, NoDecoratableResourceException {
		return ResourceService.getInstance().getSelectedResource(resourceEnumeration);
	}

	public ExternalPaymentStatistic showStatistics(Language language,
			ExternalPaymentServiceEnumeration externalPaymentServiceEnumeration) {
		ExternalPaymentStatistic statistic = null;

		switch (language) {
			case ENGLISH:
				statistic = StatisticsService.getInstance().getEnglishBookingsPaidBy(externalPaymentServiceEnumeration);
				break;
			case GERMAN:
				statistic = StatisticsService.getInstance().getGermanBookingsPaidBy(externalPaymentServiceEnumeration);
				break;

		}

		return statistic;
	}

	public Booking payBooking(Booking booking, PaymentType paymentType, Account senderAccount, Credential credential)
			throws AuthenticationException, PaymentExecutionException {
		CurrencyAmount currencyAmount = new CurrencyAmount();

		double totalPrice = 0;
		Resource resource = booking.getBody().getResource();

		while (resource != null) {
			totalPrice += resource.getPrice();

			if (resource instanceof ResourceDecorator) {
				resource = ((ResourceDecorator) resource).getResource();
			} else {
				resource = null;
			}
		}

		currencyAmount.setAmount(totalPrice);

		Payment payment = PaymentService.getInstance().payAmount(senderAccount, receiverAccount, currencyAmount,
				paymentType, credential);

		booking.getFooter().setPayment(payment);

		ContentService.getInstance().addContent(booking, ContentType.BOOKING);
		ContentService.getInstance().addContent(payment, ContentType.PAYMENT);

		return booking;

	}

	public Booking createBooking(Person person, Resource resource, Language language) {
		return BookingService.getInstance().createBooking(person, resource, language);
	}

	public Booking showBooking(int id) {
		return BookingService.getInstance().getBooking(id);
	}

	public Map<Integer, Booking> showBookings() {
		return BookingService.getInstance().getBookings();
	}

	@Override
	public Credential createCredential(CredentialEnumeration credentialEnumeration, Object secret) {
		return AuthenticationService.getInstance().createCredential(credentialEnumeration, secret);
	}
}
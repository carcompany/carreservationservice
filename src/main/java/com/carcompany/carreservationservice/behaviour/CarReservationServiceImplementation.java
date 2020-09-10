package com.carcompany.carreservationservice.behaviour;

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
import com.carcompany.carreservationservice.structure.paymentservice.structure.exception.UnsupportedPaymentTypeException;
import com.carcompany.carreservationservice.structure.personservice.behaviour.PersonService;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.carreservationservice.structure.resourceservice.behaviour.ResourceService;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;
import com.carcompany.carreservationservice.structure.resourceservice.structure.ResourceEnumeration;
import com.carcompany.carreservationservice.structure.resourceservice.structure.exception.MoreThanOneDecoratableResourceException;
import com.carcompany.carreservationservice.structure.resourceservice.structure.exception.NoDecoratableResourceException;
import com.carcompany.carreservationservice.structure.statisticsservice.behaviour.StatisticsService;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.ExternalPaymentServiceEnumeration;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.Statistic;

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

	/**
	 * 
	 * @param names
	 */
	public Person createPerson(String... names) {
		return PersonService.getInstance().createPerson(names);
	}

	public Account createAccount(Person person, CredentialEnumeration credentialEnumeration, Object secret,
			PaymentType paymentType) {
		Credential credential = AuthenticationService.getInstance().createCredential(credentialEnumeration, secret);
		Subject subject = AuthenticationService.getInstance().createSubject(person, credential, Role.CUSTOMER);

		return PaymentService.getInstance().createAccount(subject, paymentType);
	}

	/**
	 * 
	 * @param resourceEnumeration
	 * @throws NoDecoratableResourceException
	 * @throws MoreThanOneDecoratableResourceException
	 */
	public Resource createResource(ResourceEnumeration... resourceEnumeration)
			throws MoreThanOneDecoratableResourceException, NoDecoratableResourceException {
		return ResourceService.getInstance().getSelectedResource(resourceEnumeration);
	}

	public Statistic showStatistics(Language language,
			ExternalPaymentServiceEnumeration externalPaymentServiceEnumeration) {
		Statistic statistic = null;

		switch (language) {
			case ENGLISH:
				StatisticsService.getInstance().getEnglishBookingsPaidBy(externalPaymentServiceEnumeration);
				break;
			case GERMAN:
				StatisticsService.getInstance().getEnglishBookingsPaidBy(externalPaymentServiceEnumeration);
				break;

		}

		return statistic;
	}

	/**
	 * 
	 * @param bookingId
	 * @throws UnsupportedPaymentTypeException
	 * @throws AuthenticationException
	 */
	public Booking payBooking(Booking booking, PaymentType paymentType, Account senderAccount, Credential credential)
			throws AuthenticationException, UnsupportedPaymentTypeException {
		CurrencyAmount currencyAmount = new CurrencyAmount();
		currencyAmount.setAmount(booking.getBody().getResource().getPrice());

		Payment payment = PaymentService.getInstance().payAmount(senderAccount, receiverAccount, currencyAmount,
				paymentType, credential);

		booking.getFooter().setPayment(payment);

		ContentService.getInstance().addContent(booking, ContentType.BOOKING);
		ContentService.getInstance().addContent(payment, ContentType.PAYMENT);

		return booking;

	}

	/**
	 * 
	 * @param personId
	 * @param resourceId
	 * @param language
	 */
	public Booking createBooking(Person person, Resource resource, Language language) {
		return BookingService.getInstance().createBooking(person, resource, language);
	}

	@Override
	public Credential createCredential(CredentialEnumeration credentialEnumeration, Object secret) {
		return AuthenticationService.getInstance().createCredential(credentialEnumeration, secret);
	}
}
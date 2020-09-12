package com.carcompany.carreservationservice.behaviour;

import java.util.Map;

import javax.security.sasl.AuthenticationException;

import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.Credential;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.CredentialEnumeration;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Language;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PaymentType;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.Account;
import com.carcompany.carreservationservice.structure.paymentservice.structure.exception.PaymentExecutionException;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.carreservationservice.structure.personservice.structure.exception.TooFewOrManyParametersForPersonCreationException;
import com.carcompany.carreservationservice.structure.resourceservice.structure.Resource;
import com.carcompany.carreservationservice.structure.resourceservice.structure.ResourceEnumeration;
import com.carcompany.carreservationservice.structure.resourceservice.structure.exception.MoreThanOneDecoratableResourceException;
import com.carcompany.carreservationservice.structure.resourceservice.structure.exception.NoDecoratableResourceException;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.ExternalPaymentServiceEnumeration;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.ExternalPaymentStatistic;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:40
 */
public interface CarReservationService {

	/**
	 * 
	 * @param names
	 */
	public Person createPerson(String... names) throws TooFewOrManyParametersForPersonCreationException;

	public Person showPerson(int id) throws Exception;

	public void deletePerson(int id) throws Exception;

	/**
	 * 
	 * @param names
	 */
	public Account createAccount(Person person, CredentialEnumeration credentialEnumeration, Object secret,
			PaymentType paymentType) throws TooFewOrManyParametersForPersonCreationException;

	/**
	 * 
	 * @param resourceEnumeration
	 */
	public Resource createResource(ResourceEnumeration... resourceEnumeration)
			throws MoreThanOneDecoratableResourceException, NoDecoratableResourceException;

	public ExternalPaymentStatistic showStatistics(Language language,
			ExternalPaymentServiceEnumeration externalPaymentServiceEnumeration);

	/**
	 * 
	 * @param bookingId
	 */
	public Booking payBooking(Booking booking, PaymentType paymentType, Account senderAccount, Credential credential)
			throws AuthenticationException, PaymentExecutionException;

	/**
	 * 
	 * @param testPerson
	 * @param testResource
	 * @param language
	 */

	public Booking createBooking(Person person, Resource resource, Language language);

	public Booking showBooking(int id);

	public Map<Integer, Booking> showBookings();

	public Credential createCredential(CredentialEnumeration credentialEnumeration, Object secret);
}
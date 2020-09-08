package com.carcompany.carresverationservice.structure;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.carcompany.carreservationservice.structure.authenticationservice.behaviour.AuthenticationService;
import com.carcompany.carreservationservice.structure.authenticationservice.behaviour.AuthenticationServiceImplementation;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.Role;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.Credential;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.CredentialEnumeration;
import com.carcompany.carreservationservice.structure.paymentservice.behaviour.PaymentService;
import com.carcompany.carreservationservice.structure.paymentservice.behaviour.PaymentServiceImplementation;
import com.carcompany.carreservationservice.structure.paymentservice.domainvalue.CurrencyAmount;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PaymentType;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.Account;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.BankAccount;
import com.carcompany.carreservationservice.structure.personservice.behaviour.PersonServiceImplementation;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PaymentServiceTest {

	private static PaymentService paymentService;
	private static AuthenticationService authenticationService;

	private static Person personA;
	private static Person personB;

	private static Account senderAccount;
	private static Account receiverAccount;
	private static CurrencyAmount currencyAmount;
	private static PaymentType paymentType;
	private static Credential secret;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		paymentService = new PaymentServiceImplementation();
		authenticationService = AuthenticationServiceImplementation.getInstance();

		personA = new PersonServiceImplementation().createPerson("Rainer", "Zufall");
		personB = new PersonServiceImplementation().createPerson("Renate", "Zufall");

		currencyAmount = new CurrencyAmount();
		paymentType = PaymentType.APPLE_PAY;
		secret = authenticationService.createCredential(CredentialEnumeration.PASSWORD, "AAAAAAAAAAAA");

		senderAccount = new BankAccount(authenticationService.createSubject(personA, secret, Role.CUSTOMER));

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void canAmountBePaid() {
		assertDoesNotThrow(
				() -> paymentService.payAmount(senderAccount, receiverAccount, currencyAmount, paymentType, secret));
	}
}

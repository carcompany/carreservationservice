package com.carcompany.carreservationservice.structure.paymentservice.structure.paymentprocess;

import com.carcompany.carreservationservice.structure.authenticationservice.behaviour.AuthenticationService;
import com.carcompany.carreservationservice.structure.authenticationservice.behaviour.AuthenticationServiceImplementation;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.Role;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.Credential;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.subject.Subject;
import com.carcompany.carreservationservice.structure.paymentservice.domainvalue.CurrencyAmount;
import com.carcompany.carreservationservice.structure.paymentservice.structure.Payment;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.Account;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:49
 */
public abstract class PaymentProcess {
	private AuthenticationService authenticationService;

	public boolean authenticateCustomer(Subject subject, Credential secret) {
		authenticationService = AuthenticationServiceImplementation.getInstance();
		
		return authenticationService.authenticateSubject(subject.getId(), secret, Role.CUSTOMER);

	}

	public abstract boolean executePayment(Account senderAccount, Account receiverAccount, CurrencyAmount currencyAmount);

	public Payment getPayment(Account sender, Account receiver, CurrencyAmount amount) {

		return new Payment(sender, receiver, amount);

	}
}// end PaymentProcess
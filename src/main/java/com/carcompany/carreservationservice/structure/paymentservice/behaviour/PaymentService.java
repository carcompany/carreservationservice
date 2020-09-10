package com.carcompany.carreservationservice.structure.paymentservice.behaviour;

import javax.security.sasl.AuthenticationException;

import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.Credential;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.subject.Subject;
import com.carcompany.carreservationservice.structure.paymentservice.domainvalue.CurrencyAmount;
import com.carcompany.carreservationservice.structure.paymentservice.structure.Payment;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PaymentType;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.Account;
import com.carcompany.carreservationservice.structure.paymentservice.structure.exception.UnsupportedPaymentTypeException;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:50
 */
public abstract class PaymentService {

	private static PaymentService paymentService;

	public static PaymentService getInstance() {
		if (paymentService == null)
			paymentService = new PaymentServiceImplementation();

		return paymentService;
	}

	/**
	 * 
	 * @param senderAccount
	 * @param receiverAccount
	 * @param currencyAmount
	 * @param paymentType
	 * @throws UnsupportedPaymentTypeException
	 * @throws AuthenticationException
	 */
	public abstract Payment payAmount(Account senderAccount, Account receiverAccount, CurrencyAmount currencyAmount,
			PaymentType paymentType, Credential secret) throws UnsupportedPaymentTypeException, AuthenticationException;

	public abstract Account createAccount(Subject subject, PaymentType paymentType);

}
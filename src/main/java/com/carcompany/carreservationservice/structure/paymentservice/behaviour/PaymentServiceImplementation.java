package com.carcompany.carreservationservice.structure.paymentservice.behaviour;

import javax.security.sasl.AuthenticationException;

import com.carcompany.carreservationservice.structure.authenticationservice.behaviour.AuthenticationService;
import com.carcompany.carreservationservice.structure.authenticationservice.behaviour.AuthenticationServiceImplementation;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.Credential;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.CredentialEnumeration;
import com.carcompany.carreservationservice.structure.paymentservice.domainvalue.CurrencyAmount;
import com.carcompany.carreservationservice.structure.paymentservice.structure.Payment;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PaymentType;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.Account;
import com.carcompany.carreservationservice.structure.paymentservice.structure.exception.UnsupportedPaymentTypeException;
import com.carcompany.carreservationservice.structure.paymentservice.structure.paymentprocess.ApplePayPaymentProcess;
import com.carcompany.carreservationservice.structure.paymentservice.structure.paymentprocess.GooglePayPaymentProcess;
import com.carcompany.carreservationservice.structure.paymentservice.structure.paymentprocess.PayPalPaymentProcess;
import com.carcompany.carreservationservice.structure.paymentservice.structure.paymentprocess.PaymentProcess;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:50
 */
public class PaymentServiceImplementation implements PaymentService {

	public PaymentServiceImplementation() {

	}

	/**
	 * 
	 * @param senderAccount
	 * @param receiverAccount
	 * @param currencyAmount
	 * @param paymentType
	 * @return 
	 * @throws UnsupportedPaymentTypeException
	 */
	public Payment payAmount(Account senderAccount, Account receiverAccount, CurrencyAmount currencyAmount,
			PaymentType paymentType) throws UnsupportedPaymentTypeException {
		PaymentProcess paymentProcess;
		switch (paymentType) {
		case APPLE_PAY:
			paymentProcess = new ApplePayPaymentProcess();
			break;
		case GOOGLE_PAY:
			paymentProcess = new GooglePayPaymentProcess();
			break;

		case PAYPAL:
			paymentProcess = new PayPalPaymentProcess();
			break;
		case BANK:
			paymentProcess = new ApplePayPaymentProcess();
			break;

		default:
			throw new UnsupportedPaymentTypeException();
			break;
		}
		
		AuthenticationService authenticationService = new AuthenticationServiceImplementation();
		Credential secret = authenticationService.createCredential(CredentialEnumeration.PASSWORD, "AAAAAAAAAA");
		
		

		if (paymentProcess.authenticateCustomer(senderAccount.getSubject(), secret )) {

			if(paymentProcess.executePayment(senderAccount, receiverAccount, currencyAmount)) {
				
				return paymentProcess.getPayment(senderAccount, receiverAccount, currencyAmount);
				
			}

		} else {
			throw new AuthenticationException("Authentication failed");
		}
	}
}// end PaymentServiceImplementation
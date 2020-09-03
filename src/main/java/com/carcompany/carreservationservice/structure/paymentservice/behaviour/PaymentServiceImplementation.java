package com.carcompany.carreservationservice.structure.paymentservice.behaviour;

import javax.security.sasl.AuthenticationException;

import com.carcompany.carreservationservice.structure.paymentservice.domainvalue.CurrencyAmount;
import com.carcompany.carreservationservice.structure.paymentservice.structure.Account;
import com.carcompany.carreservationservice.structure.paymentservice.structure.ApplePayPaymentProcess;
import com.carcompany.carreservationservice.structure.paymentservice.structure.GooglePayPaymentProcess;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PayPalPaymentProcess;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PaymentProcess;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PaymentType;
import com.carcompany.carreservationservice.structure.paymentservice.structure.exception.UnsupportedPaymentTypeException;

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
	 * @throws UnsupportedPaymentTypeException 
	 */
	public void payAmount(Account senderAccount, Account receiverAccount, CurrencyAmount currencyAmount,
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

		if (paymentProcess.authenticateCustomer(senderAccount.getPerson())) {
			paymentProcess.initiatePayment();
			paymentProcess.generateBillingReceipt();
		} else {
			throw new AuthenticationException("Authentication failed");
		}
	}
}// end PaymentServiceImplementation
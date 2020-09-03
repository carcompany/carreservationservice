package com.carcompany.carreservationservice.structure.paymentservice.behaviour;

import com.carcompany.carreservationservice.structure.paymentservice.domainvalue.CurrencyAmount;
import com.carcompany.carreservationservice.structure.paymentservice.structure.Account;
import com.carcompany.carreservationservice.structure.paymentservice.structure.ApplePayPaymentProcess;
import com.carcompany.carreservationservice.structure.paymentservice.structure.GooglePayPaymentProcess;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PayPalPaymentProcess;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PaymentProcess;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PaymentType;

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
	 */
	public void payAmount(Account senderAccount, Account receiverAccount, CurrencyAmount currencyAmount,
			PaymentType paymentType) {
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
		
		paymentProcess.authenticateCustomer();
		paymentProcess.initiatePayment();
		paymentProcess.generateBillingReceipt();
	}
}// end PaymentServiceImplementation
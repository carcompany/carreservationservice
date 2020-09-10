package com.carcompany.carreservationservice.structure.paymentservice.behaviour;

import javax.security.sasl.AuthenticationException;

import com.carcompany.carreservationservice.structure.authenticationservice.structure.credential.Credential;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.subject.Subject;
import com.carcompany.carreservationservice.structure.paymentservice.domainvalue.CurrencyAmount;
import com.carcompany.carreservationservice.structure.paymentservice.structure.Payment;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PaymentType;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.Account;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.AppleAccount;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.BankAccount;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.GoogleAccount;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.PayPalAccount;
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
public class PaymentServiceImplementation extends PaymentService {

	/**
	 * 
	 * @param senderAccount
	 * @param receiverAccount
	 * @param currencyAmount
	 * @param paymentType
	 * @return
	 * @throws UnsupportedPaymentTypeException
	 * @throws AuthenticationException
	 */
	public Payment payAmount(Account senderAccount, Account receiverAccount, CurrencyAmount currencyAmount,
			PaymentType paymentType, Credential secret)
			throws UnsupportedPaymentTypeException, AuthenticationException {
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
		}

		if (paymentProcess.authenticateCustomer(senderAccount.getSubject(), secret)) {
			if (paymentProcess.executePayment(senderAccount, receiverAccount, currencyAmount)) {
				return paymentProcess.getPayment(senderAccount, receiverAccount, currencyAmount, paymentType);
			}

		} else {
			throw new AuthenticationException("Authentication failed");
		}

		return null;
	}

	@Override
	public Account createAccount(Subject subject, PaymentType paymentType) {
		Account account = null;

		switch (paymentType) {
			case APPLE_PAY:
				account = new AppleAccount(subject);
				break;
			case BANK:
				account = new BankAccount(subject);
				break;
			case GOOGLE_PAY:
				account = new GoogleAccount(subject);
				break;
			case PAYPAL:
				account = new PayPalAccount(subject);
				break;
		}
		return account;
	}

}
// end PaymentServiceImplementation
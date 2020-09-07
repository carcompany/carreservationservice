package com.carcompany.carreservationservice.structure.paymentservice.structure.paymentprocess;

import com.carcompany.carreservationservice.structure.paymentservice.domainvalue.CurrencyAmount;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.Account;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:48
 */
public class GooglePayPaymentProcess extends PaymentProcess {

	@Override
	public boolean executePayment(Account senderAccount, Account receiverAccount, CurrencyAmount currencyAmount) {
		
		// PAYMENT DUMMY
		return true;
	}
}//end GooglePayPaymentProcess
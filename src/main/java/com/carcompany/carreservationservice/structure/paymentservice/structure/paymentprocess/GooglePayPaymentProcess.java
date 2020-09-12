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
		CurrencyAmount senderAccountBalance = senderAccount.getBalance();
		CurrencyAmount receiverAccountBalance = receiverAccount.getBalance();

		receiverAccountBalance.setAmount(receiverAccountBalance.getAmount() + currencyAmount.getAmount());

		// 10% processing fee
		senderAccountBalance.setAmount(senderAccountBalance.getAmount() - currencyAmount.getAmount() * 1.1);

		senderAccount.setBalance(senderAccountBalance);
		receiverAccount.setBalance(receiverAccountBalance);

		return true;
	}
}
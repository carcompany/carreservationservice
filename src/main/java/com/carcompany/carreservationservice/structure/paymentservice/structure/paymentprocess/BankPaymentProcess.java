package com.carcompany.carreservationservice.structure.paymentservice.structure.paymentprocess;

import com.carcompany.carreservationservice.structure.paymentservice.domainvalue.CurrencyAmount;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.Account;

/**
 * @author Sebastian, Kevin
 * @version 1.1
 * @created 28-Aug-2020 17:10:53
 */
public class BankPaymentProcess extends PaymentProcess {

	@Override
	public boolean executePayment(Account senderAccount, Account receiverAccount, CurrencyAmount currencyAmount) {
		CurrencyAmount senderAccountBalance = senderAccount.getBalance();
		CurrencyAmount receiverAccountBalance = senderAccount.getBalance();

		// cannot go beyond 0
		if (senderAccountBalance.getAmount() < currencyAmount.getAmount())
			return false;

		receiverAccountBalance.setAmount(receiverAccountBalance.getAmount() + currencyAmount.getAmount());
		senderAccountBalance.setAmount(senderAccountBalance.getAmount() - currencyAmount.getAmount());

		senderAccount.setBalance(senderAccountBalance);
		receiverAccount.setBalance(receiverAccountBalance);

		return true;
	}
}// end BankPaymentProcess
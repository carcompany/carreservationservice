package com.carcompany.carreservationservice.structure.paymentservice.structure.paymentprocess;

import com.carcompany.carreservationservice.structure.paymentservice.domainvalue.CurrencyAmount;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.Account;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:51
 */
public class PayPalPaymentProcess extends PaymentProcess {

	@Override
	public boolean executePayment(Account senderAccount, Account receiverAccount, CurrencyAmount currencyAmount) {
		CurrencyAmount senderAccountBalance = senderAccount.getBalance();
		CurrencyAmount receiverAccountBalance = receiverAccount.getBalance();

		receiverAccountBalance.setAmount(receiverAccountBalance.getAmount() + currencyAmount.getAmount());
		// transaction gift
		senderAccountBalance.setAmount(senderAccountBalance.getAmount() - currencyAmount.getAmount() * 0.99);

		senderAccount.setBalance(senderAccountBalance);
		receiverAccount.setBalance(receiverAccountBalance);

		return true;
	}
}
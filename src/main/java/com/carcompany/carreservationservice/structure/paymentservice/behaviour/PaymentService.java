package com.carcompany.carreservationservice.structure.paymentservice.behaviour;

import com.carcompany.carreservationservice.structure.paymentservice.domainvalue.CurrencyAmount;
import com.carcompany.carreservationservice.structure.paymentservice.structure.Payment;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PaymentType;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.Account;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:50
 */
public interface PaymentService {

	/**
	 * 
	 * @param senderAccount
	 * @param receiverAccount
	 * @param currencyAmount
	 * @param paymentType
	 */
	public Payment payAmount(Account senderAccount, Account receiverAccount, CurrencyAmount currencyAmount, PaymentType paymentType);

}
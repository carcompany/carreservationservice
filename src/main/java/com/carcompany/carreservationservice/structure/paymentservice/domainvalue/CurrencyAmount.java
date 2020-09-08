package com.carcompany.carreservationservice.structure.paymentservice.domainvalue;

import com.carcompany.carreservationservice.structure.paymentservice.structure.Currency;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:44
 */
public class CurrencyAmount {

	private Currency currency;
	private double amount;

	public CurrencyAmount(){

	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	


}//end CurrencyAmount
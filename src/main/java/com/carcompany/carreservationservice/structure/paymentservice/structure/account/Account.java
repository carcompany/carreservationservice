package com.carcompany.carreservationservice.structure.paymentservice.structure.account;

import com.carcompany.carreservationservice.structure.authenticationservice.structure.subject.Subject;
import com.carcompany.carreservationservice.structure.paymentservice.domainvalue.CurrencyAmount;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:34
 */
public abstract class Account {

	private static int instanceCount = 0;

	private int id;
	private Subject subject;
	private CurrencyAmount balance;

	public Account(Subject subject) {
		this.id = instanceCount++;
		this.subject = subject;
		this.balance = new CurrencyAmount();
		this.balance.setAmount(1000);
	}

	public int getId() {
		return this.id;
	}

	public Subject getSubject() {
		return this.subject;
	}

	public void setBalance(CurrencyAmount balance) {
		this.balance = balance;
	}

	public CurrencyAmount getBalance() {
		return this.balance;
	}
}
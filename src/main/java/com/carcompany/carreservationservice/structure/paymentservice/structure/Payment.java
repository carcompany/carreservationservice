package com.carcompany.carreservationservice.structure.paymentservice.structure;

import com.carcompany.carreservationservice.structure.paymentservice.domainvalue.CurrencyAmount;
import com.carcompany.carreservationservice.structure.paymentservice.structure.account.Account;

public class Payment {
	
	private static int numberOfPayments;
	
	private int id;
	private Account senderAccount;
	private Account receiverAccount;
	private CurrencyAmount currencyAmount;
	private PaymentType paymentType;

	public Payment(Account sender, Account receiver, CurrencyAmount amount, PaymentType paymentType){
		
		this.setSenderAccount(sender);
		this.setReceiverAccount(receiver);
		this.setCurrencyAmount(amount);
		this.setPaymentType(paymentType);
		this.setId(numberOfPayments);

		
		
		
		this.incrementNumberOfPayments();
	
	}

	private void incrementNumberOfPayments() {
		
		numberOfPayments++;
		
	}

	public Account getSenderAccount() {
		return senderAccount;
	}

	public void setSenderAccount(Account senderAccount) {
		this.senderAccount = senderAccount;
	}

	public Account getReceiverAccount() {
		return receiverAccount;
	}

	public void setReceiverAccount(Account receiverAccount) {
		this.receiverAccount = receiverAccount;
	}

	public CurrencyAmount getCurrencyAmount() {
		return currencyAmount;
	}

	public void setCurrencyAmount(CurrencyAmount currencyAmount) {
		this.currencyAmount = currencyAmount;
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	
	
	
	

}

package com.carcompany.carreservationservice.structure.paymentservice.structure;

import com.carcompany.carreservationservice.structure.personservice.structure.Person;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:49
 */
public abstract class PaymentProcess {

	public boolean authenticateCustomer(Person person) {
		return false;
	}

	public abstract void initiatePayment();

	public void generateBillingReceipt() {

	}
}// end PaymentProcess
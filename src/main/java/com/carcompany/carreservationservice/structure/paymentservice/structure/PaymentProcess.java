package com.carcompany.carreservationservice.structure.paymentservice.structure;


/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:49
 */
public abstract class PaymentProcess {

	public PaymentProcess(){

	}

	public void finalize() throws Throwable {

	}
	public boolean authenticateCustomer(){
		return false;
	}

	public abstract void initiatePayment();

	public void generateBillingReceipt(){

	}
}//end PaymentProcess
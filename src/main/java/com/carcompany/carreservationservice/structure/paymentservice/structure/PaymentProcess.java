package com.carcompany.carreservationservice.structure.paymentservice.structure;

import com.carcompany.carreservationservice.structure.authenticationservice.behaviour.AuthenticationService;
import com.carcompany.carreservationservice.structure.authenticationservice.behaviour.AuthenticationServiceImplementation;
import com.carcompany.carreservationservice.structure.authenticationservice.structure.Role;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:49
 */
public abstract class PaymentProcess {
	 private AuthenticationService authenticationService;

	public boolean authenticateCustomer(Person person) {
		authenticationService = new AuthenticationServiceImplementation();
		
		return authenticationService.authenticateSubject(subject, credential, role);
	}

	public abstract void initiatePayment();

	public void generateBillingReceipt() {

	}
}// end PaymentProcess
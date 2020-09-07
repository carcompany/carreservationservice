package com.carcompany.carreservationservice.structure.paymentservice.structure.account;

import com.carcompany.carreservationservice.structure.authenticationservice.structure.subject.Subject;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:34
 */
public abstract class Account {

	protected Subject subject;

	public Account(Subject subject) {
		this.subject = subject;
		
	}

	public Subject getSubject() {
		return this.subject;
	}
}// end Account
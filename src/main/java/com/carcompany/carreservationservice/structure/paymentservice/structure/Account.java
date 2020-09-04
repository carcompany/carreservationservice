package com.carcompany.carreservationservice.structure.paymentservice.structure;

import com.carcompany.carreservationservice.structure.personservice.structure.Person;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:34
 */
public abstract class Account {

	protected Person person;


	public Account(Person person){

	}

	public Person getPerson() {
		return this.person;
	}
}//end Account
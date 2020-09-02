package com.carcompany.carreservationservice.structure.bookingservice.structure;

import com.carcompany.carreservationservice.structure.Person.structure.Person;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:48
 */
public class Head {

	private Person person;

	public void setPerson(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return this.person;
	}
}
package com.carcompany.carreservationservice.structure.authenticationservice.structure.subject;

import com.carcompany.carreservationservice.structure.personservice.structure.Person;

/**
 * @author Leo
 * @version 1.0
 * @created 28-Aug-2020 17:10:51
 */
public class PersonSubject extends Subject {

	private Person person;

	public void setPerson(Person person) {
		this.person = person;
	}

	public Person getPerson() {
		return this.person;
	}
}
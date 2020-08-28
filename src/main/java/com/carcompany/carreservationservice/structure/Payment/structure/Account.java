package com.carcompany.carreservationservice.structure.Payment.structure;

import com.carcompany.carreservationservice.structure.Person.structure.Person;

/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:34
 */
public abstract class Account {

	protected Person person;

	public Account(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param person
	 */
	public Account(Person person){

	}
}//end Account
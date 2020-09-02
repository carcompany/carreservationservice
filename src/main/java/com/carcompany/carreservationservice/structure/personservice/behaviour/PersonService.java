package com.carcompany.carreservationservice.structure.personservice.behaviour;

import com.carcompany.carreservationservice.structure.personservice.structure.Person;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:51
 */
public interface PersonService {

	/**
	 * 
	 * @param parameters
	 */
	public Person createPerson(String... parameters);

}
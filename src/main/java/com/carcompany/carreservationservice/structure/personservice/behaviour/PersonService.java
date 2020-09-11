package com.carcompany.carreservationservice.structure.personservice.behaviour;

import com.carcompany.carreservationservice.structure.personservice.structure.Person;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:51
 */
public abstract class PersonService {

	private static PersonService instance;

	public static PersonService getInstance() {
		if (instance == null) {
			instance = new PersonServiceImplementation();
		}

		return instance;
	}

	/**
	 * 
	 * @param parameters
	 */
	public abstract Person createPerson(String... parameters);
	public abstract void deletePerson(int id) throws Exception;
	public abstract Person getPerson(int id) throws Exception;

}
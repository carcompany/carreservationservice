package com.carcompany.carreservationservice.structure.personservice.behaviour;

import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.carreservationservice.structure.personservice.structure.PersonFactory;
import com.carcompany.carreservationservice.structure.personservice.structure.PersonType;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:51
 */
public class PersonServiceImplementation implements PersonService {

	public PersonType m_PersonType;
	public PersonFactory m_PersonFactory;

	public PersonServiceImplementation(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param parameters
	 */
	public Person createPerson(String... parameters){
		return null;
	}
}//end PersonServiceImplementation
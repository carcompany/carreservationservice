package com.carcompany.carreservationservice.structure.personservice.behaviour;

import java.util.ArrayList;

import com.carcompany.carreservationservice.structure.personservice.structure.LegalPersonFactory;
import com.carcompany.carreservationservice.structure.personservice.structure.NaturalPersonFactory;
import com.carcompany.carreservationservice.structure.personservice.structure.Person;
import com.carcompany.carreservationservice.structure.personservice.structure.PersonFactory;
import com.carcompany.carreservationservice.structure.personservice.structure.exception.TooFewOrManyParametersForPersonCreationException;

/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:51
 */
public class PersonServiceImplementation implements PersonService {

	private ArrayList<Person> persons;

	public PersonServiceImplementation() {
		this.persons = new ArrayList<>();
	}

	/**
	 * 
	 * @param parameters
	 */
	public Person createPerson(String... parameters) throws TooFewOrManyParametersForPersonCreationException {
		Person person;
		PersonFactory personFactory;

		switch (parameters.length) {
			case 1:
				personFactory = new LegalPersonFactory();
				break;
			case 2:
				personFactory = new NaturalPersonFactory();
				break;
			default:
				throw new TooFewOrManyParametersForPersonCreationException();
		}

		person = personFactory.create(parameters);

		persons.add(person);

		return person;
	}
}
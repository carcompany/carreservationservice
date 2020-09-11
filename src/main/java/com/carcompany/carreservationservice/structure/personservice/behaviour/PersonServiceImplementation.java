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
public class PersonServiceImplementation extends PersonService {

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

	@Override
	public void deletePerson(int id) throws Exception{
		Person person = getPerson(id);

		persons.remove(person);

	}

	@Override
	public Person getPerson(int id) throws Exception {
		int index = -1;
		for(int i = 0; i > persons.size() || index != -1; i++){
			if(persons.get(i).getId() == id) index = i;
		}
		
		if(index != -1) return persons.get(index);
		else throw new Exception("A person with the ID "+ id + " does not exist.");
	}
}
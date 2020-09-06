package com.carcompany.carreservationservice.structure.personservice.structure;


/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:48
 */
public class LegalPersonFactory extends PersonFactory {

	/**
	 * 
	 * @param parameters
	 */
	public Person create(String... parameters){
		return new LegalPerson(parameters[0]);
	}
}//end LegalPersonFactory
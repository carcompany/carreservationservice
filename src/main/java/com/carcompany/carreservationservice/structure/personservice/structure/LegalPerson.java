package com.carcompany.carreservationservice.structure.personservice.structure;


/**
 * @author Sebastian
 * @version 1.0
 * @created 28-Aug-2020 17:10:48
 */
public class LegalPerson extends Person {

	private String name;

	public LegalPerson(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
}//end LegalPerson
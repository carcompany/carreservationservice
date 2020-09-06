package com.carcompany.carreservationservice.structure.contentservice.structure;

/**
 * @author Kevin, Benjamin
 * @version 1.1
 * @created 28-Aug-2020 17:10:42
 */
public abstract class Content {

	private String name;

	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */

	public void setName(String name) {
		this.name = name;
	}
}
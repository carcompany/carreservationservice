package com.carcompany.carreservationservice.structure.Content.structure;


/**
 * @author Kevin, Benjamin
 * @version 1.1
 * @created 28-Aug-2020 17:10:46
 */
public class File extends Content {

	private Object object;

	public Object getObject(){
		return object;
	}

	/**
	 * 
	 * @param object
	 */
	public void setObject(Object object){
		this.object = object;
	}
}
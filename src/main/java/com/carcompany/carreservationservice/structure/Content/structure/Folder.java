package com.carcompany.carreservationservice.structure.Content.structure;


/**
 * @author Kevin
 * @version 1.0
 * @created 28-Aug-2020 17:10:46
 */
public class Folder extends Content {

	protected String name;
	private Content[] contents;
	public Content m_Content;

	public Folder(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	public String getName(){
		return "";
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name){

	}

	public Content[] getContents(){
		return null;
	}

	/**
	 * 
	 * @param content
	 */
	public void addContent(Content content){

	}

	/**
	 * 
	 * @param content
	 */
	public void removeContent(Content content){

	}
}//end Folder
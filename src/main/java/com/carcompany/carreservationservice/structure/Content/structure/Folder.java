package com.carcompany.carreservationservice.structure.Content.structure;

import java.util.HashMap;

/**
 * @author Kevin, Benjamin
 * @version 1.1
 * @created 28-Aug-2020 17:10:46
 */
public class Folder extends Content {

	private HashMap<String, Content> contents = new HashMap<>();

	public HashMap<String, Content> getContents(){
		return contents;
	}
	/**
	 * 
	 * @param content
	 */
	public void addContent(Content content){
		contents.put(content.getName(), content);
		}
	/**
	 * 
	 * @param content
	 */
	public void removeContent(Content content){
		contents.remove(content.getName());
	}
}
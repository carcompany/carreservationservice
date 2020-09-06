package com.carcompany.carreservationservice.structure.contentservice.structure;

import java.util.HashMap;

/**
 * @author Kevin, Benjamin
 * @version 1.1
 * @created 28-Aug-2020 17:10:46
 */
public class Folder extends Content {

	private HashMap<String, Content> contents = new HashMap<>();

	public HashMap<String, Content> getContents() {
		return contents;
	}

	/**
	 * 
	 * @param content
	 */
	public Boolean addContent(Content content) {
		contents.put(content.getName(), content);
		if (contents.containsKey(content.getName())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param content
	 */
	public Boolean removeContent(String key) {
		contents.remove(key);
		if (contents.containsKey(key)) {
			return false;
		} else {
			return true;
		}

	}
}
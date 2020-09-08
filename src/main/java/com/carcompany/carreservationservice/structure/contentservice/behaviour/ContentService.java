package com.carcompany.carreservationservice.structure.contentservice.behaviour;

import java.util.Map;

import com.carcompany.carreservationservice.structure.contentservice.structure.Content;

/**
 * @author Kevin, Benjamin
 * @version 1.1
 * @created 28-Aug-2020 17:10:42
 */
public abstract class ContentService {

	private static ContentService instance;

	public static ContentService getInstance() {
		if (instance == null) {
			instance = new ContentServiceImplementation();
		}

		return instance;
	}

	/**
	 * 
	 * @param object
	 * @return
	 * @throws Exception
	 */
	public abstract Boolean addContent(Object object, String name);

	public abstract Map<String, Content> getContents();

	public abstract Boolean removeContent(String string);
}
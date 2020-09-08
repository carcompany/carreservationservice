package com.carcompany.carreservationservice.structure.contentservice.behaviour;

import com.carcompany.carreservationservice.structure.contentservice.structure.Content;
import com.carcompany.carreservationservice.structure.contentservice.structure.ContentType;

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
	 * @param object, contentType
	 * @return
	 */
	public abstract Boolean addContent(Object object, ContentType contentType);

	public abstract Boolean removeContent(String string);

	public abstract Content getSelectedContent(String contentPath);
}
package com.carcompany.carreservationservice.structure.Content.behaviour;

import com.carcompany.carreservationservice.structure.Content.structure.File;
import com.carcompany.carreservationservice.structure.Content.structure.Folder;

/**
 * @author Kevin, Benjamin
 * @version 1.1
 * @created 28-Aug-2020 17:10:42
 */
public class ContentServiceImplementation implements ContentService {

	private Folder folder;

	public ContentServiceImplementation() {
		folder = new Folder();
	}
	/**
	 * 
	 * @param object
	 */
	public Boolean addContent(Object object) {
		File file = new File();
		file.setObject(object);
		folder.addContent(file);
		
		return true;

	}
}
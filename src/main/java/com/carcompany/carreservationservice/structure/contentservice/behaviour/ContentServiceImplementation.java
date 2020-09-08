package com.carcompany.carreservationservice.structure.contentservice.behaviour;

import java.util.Map;

import com.carcompany.carreservationservice.structure.contentservice.structure.Content;
import com.carcompany.carreservationservice.structure.contentservice.structure.File;
import com.carcompany.carreservationservice.structure.contentservice.structure.Folder;

/**
 * @author Kevin, Benjamin
 * @version 1.1
 * @created 28-Aug-2020 17:10:42
 */
public class ContentServiceImplementation extends ContentService {

	private Folder folder;
	private File file;

	public ContentServiceImplementation() {
		folder = new Folder();
	}

	/**
	 * 
	 * @param object
	 * @throws Exception
	 */
	public Boolean addContent(Object object, String name) {
		file = new File();
		file.setName(name);
		file.setObject(object);
		folder.addContent(file);
		if (folder.addContent(file) == true) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean removeContent(String key) {
		folder.removeContent(key);
		if (folder.removeContent(key) == true) {
			return true;
		} else {
			return false;
		}
	}

	public Map<String, Content> getContents() {
		return folder.getContents();
	}
}
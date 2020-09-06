package com.carcompany.carreservationservice.structure.contentservice.behaviour;

import java.util.Map;

import com.carcompany.carreservationservice.structure.contentservice.structure.Content;

/**
 * @author Kevin, Benjamin
 * @version 1.1
 * @created 28-Aug-2020 17:10:42
 */
public interface ContentService {

	/**
	 * 
	 * @param object
	 * @return 
	 * @throws Exception 
	 */
	public Boolean addContent(Object object, String name);
	public Map<String, Content> getContents();
	public Boolean removeContent(String string);
} 
package com.carcompany.carreservationservice.structure.contentservice.behaviour;

import com.carcompany.carreservationservice.structure.contentservice.structure.Content;
import com.carcompany.carreservationservice.structure.contentservice.structure.ContentType;

/**
 * @author Kevin, Benjamin
 * @version 1.1
 * @created 28-Aug-2020 17:10:42
 */
public interface ContentService {

	/**
	 * 
	 * @param object, contentType
	 * @return
	 */
	public Boolean addContent(Object object, ContentType contentType);
	public Boolean removeContent(String string);
	public Content getSelectedContent(String contentPath);
}
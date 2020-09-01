package com.carcompany.carresverationservice.structure.Content;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.carcompany.carreservationservice.structure.Content.behaviour.ContentService;
import com.carcompany.carreservationservice.structure.Content.behaviour.ContentServiceImplementation;
import com.carcompany.carreservationservice.structure.Content.structure.File;

/**
 * @author Benjamin
 * @version 1.0
 * @created 01-Sep-2020 17:10:46
 */

class ContentServiceTest {

	private static ContentService contentService;
	private static File file;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		contentService = new ContentServiceImplementation();
		file = new File();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		contentService = null;
		file = null;
	}

	@Test
	@Order(1)
	public void canContentBeAdded() {
		file.setName("Testfile");
		Assertions.assertTrue(contentService.addContent(file));
	}
}
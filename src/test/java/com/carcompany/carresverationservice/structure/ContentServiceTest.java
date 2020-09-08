package com.carcompany.carresverationservice.structure;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.carcompany.carreservationservice.structure.contentservice.behaviour.ContentService;
import com.carcompany.carreservationservice.structure.contentservice.behaviour.ContentServiceImplementation;
import com.carcompany.carreservationservice.structure.contentservice.structure.Content;
import com.carcompany.carreservationservice.structure.contentservice.structure.File;

/**
 * @author Benjamin
 * @version 1.0
 * @created 01-Sep-2020 17:10:46
 */

class ContentServiceTest {

	private static ContentService contentService;
	private static File receipt;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		contentService = ContentService.getInstance();
		receipt = new File();
	}

	@Test
	@Order(1)
	public void canContentBeAdded() {
		assertTrue(contentService.addContent(receipt, "receiptCust"));
	}

	@Test
	@Order(2)
	public void canContentBeObtained() {
		contentService.addContent(receipt, "receiptCust");
		Map<String, Content> map = contentService.getContents();
		Content val = map.get("receiptCust");
		assertEquals("receiptCust", val.getName());
	}

	@Test
	@Order(3)
	public void canContentBeRemoved() {
		contentService.addContent(receipt, "receiptCust");
		assertTrue(contentService.removeContent("receiptCust"));
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		contentService = null;
		receipt = null;
	}
}
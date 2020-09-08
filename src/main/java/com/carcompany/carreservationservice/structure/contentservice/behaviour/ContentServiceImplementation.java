package com.carcompany.carreservationservice.structure.contentservice.behaviour;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.carcompany.carreservationservice.structure.contentservice.structure.Content;
import com.carcompany.carreservationservice.structure.contentservice.structure.ContentType;
import com.carcompany.carreservationservice.structure.contentservice.structure.File;
import com.carcompany.carreservationservice.structure.contentservice.structure.Folder;
import com.carcompany.carreservationservice.structure.contentservice.structure.Report;
import com.carcompany.carreservationservice.structure.paymentservice.structure.Payment;
import com.carcompany.carreservationservice.structure.bookingservice.structure.Booking;

/**
 * @version 1.1
 * @created 28-Aug-2020 17:10:42
 */
public class ContentServiceImplementation extends ContentService {

	private static ContentServiceImplementation instance;
	private Folder rootFolder;

	public ContentServiceImplementation() {
		rootFolder = new Folder();
	}

	public static ContentServiceImplementation getInstance() {
		if (ContentServiceImplementation.instance == null) {
			ContentServiceImplementation.instance = new ContentServiceImplementation();
		}
		return ContentServiceImplementation.instance;
	}

	public Boolean addContent(Object object, ContentType contentType) {
		File file = new File();
		String fileName = null;

		SimpleDateFormat format1 = new SimpleDateFormat("MM-yyyy");
		String folderName = format1.format(Calendar.getInstance().getTime());

		Folder folder;

		if (rootFolder.getContents().containsKey(folderName)) {
			folder = (Folder) rootFolder.getContents().get(folderName);
		} else {
			folder = new Folder();
			folder.setName(folderName);
			rootFolder.addContent(folder);
		}

		Report report;

		if (folder.getContents().containsKey("Report")) {
			report = (Report) folder.getContents().get("Report");
		} else {
			report = new Report();
			report.setName("Report");
			folder.addContent(report);
		}

		switch (contentType) {
			case PAYMENT:
				Payment payment = ((Payment) object);
				fileName = "Payment_" + payment.getId();
				report.increment(payment.getPaymentType(), payment.getCurrencyAmount());
				break;
			case BOOKING:
				Booking booking = ((Booking) object);
				fileName = "Booking_" + booking.getId();
				report.increment(booking.getFooter().getPayment().getPaymentType());
				break;
			default:
				break;
		}

		file.setName(fileName);
		file.setObject(object);

		return folder.addContent(file);
	}

	public Boolean removeContent(String key) {
		return rootFolder.removeContent(key);
	}

	@Override
	public Content getSelectedContent(String contentPath) {
		Content content = rootFolder;
		String[] contentPathParts = contentPath.split("/");
		for (String contentPathPart : contentPathParts) {
			if (contentPathPart.length() > 0) {
				content = ((Folder) content).getContents().get(contentPathPart);
			}
		}
		return content;
	}
}
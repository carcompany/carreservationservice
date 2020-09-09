package com.carcompany.carreservationservice.structure.statisticsservice.structure;

import com.carcompany.carreservationservice.structure.contentservice.behaviour.ContentServiceImplementation;
import com.carcompany.carreservationservice.structure.contentservice.structure.Report;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PaymentType;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.ApplePayExternalPaymentService;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.BankExternalPaymentService;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.GooglePayExternalPaymentService;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.PayPalExternalPaymentService;

/**
 * This class implements each operation declared by Visitor. Each operation
 * implements a fragment of the algorithm defined for the corresponding class of
 * object in the structure. ConcreteVisitor provides the context for the algorithm
 * and stores its local state. This state often accumulates results during the
 * traversal of the structure.
 */
public class EnglishBookingVisitor implements BookingVisitor {
	
	private String selectedFolder;
	private ContentServiceImplementation contentService = ContentServiceImplementation.getInstance();

	public EnglishBookingVisitor(String selectedFolder) {
		this.selectedFolder = selectedFolder;
	}
	
	/**
	 * 
	 * @param externalPaymentService
	 */
	public void visit(PayPalExternalPaymentService externalPaymentService) {
		
		String path =  selectedFolder + "/Report";
		Report report = (Report) contentService.getSelectedContent(path);
		externalPaymentService.setPaymentSum(report.getPaymentNumbers(PaymentType.PAYPAL));
		externalPaymentService.setBookingSum(report.getBookingNumbers(PaymentType.PAYPAL));
	}
	
	/**
	 * 
	 * @param externalPaymentService
	 */
	public void visit(ApplePayExternalPaymentService externalPaymentService) {

		String path =  selectedFolder + "/Report";
		Report report = (Report) contentService.getSelectedContent(path);
		externalPaymentService.setPaymentSum(report.getPaymentNumbers(PaymentType.APPLE_PAY));
		externalPaymentService.setBookingSum(report.getBookingNumbers(PaymentType.APPLE_PAY));
	}

	/**
	 * 
	 * @param externalPaymentService
	 */
	public void visit(GooglePayExternalPaymentService externalPaymentService) {

		String path =  selectedFolder + "/Report";
		Report report = (Report) contentService.getSelectedContent(path);
		externalPaymentService.setPaymentSum(report.getPaymentNumbers(PaymentType.GOOGLE_PAY));
		externalPaymentService.setBookingSum(report.getBookingNumbers(PaymentType.GOOGLE_PAY));
	}

	/**
	 * 
	 * @param externalPaymentService
	 */
	public void visit(BankExternalPaymentService externalPaymentService) {
		
		String path =  selectedFolder + "/Report";
		Report report = (Report) contentService.getSelectedContent(path);
		externalPaymentService.setPaymentSum(report.getPaymentNumbers(PaymentType.BANK));
		externalPaymentService.setBookingSum(report.getBookingNumbers(PaymentType.BANK));
	}
}
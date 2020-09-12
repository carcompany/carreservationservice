package com.carcompany.carreservationservice.structure.statisticsservice.structure;

import com.carcompany.carreservationservice.structure.contentservice.behaviour.ContentService;
import com.carcompany.carreservationservice.structure.contentservice.structure.Report;
import com.carcompany.carreservationservice.structure.paymentservice.structure.PaymentType;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.ApplePayExternalPaymentStatistic;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.BankExternalPaymentStatistic;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.GooglePayExternalPaymentStatistic;
import com.carcompany.carreservationservice.structure.statisticsservice.structure.services.PayPalExternalPaymentStatistic;

/**
 * This class implements each operation declared by Visitor. Each operation
 * implements a fragment of the algorithm defined for the corresponding class of
 * object in the structure. ConcreteVisitor provides the context for the
 * algorithm and stores its local state. This state often accumulates results
 * during the traversal of the structure.
 */
public class GermanBookingVisitor implements BookingVisitor {

	private String selectedFolder;

	public GermanBookingVisitor(String selectedFolder) {
		this.selectedFolder = selectedFolder;
	}

	/**
	 * 
	 * @param externalPaymentService
	 */
	public void visit(PayPalExternalPaymentStatistic externalPaymentService) {
		try {
			String path = selectedFolder + "/Report";
			Report report = (Report) ContentService.getInstance().getSelectedContent(path);
			externalPaymentService.setPaymentSum(report.getPaymentNumbers(PaymentType.PAYPAL));
			externalPaymentService.setBookingSum(report.getBookingNumbers(PaymentType.PAYPAL));
		} catch (Exception err) {
			externalPaymentService.setPaymentSum(0);
			externalPaymentService.setBookingSum(0);
		}
	}

	/**
	 * 
	 * @param externalPaymentService
	 */
	public void visit(ApplePayExternalPaymentStatistic externalPaymentService) {
		try {
			String path = selectedFolder + "/Report";
			Report report = (Report) ContentService.getInstance().getSelectedContent(path);
			externalPaymentService.setPaymentSum(report.getPaymentNumbers(PaymentType.APPLE_PAY));
			externalPaymentService.setBookingSum(report.getBookingNumbers(PaymentType.APPLE_PAY));
		} catch (Exception err) {
			externalPaymentService.setPaymentSum(0);
			externalPaymentService.setBookingSum(0);
		}
	}

	/**
	 * 
	 * @param externalPaymentService
	 */
	public void visit(GooglePayExternalPaymentStatistic externalPaymentService) {
		try {
			String path = selectedFolder + "/Report";
			Report report = (Report) ContentService.getInstance().getSelectedContent(path);
			externalPaymentService.setPaymentSum(report.getPaymentNumbers(PaymentType.GOOGLE_PAY));
			externalPaymentService.setBookingSum(report.getBookingNumbers(PaymentType.GOOGLE_PAY));
		} catch (Exception err) {
			externalPaymentService.setPaymentSum(0);
			externalPaymentService.setBookingSum(0);
		}
	}

	/**
	 * 
	 * @param externalPaymentService
	 */
	public void visit(BankExternalPaymentStatistic externalPaymentService) {
		try {
			String path = selectedFolder + "/Report";
			Report report = (Report) ContentService.getInstance().getSelectedContent(path);
			externalPaymentService.setPaymentSum(report.getPaymentNumbers(PaymentType.BANK));
			externalPaymentService.setBookingSum(report.getBookingNumbers(PaymentType.BANK));
		} catch (Exception err) {
			externalPaymentService.setPaymentSum(0);
			externalPaymentService.setBookingSum(0);
		}
	}
}